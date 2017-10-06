package com.efimchick.labyrinth.map.renderer;

import com.efimchick.labyrinth.map.LabyrinthMap;
import com.efimchick.labyrinth.map.LabyrinthMapRenderer;
import com.efimchick.labyrinth.map.position.X;
import com.efimchick.labyrinth.map.position.Y;

/**
 * Created by Evgenii_Efimchik on 05-Oct-17.
 */
public class RectangularStringLabyrinthMapRenderer implements LabyrinthMapRenderer<String> {
    @Override
    public RenderResult<String> render(LabyrinthMap map) {
        StringBuilder sb = new StringBuilder();
        map.iterator().forEachRemaining(
                cell -> {
                    if (!cell.position.x.equals(X.first)
                            && cell.position.y.equals(Y.first))
                        sb.append("\n");
                    sb.append(cell.type.toString().charAt(0));
                }
        );
        return () -> sb.toString();
    }
}
