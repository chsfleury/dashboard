package fr.chsfleury.dashboard;

import fr.chsfleury.dashboard.server.Controller;

import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

/**
 * @author Charles Fleury
 * @since 23/07/17.
 */
public class DashboardApp {

    public static void main(String[] args) {
        port(8000);
        staticFileLocation("/public");

        Controller controller = new Controller();
        controller.init();
    }

}
