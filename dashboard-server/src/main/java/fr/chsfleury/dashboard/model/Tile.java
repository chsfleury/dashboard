package fr.chsfleury.dashboard.model;

import fr.chsfleury.dashboard.service.strategies.run.Runner;

import java.time.Duration;
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

    float getTop();
    void setTop(float top);

    float getLeft();
    void setLeft(float left);

    float getWidth();
    void setWidth(float width);

    float getHeight();
    void setHeight(float height);

    String getId();
    String getType();
    String getEndpoint();

    Optional<String> getTarget();
    Optional<String> getToken();
    Optional<Duration> getRefresh();
    Optional<Duration> getHistory();

    int getPoints();
    Runner getRunner();

}
