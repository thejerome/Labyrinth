package com.efimchick.labyrinth.map.mapsource;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.MapCharEncoder;
import com.efimchick.labyrinth.map.position.Position;

import java.io.BufferedReader;
import java.io.StringReader;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * Created by Evgenii_Efimchik on 09-Oct-17.
 */
public class StringMapSource implements MapSource {
    private final String s;
    private final MapCharEncoder encoder = MapCharEncoder.dotOctotorp();

    public StringMapSource(String s) {
        this.s = s;
    }

    @Override
    public Stream<Cell> cellsStream() {

        AtomicInteger row = new AtomicInteger(-1);
        AtomicInteger col = new AtomicInteger(-1);

        return new BufferedReader(new StringReader(s)).lines()
                .flatMap(l -> {
                    row.incrementAndGet();
                    col.set(-1);
                    return l.chars()
                            .mapToObj(c -> (char) c)
                            .peek(c -> col.getAndIncrement())
                            .filter(encoder::covers)
                            .map(c -> new Cell(
                                    Position.of(row.get(), col.get()),
                                    encoder.cellType(c))
                            );
                });
    }
}
