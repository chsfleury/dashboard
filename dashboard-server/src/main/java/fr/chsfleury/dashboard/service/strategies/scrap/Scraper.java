package fr.chsfleury.dashboard.service.strategies.scrap;

import java.util.Optional;

public interface Scraper {
    Optional<String> scrap();
}
