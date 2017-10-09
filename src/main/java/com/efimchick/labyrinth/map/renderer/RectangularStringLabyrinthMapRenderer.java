package com.efimchick.labyrinth.map.renderer;

import com.efimchick.labyrinth.map.Cell;
import com.efimchick.labyrinth.map.LabyrinthMap;
import com.efimchick.labyrinth.map.MapCharEncoder;
import com.efimchick.labyrinth.map.position.X;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Integer.max;

/**
 * Created by Evgenii_Efimchik on 05-Oct-17.
 */
public class RectangularStringLabyrinthMapRenderer implements LabyrinthMapRenderer<String> {

    private MapCharEncoder encoder = MapCharEncoder.startChars();

    @Override
    public RenderResult<String> render(LabyrinthMap map) {
        StringBuilder sb = new StringBuilder();

        Table<Integer, Integer, Character> preRenderTable = HashBasedTable.create();
        int xBound = 0;
        int yBound = 0;

        for (Cell cell : map) {
            int x = cell.position.x.getPosition();
            int y = cell.position.y.getPosition();

            xBound = max(xBound, x);
            yBound = max(yBound, y);

            preRenderTable.put(x, y, encoder.forCellType(cell.type));
        }

        for (int i = 0; i <= xBound; i++) {
            for (int j = 0; j <= yBound; j++) {
                sb.append(preRenderTable.contains(i, j) ?
                        preRenderTable.get(i, j)
                        : encoder.space()

                );
            }
            sb.append("\n");
        }

        return () -> sb.toString();
    }

    private boolean nextRowStarted(AtomicReference<X> prevX, Cell cell) {
        System.out.println(cell);
        return prevX.get() != null && !cell.position.equals(prevX);
    }
}
