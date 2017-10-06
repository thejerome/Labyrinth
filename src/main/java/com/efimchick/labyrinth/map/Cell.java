package com.efimchick.labyrinth.map;

import com.efimchick.labyrinth.map.position.Position;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
@ToString
@AllArgsConstructor
public class Cell {
    @NonNull
    public final Position position;
    @NonNull
    public final CellType type;
}
