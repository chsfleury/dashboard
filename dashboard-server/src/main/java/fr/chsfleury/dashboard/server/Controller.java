package fr.chsfleury.dashboard.server;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.lexer.Syntax;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import fr.chsfleury.dashboard.model.Tile;
import fr.chsfleury.dashboard.model.Dashboard;
import fr.chsfleury.dashboard.model.DefaultTile;
import fr.chsfleury.dashboard.server.template.PebbleTemplateEngine;
import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

/**
 * @author Charles Fleury
 * @since 23/07/17.
 */
public class Controller {

    private PebbleTemplateEngine templateEngine;

    public Controller() {

        Syntax syntax = new Syntax.Builder()
                .setPrintOpenDelimiter("[[")
                .setPrintCloseDelimiter("]]")
                .setCommentOpenDelimiter("[#")
                .setCommentCloseDelimiter("#]")
                .build();

        PebbleEngine pebbleEngine = new PebbleEngine.Builder()
                .loader(new ClasspathLoader())
                .syntax(syntax)
                .build();

        templateEngine = new PebbleTemplateEngine(pebbleEngine, "templates/");
    }

    public void init() {
        get("/", this::showDashboard);

        get("/hello", (req, res) -> "Hello World");
    }

    private String showDashboard(Request req, Response res) {
        Map<String, Object> model = new HashMap<>();

        Tile tile0 = DefaultTile.builder().x(0).y(0).w(2).h(1).build();
        Tile tile1 = DefaultTile.builder().x(2).y(0).w(1).h(2).build();
        Tile tile2 = DefaultTile.builder().x(1).y(1).w(1).h(2).build();
        Tile tile3 = DefaultTile.builder().x(4).y(5).w(1).h(2).build();
//        Tile tile1 = new DefaultTile(0, 0, 2, 1);
//        Tile tile2 = new DefaultTile(2, 0, 1, 2);
//        Tile tile3 = new DefaultTile(0, 1, 1, 1);
//        Tile tile4 = new DefaultTile(1, 1, 1, 2);
//        Tile tile5 = new DefaultTile(0, 2, 1, 1);
//        Tile tile6 = new DefaultTile(2, 2, 1, 1);
//        Dashboard dashboard = new Dashboard(Arrays.asList(tile1, tile2, tile3, tile4, tile5, tile6));
        Dashboard dashboard = new Dashboard(Arrays.asList(tile0, tile1, tile2, tile3));

        model.put("tiles", dashboard.getTiles().values());

        return templateEngine.render("dashboard.html", model);
    }

}
