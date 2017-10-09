package com.efimchick.labyrinth.map.renderer;

import com.efimchick.labyrinth.map.LabyrinthMap;

/**
 * Created by Evgenii_Efimchik on 02-Oct-17.
 */
public interface LabyrinthMapRenderer<T> {

    RenderResult<T> render(LabyrinthMap map);

    interface RenderResult<T> {
        T get();
    }


}
