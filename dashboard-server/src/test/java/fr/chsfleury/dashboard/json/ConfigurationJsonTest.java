package fr.chsfleury.dashboard.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import spark.utils.ResourceUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationJsonTest {

    @Test
    public void testDeserialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ConfigurationJson configurationJson = mapper.readValue(ResourceUtils.getURL("classpath:sample_config.json"), ConfigurationJson.class);
        assertThat(configurationJson).isNotNull();
    }

}