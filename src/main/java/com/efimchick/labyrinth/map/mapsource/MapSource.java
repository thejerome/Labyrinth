package com.efimchick.labyrinth.map.mapsource;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.position.Position;

import java.util.stream.Stream;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
public interface MapSource {
    Stream<Cell> cellsStream();

}
