package com.efimchick.labyrinth.map;

import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;

/**
 * Created by Evgenii_Efimchik on 09-Oct-17.
 */
public class MapCharEncoder {

    private BiMap<Character, CellType> characterCellTypeMap;

    private MapCharEncoder(BiMap<Character, CellType> characterCellTypeMap) {
        this.characterCellTypeMap = ImmutableBiMap.copyOf(characterCellTypeMap);
    }

    public static MapCharEncoder dotOctotorp() {
        return new MapCharEncoder(
                ImmutableBiMap.of(
                        '#', CellType.WALL,
                        '.', CellType.EMPTY
                )
        );
    }

    public static MapCharEncoder startChars() {
        return new MapCharEncoder(
                ImmutableBiMap.of(
                        'W', CellType.WALL,
                        'E', CellType.EMPTY
                )
        );
    }

    public Character forCellType(CellType type) {
        return characterCellTypeMap.inverse().get(type);
    }

    public boolean covers(CellType type){
        return characterCellTypeMap.containsValue(type);
    }

    public CellType cellType(char c) {
        return characterCellTypeMap.get(c);
    }

    public boolean covers(char type){
        return characterCellTypeMap.containsKey(type);
    }

    public Character space(){
        return ' ';
    }
}
