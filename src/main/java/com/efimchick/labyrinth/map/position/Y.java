package com.efimchick.labyrinth.map.position;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
public class Y extends Coordinate<Y> {
    private Y(int position) {
        super(position);
    }

    public final static Y first = new Y(0);

    public static Y of(int position) {
        return new Y(position);
    }

    public Y next() {
        return new Y(getPosition() + 1);
    }

    public Y prev() {
        return isFirst() ? null : new Y(getPosition() - 1);
    }

}
