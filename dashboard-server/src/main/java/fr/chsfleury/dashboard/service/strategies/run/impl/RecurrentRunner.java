package fr.chsfleury.dashboard.service.strategies.run.impl;

import com.google.common.util.concurrent.RateLimiter;
import fr.chsfleury.dashboard.model.Tile;
import fr.chsfleury.dashboard.service.strategies.extract.Extractor;
import fr.chsfleury.dashboard.service.strategies.render.Renderer;
import fr.chsfleury.dashboard.service.strategies.run.Runner;
import fr.chsfleury.dashboard.service.strategies.scrap.Scraper;
import fr.chsfleury.dashboard.service.strategies.store.Storage;
import lombok.Setter;

import java.time.Duration;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static java.time.temporal.ChronoUnit.MILLIS;

public class RecurrentRunner extends AbstractRunner implements Runner {

    private RateLimiter rateLimiter;

    @Setter
    private boolean loop = true;

    public RecurrentRunner(final Tile tile, final Scraper scraper, final Extractor extractor, final Storage storage, final Renderer renderer) {
        super(scraper, extractor, storage, renderer);
        Optional<Duration> refresh = tile.getRefresh();
        checkArgument(refresh.isPresent());
        rateLimiter = RateLimiter.create(1000 / refresh.get().get(MILLIS));
    }

    @Override
    public void run() {
        while (loop) {
            rateLimiter.acquire();
            doRun();
        }
    }
}
