package fr.chsfleury.dashboard.service.strategies.run.impl;

import fr.chsfleury.dashboard.service.strategies.extract.Extractor;
import fr.chsfleury.dashboard.service.strategies.render.Renderer;
import fr.chsfleury.dashboard.service.strategies.run.Runner;
import fr.chsfleury.dashboard.service.strategies.scrap.Scraper;
import fr.chsfleury.dashboard.service.strategies.store.Storage;

public class OnDemandRunner extends AbstractRunner implements Runner {

    public OnDemandRunner(final Scraper scraper, final Extractor extractor, final Storage storage, final Renderer renderer) {
        super(scraper, extractor, storage, renderer);
    }

    @Override
    public void run() {
        doRun();
    }

}
