package fr.chsfleury.dashboard.service.strategies.extract.impl;

import com.jayway.jsonpath.JsonPath;
import fr.chsfleury.dashboard.core.Measure;
import fr.chsfleury.dashboard.service.strategies.extract.Extractor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.singletonList;

public class ValueExtractor extends AbstractExtractor implements Extractor {

    @Override
    public List<Measure<Float>> extract(final String json) {
        Float value;
        LocalDateTime dateTime = LocalDateTime.now();
        if (tile.getTarget().isPresent()) {
            value = JsonPath.read(json, tile.getTarget().get());
        } else {
            value = Float.valueOf(json);
        }
        Measure<Float> measure = new Measure<>(value, dateTime);
        return singletonList(measure);
    }

}
