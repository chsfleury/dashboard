package fr.chsfleury.dashboard.service.strategies.run.impl;

import fr.chsfleury.dashboard.core.Measure;
import fr.chsfleury.dashboard.model.Tile;
import fr.chsfleury.dashboard.service.strategies.extract.Extractor;
import fr.chsfleury.dashboard.service.strategies.render.Renderer;
import fr.chsfleury.dashboard.service.strategies.scrap.Scraper;
import fr.chsfleury.dashboard.service.strategies.store.Storage;
import lombok.Getter;

import java.util.List;
import java.util.Optional;

public abstract class AbstractRunner {

    protected Scraper scraper;
    protected Extractor extractor;
    protected Storage storage;
    protected Renderer renderer;

    @Getter
    protected String chart;

    protected AbstractRunner(final Scraper scraper, final Extractor extractor, final Storage storage, final Renderer renderer) {
        this.scraper = scraper;
        this.extractor = extractor;
        this.storage = storage;
        this.renderer = renderer;
    }

    protected void doRun() {
        Optional<String> optContent = scraper.scrap();
        if(optContent.isPresent()) {
            List<Measure<Float>> measures = extractor.extract(optContent.get());
            if(storage.store(measures)) {
                chart = renderer.render(storage.getValues());
            }
        }
    }

}
