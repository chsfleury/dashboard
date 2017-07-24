package fr.chsfleury.dashboard.core;

import fr.chsfleury.dashboard.api.Tile;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * @author Charles Fleury
 * @since 24/07/17.
 */
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class SimpleTile implements Tile {
    private String id, endpoint, token, refresh, history, target;
    private int x, y, w, h;

    @Override
    public Optional<String> getTarget() {
        return ofNullable(target);
    }

    @Override
    public Optional<String> getToken() {
        return ofNullable(token);
    }

    @Override
    public Optional<String> getRefresh() {
        return ofNullable(refresh);
    }

    @Override
    public Optional<String> getHistory() {
        return ofNullable(history);
    }
}
