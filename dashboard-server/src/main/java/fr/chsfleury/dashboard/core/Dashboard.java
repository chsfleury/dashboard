package fr.chsfleury.dashboard.core;

import fr.chsfleury.dashboard.api.HtmlTile;
import fr.chsfleury.dashboard.api.Tile;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author Charles Fleury
 * @since 24/07/17.
 */
public class Dashboard {

    private List<Tile> tiles;
    private int width;
    private int height;

    public Dashboard(List<Tile> ts) {
        width = 1;
        height = 1;
        tiles = ts;

        for(Tile tile : tiles) {
            int w = tile.getX() + tile.getW();
            int h = tile.getY() + tile.getH();
            if(w > width) {
                width = w;
            }

            if(h > height) {
                height = h;
            }
        }
    }

    public List<HtmlTile> render() {
        return tiles.stream()
                .map(tile -> new SimpleHtmlTile(
                        norm(tile.getY(), height),
                        norm(tile.getX(), width),
                        norm(tile.getW(), width),
                        norm(tile.getH(), height)
                ))
                .collect(toList());
    }

    private float norm(int value, float dim) {
        return 100f * value / dim;
    }

}
