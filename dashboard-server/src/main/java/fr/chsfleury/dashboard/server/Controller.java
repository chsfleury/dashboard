package fr.chsfleury.dashboard.server;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.lexer.Syntax;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import fr.chsfleury.dashboard.api.Tile;
import fr.chsfleury.dashboard.core.Dashboard;
import fr.chsfleury.dashboard.core.SimpleTile;
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

        Tile tile1 = new SimpleTile(0, 0, 2, 1);
        Tile tile2 = new SimpleTile(2, 0, 1, 2);
        Tile tile3 = new SimpleTile(0, 1, 1, 1);
        Tile tile4 = new SimpleTile(1, 1, 1, 2);
        Tile tile5 = new SimpleTile(0, 2, 1, 1);
        Tile tile6 = new SimpleTile(2, 2, 1, 1);
        Dashboard dashboard = new Dashboard(Arrays.asList(tile1, tile2, tile3, tile4, tile5, tile6));

        model.put("tiles", dashboard.render());

        return templateEngine.render("dashboard.html", model);
    }

}
