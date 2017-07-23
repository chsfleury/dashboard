package fr.chsfleury.dashboard.core;

import fr.chsfleury.dashboard.api.HtmlTile;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Charles Fleury
 * @since 24/07/17.
 */
@Getter
@AllArgsConstructor
public class SimpleHtmlTile implements HtmlTile {

    private float top, left, width, height;

}
