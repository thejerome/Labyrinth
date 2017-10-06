package com.efimchick.labyrinth.map.mapsource;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.position.Position;
import com.efimchick.labyrinth.map.position.X;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.efimchick.labyrinth.map.CellType.EMPTY;
import static com.efimchick.labyrinth.map.CellType.WALL;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
public class BasicStringMapSource implements MapSource {
    private final String mapAsString;

    public BasicStringMapSource(String mapAsString) {
        this.mapAsString = mapAsString;
    }

    @Override
    public Stream<Cell> cellsStream() {

        Stream.Builder<Cell> builder = Stream.builder();

        String[] lines = mapAsString.split("\n");

        return null;

//        return Arrays.stream(mapAsString.toCharArray())
//                .flatMap(c -> {
//                    switch (c) {
//                        case 'W':
//                            return Stream.of(WALL);
//                        case ' ':
//                            return Stream.of(EMPTY);
//                        case '\n':
//                            return Stream.of(null);
//
//                    }
//                });
//
//            .;
    }
}
