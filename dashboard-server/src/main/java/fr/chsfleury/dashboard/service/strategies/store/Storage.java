package fr.chsfleury.dashboard.service.strategies.store;

import fr.chsfleury.dashboard.core.Measure;

import java.util.List;

public interface Storage {
    boolean store(List<Measure<Float>> values);
    List<Measure<Float>> getValues();
}
