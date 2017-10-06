package com.efimchick.labyrinth.map.position;

/**
 * Created by Evgenii_Efimchik on 04-Oct-17.
 */
public class X extends Coordinate<X> {
    private X(int position) {
        super(position);
    }

    public final static X first = new X(0);

    public static X of(int position) {
        return new X(position);
    }

    public X next(){
        return new X(getPosition() + 1);
    }

    public X prev(){
        return isFirst() ? null : new X(getPosition() - 1);
    }


}
