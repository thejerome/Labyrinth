package com.efimchick.labyrinth.map.position;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
@AllArgsConstructor
@EqualsAndHashCode
public class Position {
    @NonNull
    public final X x;
    @NonNull
    public final Y y;

    public Position go(Direction direction){
        switch (direction){
            case UP: return up();
            case RIGHT: return right();
            case DOWN: return down();
            case LEFT: return left();
            default: throw new IllegalArgumentException();
        }
    }

    public Position up() {
        return of(x, y.prev());
    }

    public Position left() {
        return of(x.prev(), y);
    }

    public Position down() {
        return of(x, y.next());
    }

    public Position right() {
        return of(x.next(), y);
    }

    public static Position of(int xPosition, int yPosition) {
        return of(X.of(xPosition), Y.of(yPosition));
    }

    public static Position of(X x, Y y) {
        return x == null || y == null
                ? null
                : new Position(x, y);
    }

    @Override
    public String toString() {
        return "{" + x + ", " + y + '}';
    }
}
