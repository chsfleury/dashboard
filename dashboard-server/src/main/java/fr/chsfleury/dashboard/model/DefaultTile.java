package fr.chsfleury.dashboard.model;

import fr.chsfleury.dashboard.service.strategies.run.Runner;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.MILLIS;
import static java.util.Optional.ofNullable;

/**
 * @author Charles Fleury
 * @since 24/07/17.
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class DefaultTile implements Tile {
    private String id, type, endpoint, token, refresh, history, target;

    // SYSTEM
    private Runner runner;

    // GRID
    private int x, y, w, h;

    // HTML
    @Setter
    private float top, left, width, height;

    @Override
    public Optional<String> getTarget() {
        return ofNullable(target);
    }

    @Override
    public Optional<String> getToken() {
        return ofNullable(token);
    }

    @Override
    public Optional<Duration> getRefresh() {
        return ofNullable(refresh).map(Duration::parse);
    }

    @Override
    public Optional<Duration> getHistory() {
        return ofNullable(history).map(Duration::parse);
    }

    @Override
    public int getPoints() {
        Optional<Duration> r = getRefresh();
        Optional<Duration> h = getHistory();
        if (h.isPresent() && r.isPresent()) {
            long refreshMs = r.get().get(MILLIS);
            long historyMs = h.get().get(MILLIS);
            return (int) (historyMs / refreshMs);
        } else {
            return 1;
        }
    }
}
