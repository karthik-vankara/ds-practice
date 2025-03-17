package customs;

import java.util.*;

public class MapUsingHash {
    private Entity[] entities;
    public MapUsingHash() {
        this.entities = new Entity[100];
    }

    private class Entity{
        String key;
        String value;

        public Entity(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
