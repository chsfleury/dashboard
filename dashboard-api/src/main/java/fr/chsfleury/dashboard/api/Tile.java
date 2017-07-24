package fr.chsfleury.dashboard.api;

import java.util.Optional;

/**
 * @author Charles Fleury
 * @since 23/07/17.
 */
public interface Tile {

    int getX();
    int getY();
    int getW();
    int getH();
    String getId();
    String getEndpoint();
    Optional<String> getTarget();
    Optional<String> getToken();
    Optional<String> getRefresh();
    Optional<String> getHistory();

}
