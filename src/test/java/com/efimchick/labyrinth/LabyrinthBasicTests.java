package com.efimchick.labyrinth;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.CellType;
import com.efimchick.labyrinth.map.LabyrinthMap;
import com.efimchick.labyrinth.map.position.Direction;
import com.efimchick.labyrinth.map.position.Position;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

import static com.efimchick.labyrinth.map.position.Direction.*;
import static org.junit.Assert.*;

/**
 * Created by Evgenii_Efimchik on 02-Oct-17.
 */
public class LabyrinthBasicTests {

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

    private Actor actor = new Actor();
    private Position initActorPosition1 = Position.of(2, 1);


    @Test
    public void theGameMayBeCreated() {

        Game game = Game.builder()
                .map(map1)
                .actor(actor)
                .actorPosition(initActorPosition1)
                .build();
    }


    @Test(expected = NullPointerException.class)
    public void nullMapIsBlockingGameCreation() {


        Game game = Game.builder()
                .actor(actor)
                .actorPosition(initActorPosition1)
                .build();
    }


    @Test(expected = NullPointerException.class)
    public void nullActorIsBlockingGameCreation() {


        Game game = Game.builder()
                .map(map1)
                .actorPosition(initActorPosition1)
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void nullInitActorPositionDoesBlockGameCreation() {
        Game game = Game.builder()
                .map(map1)
                .actor(actor)
                .build();
    }

    @Test
    public void mapMayBeCreated() {
        LabyrinthMap map = new LabyrinthMap(() -> {
            int x = 0, y = 0;
            return Stream.of(
                    new Cell(Position.of(x++, y), CellType.WALL),
                    new Cell(Position.of(x++, y), CellType.WALL),
                    new Cell(Position.of(x++, y), CellType.WALL),
                    new Cell(Position.of(x++, y), CellType.WALL),

                    new Cell(Position.of(x -= 4, y++), CellType.WALL),
                    new Cell(Position.of(x++, y), CellType.EMPTY),
                    new Cell(Position.of(x++, y), CellType.EMPTY),
                    new Cell(Position.of(x++, y), CellType.EMPTY)
            );
        });
    }

    @Test
    public void mapMayBeCreatedOfNoCells() {
        LabyrinthMap map = new LabyrinthMap(() -> Stream.empty());
    }

    @Test
    public void mapMayBeNonRectangle() {
        LabyrinthMap map = new LabyrinthMap(() -> Stream.of(

                new Cell(Position.of(0, 0), CellType.WALL),
                new Cell(Position.of(0, 1), CellType.WALL),
                new Cell(Position.of(0, 2), CellType.WALL),

                new Cell(Position.of(1, 1), CellType.WALL),
                new Cell(Position.of(1, 3), CellType.WALL),

                new Cell(Position.of(2, 1), CellType.WALL),
                new Cell(Position.of(2, 2), CellType.WALL)
        ));
    }

    @Test
    public void mapOverridesDuplicatedCells() {
        LabyrinthMap map = new LabyrinthMap(() -> Stream.of(

                new Cell(Position.of(0, 0), CellType.WALL),
                new Cell(Position.of(0, 0), CellType.EMPTY)

        ));

        CellType cellType = map.get(Position.of(0, 0));

        assertEquals(CellType.EMPTY, cellType);
    }


    @Test
    public void actorCanGo() {

        Game game = Game.builder()
                .map(map1)
                .actor(new Actor())
                .actorPosition(initActorPosition1)
                .build();

        assertEquals(initActorPosition1.right(), game.go(RIGHT));
        assertEquals(initActorPosition1.right().down(), game.go(DOWN));
        assertEquals(initActorPosition1.down(), game.go(LEFT));
        assertEquals(initActorPosition1, game.go(UP));
    }

    @Test
    public void actorCannotGoThroughWalls() {

        Game game = Game.builder()
                .map(map1)
                .actor(new Actor())
                .actorPosition(initActorPosition1)
                .build();

        assertEquals(initActorPosition1, game.go(UP));
        assertEquals(initActorPosition1.right(), game.go(RIGHT));
        assertEquals(initActorPosition1.right(), game.go(UP));
        assertEquals(initActorPosition1, game.go(LEFT));
    }


    /**
     *
     *  String mapAsString =  "WW        WWWWWWWWWW\n" +
     "WW        WWWWWWWWWW\n" +
     "W                  W\n" +
     "W   W       WWW    W\n" +
     "W   WW      WWWW   W\n" +
     "W    WWW    WWWW   W\n" +
     "W      WWWWWWWWW   W\n" +
     "W    WW        W   W\n" +
     "W              W   W\n" +
     "W              W   W\n" +
     "W    W        WW   W\n" +
     "W   WW       WWW   W\n" +
     "W              W   W\n" +
     "W           W      W\n" +
     "W           W      W\n" +
     "W           WW     W\n" +
     "W           WWW    W\n" +
     "W            WWW   W\n" +
     "W            WWW   W";

     String expectedRenderedString = mapAsString.replaceAll("W", "#");
     */

}
