package fr.chsfleury.dashboard.service.strategies.store.impl;

import fr.chsfleury.dashboard.core.Measure;
import fr.chsfleury.dashboard.model.Tile;
import fr.chsfleury.dashboard.service.strategies.store.Storage;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.sort;

public class InMemoryStorage implements Storage {

    private Duration limit;

    @Getter
    private LinkedList<Measure<Float>> values;

    public InMemoryStorage(final Tile tile) {
        this.limit = tile.getHistory().orElse(null);
        values = new LinkedList<>();
    }

    @Override
    public boolean store(final List<Measure<Float>> vs) {
        if (vs != null && !vs.isEmpty()) {
            removePastValues();
            values.addAll(vs);
            sort(values);
            return true;
        }
        return false;
    }

    private void removePastValues() {
        if(limit != null) {
            final LocalDateTime limitDateTime = LocalDateTime.now().minus(limit);
            values.removeIf(measure -> measure.getDateTime().isBefore(limitDateTime));
        } else {
            values.clear();
        }
    }
}
