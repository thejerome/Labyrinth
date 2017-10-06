package com.efimchick.labyrinth.map;

import com.efimchick.labyrinth.map.mapsource.MapSource;
import com.efimchick.labyrinth.map.position.Position;
import com.efimchick.labyrinth.map.position.X;
import com.efimchick.labyrinth.map.position.Y;
import com.google.common.collect.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
@ToString
public class LabyrinthMap implements Iterable<Cell> {

    @Getter(AccessLevel.NONE)
    private final Table<X, Y, CellType> map;


    public LabyrinthMap(MapSource mapSource) {
        Table<X, Y, CellType> tempMap = HashBasedTable.create();
        mapSource.cellsStream()
                .forEach(cell -> tempMap.put(
                        cell.position.x,
                        cell.position.y,
                        cell.type
                ));
        map = ImmutableTable.copyOf(tempMap);
    }

    public CellType get(Position position) {
        return map.get(position.x, position.y);
    }


    @Override
    public Iterator<Cell> iterator() {
        return map.cellSet().stream()
                .map(c -> new Cell(Position.of(c.getRowKey(), c.getColumnKey()), c.getValue()))
                .iterator();
    }
}
