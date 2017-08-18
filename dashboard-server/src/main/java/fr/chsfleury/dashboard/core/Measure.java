package fr.chsfleury.dashboard.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Measure<T> implements Comparable<Measure<T>> {

    private T value;
    private LocalDateTime dateTime;

    @Override
    public int compareTo(final Measure<T> o) {
        return dateTime.compareTo(o.dateTime);
    }
}
