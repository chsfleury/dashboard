package fr.chsfleury.dashboard.json;

import lombok.Data;

@Data
public class TileJson {
    private String id, endpoint, token, refresh, history, target;
    private int x, y, w, h;
}
