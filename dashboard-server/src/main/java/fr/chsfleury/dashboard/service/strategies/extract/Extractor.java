package fr.chsfleury.dashboard.service.strategies.extract;

import fr.chsfleury.dashboard.core.Measure;

import java.util.List;

public interface Extractor {
    List<Measure<Float>> extract(String json);
}
