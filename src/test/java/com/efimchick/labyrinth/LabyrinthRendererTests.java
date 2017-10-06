package com.efimchick.labyrinth;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.CellType;
import com.efimchick.labyrinth.map.LabyrinthMap;
import com.efimchick.labyrinth.map.LabyrinthMapRenderer;
import com.efimchick.labyrinth.map.position.Position;
import com.efimchick.labyrinth.map.renderer.RectangularStringLabyrinthMapRenderer;
import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * Created by Evgenii_Efimchik on 05-Oct-17.
 */
public class LabyrinthRendererTests {

    private LabyrinthMap smallQuadMap = new LabyrinthMap(() -> {
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

private LabyrinthMap smallRectMap = new LabyrinthMap(() -> {
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
                new Cell(Position.of(3, 3), CellType.EMPTY),

                new Cell(Position.of(0, 4), CellType.WALL),
                new Cell(Position.of(1, 4), CellType.WALL),
                new Cell(Position.of(2, 4), CellType.WALL),
                new Cell(Position.of(3, 4), CellType.WALL)

        );
    });


    @Test
    public void quadMapMayBeRenderedToString() {

        LabyrinthMapRenderer<String> mapRenderer = new RectangularStringLabyrinthMapRenderer();

        assertEquals("WWWW\n" +
                        "WEEE\n" +
                        "WEEE\n" +
                        "WEEE",
                mapRenderer.render(smallQuadMap).get());
    }


    @Test
    public void rectMapMayBeRenderedToString() {

        LabyrinthMapRenderer<String> mapRenderer = new RectangularStringLabyrinthMapRenderer();

        assertEquals("WWWWW\n" +
                        "WEEEW\n" +
                        "WEEEW\n" +
                        "WEEEW",
                mapRenderer.render(smallRectMap).get());
    }

}
