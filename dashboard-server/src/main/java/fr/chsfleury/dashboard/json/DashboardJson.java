package fr.chsfleury.dashboard.json;

import lombok.Data;

import java.util.List;

@Data
public class DashboardJson {

    private String title;
    private List<TileJson> tiles;

}
