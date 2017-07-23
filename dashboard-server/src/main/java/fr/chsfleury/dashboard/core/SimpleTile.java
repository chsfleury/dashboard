package fr.chsfleury.dashboard.core;

import fr.chsfleury.dashboard.api.Tile;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Charles Fleury
 * @since 24/07/17.
 */
@Getter
@AllArgsConstructor
public class SimpleTile implements Tile {
    private int x, y, w, h;
}
