package fr.chsfleury.dashboard.service.strategies.scrap.impl;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import fr.chsfleury.dashboard.model.Tile;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

import java.util.Optional;

@Slf4j
public abstract class AbstractScraper {

    protected Tile tile;

    protected Optional<String> call(GetRequest request) {
        try {
            HttpResponse<String> response = request.asString();
            if(response.getStatus() == HttpStatus.SC_OK) {
                return Optional.ofNullable(response.getBody());
            }
        } catch (UnirestException e) {
            log.error("error occured", e);
        }
        return Optional.empty();
    }
}
