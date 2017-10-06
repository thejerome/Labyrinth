package com.efimchick.labyrinth.map.position;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * Created by Evgenii_Efimchik on 02-Oct-17.
 */

@EqualsAndHashCode
public abstract class Coordinate<C extends Coordinate> implements Comparable<C> {

    @Getter
    private int position;

    Coordinate(int position) {
        checkArgument(position >= 0, "Negative position (%d) is not allowed");
        this.position = position;
    }

    public abstract C next();

    public abstract C prev();

    public boolean isFirst() {
        return position == 0;
    }

    @Override
    public int compareTo(C o) {
        return Integer.compare(this.position, o.getPosition());
    }

    @Override
    public String toString() {
        return Integer.toString(position);
    }
}
