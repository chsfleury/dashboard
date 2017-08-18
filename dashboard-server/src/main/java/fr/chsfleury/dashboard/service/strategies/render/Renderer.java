package fr.chsfleury.dashboard.service.strategies.render;

import fr.chsfleury.dashboard.core.Measure;

import java.util.List;

public interface Renderer {
    String render(List<Measure<Float>> values);
}
