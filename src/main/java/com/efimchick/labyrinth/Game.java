package com.efimchick.labyrinth;

import com.efimchick.labyrinth.map.CellType;
import com.efimchick.labyrinth.map.LabyrinthMap;
import com.efimchick.labyrinth.map.position.Direction;
import com.efimchick.labyrinth.map.position.Position;
import lombok.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */

@Builder
@AllArgsConstructor
public class Game {

    @NonNull
    private final LabyrinthMap map;
    @NonNull
    private final Actor actor;

    @Getter
    @NonNull
    private Position actorPosition;

    public Position go(Direction direction) {
        Position newPosition = actorPosition.go(direction);
        if (map.get(newPosition) == CellType.EMPTY) {
            actorPosition = newPosition;
        }
        return actorPosition;
    }
}
