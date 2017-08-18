package fr.chsfleury.dashboard.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Charles Fleury
 * @since 24/07/17.
 */
public class Dashboard {

    @Getter
    private Map<String, Tile> tiles;

    public Dashboard(final List<Tile> ts) {
        int width = 1;
        int height = 1;
        tiles = new HashMap<>();

        for (Tile tile : ts) {
            tiles.put(tile.getId(), tile);
            int w = tile.getX() + tile.getW();
            int h = tile.getY() + tile.getH();
            if(w > width) {
                width = w;
            }

            if(h > height) {
                height = h;
            }
        }

        for(Tile tile : ts) {
            tile.setTop(norm(tile.getY(), height));
            tile.setLeft(norm(tile.getX(), width));
            tile.setWidth(norm(tile.getW(), width));
            tile.setHeight(norm(tile.getH(), height));
        }
    }

    private float norm(final int value, final float dim) {
        return 100f * value / dim;
    }

}
