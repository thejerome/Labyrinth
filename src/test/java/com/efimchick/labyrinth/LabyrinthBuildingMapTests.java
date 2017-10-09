package com.efimchick.labyrinth;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.CellType;
import com.efimchick.labyrinth.map.LabyrinthMap;
import com.efimchick.labyrinth.map.renderer.LabyrinthMapRenderer;
import com.efimchick.labyrinth.map.mapsource.CellsCollectionMapSource;
import com.efimchick.labyrinth.map.mapsource.StringMapSource;
import com.efimchick.labyrinth.map.position.Position;
import com.efimchick.labyrinth.map.renderer.RectangularStringLabyrinthMapRenderer;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Evgenii_Efimchik on 02-Oct-17.
 */
public class LabyrinthBuildingMapTests {

    private LabyrinthMap map1 = new LabyrinthMap(() -> {
        int x = 0, y = 0;
        return Stream.of(
                new Cell(Position.of(0, 0), CellType.WALL),
                new Cell(Position.of(1, 0), CellType.WALL),
                new Cell(Position.of(2, 0), CellType.WALL),
                new Cell(Position.of(3, 0), CellType.WALL),

                new Cell(Position.of(0, 1), CellType.WALL),
                new Cell(Position.of(1, 1), CellType.EMPTY),
                new Cell(Position.of(2, 1), CellType.EMPTY),
                new Cell(Position.of(3, 1), CellType.EMPTY),

                new Cell(Position.of(0, 2), CellType.WALL),
                new Cell(Position.of(1, 2), CellType.EMPTY),
                new Cell(Position.of(2, 2), CellType.EMPTY),
                new Cell(Position.of(3, 2), CellType.EMPTY),

                new Cell(Position.of(0, 3), CellType.WALL),
                new Cell(Position.of(1, 3), CellType.EMPTY),
                new Cell(Position.of(2, 3), CellType.EMPTY),
                new Cell(Position.of(3, 3), CellType.EMPTY)

        );
    });

    private LabyrinthMap map2 = new LabyrinthMap(() -> {
        int x = 0, y = 0;
        return Stream.of(
                new Cell(Position.of(x++, y), CellType.WALL),
                new Cell(Position.of(x++, y), CellType.WALL),
                new Cell(Position.of(x++, y), CellType.EMPTY),
                new Cell(Position.of(x++, y), CellType.WALL),

                new Cell(Position.of(x -= 4, y++), CellType.WALL),
                new Cell(Position.of(x++, y), CellType.EMPTY),
                new Cell(Position.of(x++, y), CellType.EMPTY),
                new Cell(Position.of(x++, y), CellType.EMPTY)
        );
    });



    @Test
    public void mayBeCreatedFromCellCollection(){

        Collection<Cell> cells = Arrays.asList(
                new Cell(Position.of(0, 0), CellType.WALL),
                new Cell(Position.of(1, 0), CellType.WALL),
                new Cell(Position.of(2, 0), CellType.WALL),
                new Cell(Position.of(3, 0), CellType.WALL),

                new Cell(Position.of(0, 1), CellType.WALL),
                new Cell(Position.of(1, 1), CellType.EMPTY),
                new Cell(Position.of(2, 1), CellType.EMPTY),
                new Cell(Position.of(3, 1), CellType.EMPTY),

                new Cell(Position.of(0, 2), CellType.WALL),
                new Cell(Position.of(1, 2), CellType.EMPTY),
                new Cell(Position.of(2, 2), CellType.EMPTY),
                new Cell(Position.of(3, 2), CellType.EMPTY),

                new Cell(Position.of(0, 3), CellType.WALL),
                new Cell(Position.of(1, 3), CellType.EMPTY),
                new Cell(Position.of(2, 3), CellType.EMPTY),
                new Cell(Position.of(3, 3), CellType.EMPTY)
        );

        LabyrinthMap map = new LabyrinthMap(new CellsCollectionMapSource(cells));

    }


    @Test
    public void mayBeCreatedFromString(){

        String mapAsString = "#####\n" +
                        "#...#\n" +
                        "#...#\n" +
                        "#...#";

        LabyrinthMap map = new LabyrinthMap(new StringMapSource(mapAsString));

    }

    @Test
    public void mayBeCorrectlyCreatedFromString(){

        String mapAsString = "#####\n" +
                "#...#\n" +
                "#...#\n" +
                "#...#";

        LabyrinthMap map = new LabyrinthMap(new StringMapSource(mapAsString));

        LabyrinthMapRenderer<String> mapRenderer = new RectangularStringLabyrinthMapRenderer();

        assertTrue(map.iterator().hasNext());

        for (Cell cell : map) {
            System.out.println(cell);
        }

        assertEquals("WWWWW\n" +
                        "WEEEW\n" +
                        "WEEEW\n" +
                        "WEEEW\n",
                mapRenderer.render(map).get());


    }


}
