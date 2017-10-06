package com.efimchick.labyrinth.map.position;

import lombok.AllArgsConstructor;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
@AllArgsConstructor
public class Neighbors {
    public final Position top;
    public final Position left;
    public final Position down;
    public final Position right;
}
