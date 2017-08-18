package fr.chsfleury.dashboard.service.strategies.scrap.impl;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import fr.chsfleury.dashboard.service.strategies.scrap.Scraper;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Optional;

@Builder
@AllArgsConstructor
public class AuthenticatedHeaderScraper extends AbstractScraper implements Scraper {

    private String header;
    private String token;

    @Override
    public Optional<String> scrap() {
        GetRequest request = Unirest.get(tile.getEndpoint());
        request.header(header, token);
        return call(request);
    }
}
