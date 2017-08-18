package fr.chsfleury.dashboard.service.strategies.scrap.impl;

import com.mashape.unirest.http.Unirest;
import fr.chsfleury.dashboard.service.strategies.scrap.Scraper;

import java.util.Optional;

public class PublicScraper extends AbstractScraper implements Scraper {

    @Override
    public Optional<String> scrap() {
        return call(Unirest.get(tile.getEndpoint()));
    }

}
