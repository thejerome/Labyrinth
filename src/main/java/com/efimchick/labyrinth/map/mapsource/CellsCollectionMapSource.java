package com.efimchick.labyrinth.map.mapsource;

import com.efimchick.labyrinth.map.Cell;

import java.util.Collection;
import java.util.stream.Stream;

/**
 * Created by Evgenii_Efimchik on 09-Oct-17.
 */
public class CellsCollectionMapSource implements MapSource {
    private final Collection<Cell> cells;

    public CellsCollectionMapSource(Collection<Cell> cells) {
        this.cells = cells;
    }

    @Override
    public Stream<Cell> cellsStream() {
        return cells.stream();
    }
}
