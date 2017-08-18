package fr.chsfleury.dashboard;

import com.mashape.unirest.http.Unirest;
import fr.chsfleury.dashboard.server.Controller;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;
import static spark.Spark.stop;

/**
 * @author Charles Fleury
 * @since 23/07/17.
 */
@Slf4j
public class DashboardApp {

    public static void main(String[] args) {
        port(8000);
        staticFileLocation("/public");

        Controller controller = new Controller();
        controller.init();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                log.info("shutdown Unirest...");
                Unirest.shutdown();
            } catch (IOException e) {
                log.error("can't shutdown Unirest");
            }
        }));
    }

}
