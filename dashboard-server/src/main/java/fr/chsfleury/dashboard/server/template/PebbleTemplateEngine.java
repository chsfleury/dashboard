package fr.chsfleury.dashboard.server.template;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.error.PebbleException;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * @author Charles Fleury
 * @since 23/07/17.
 */
@AllArgsConstructor
public class PebbleTemplateEngine {
    private final PebbleEngine engine;
    private final String prefix;

    public String render(@NonNull String templateName) {
        return render(templateName, null);
    }

    public String render(@NonNull String templateName, Map<String, Object> model) {
        try {
            StringWriter writer = new StringWriter();
            PebbleTemplate template = this.engine.getTemplate(prefix + templateName);
            if (model == null) {
                template.evaluate(writer);
            } else {
                template.evaluate(writer, model);
            }
            return writer.toString();
        } catch (IOException | PebbleException e) {
            throw new IllegalArgumentException(e);
        }
    }
}