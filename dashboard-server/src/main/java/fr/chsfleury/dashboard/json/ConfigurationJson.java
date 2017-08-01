package fr.chsfleury.dashboard.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ConfigurationJson {

    @JsonProperty("import")
    private List<String> imports;

    @JsonProperty("boards")
    private List<DashboardJson> boards;

}
