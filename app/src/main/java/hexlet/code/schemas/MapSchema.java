package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    public MapSchema required() {
        Predicate<Map<String, String>> required = Objects::nonNull;
        mapOfPredicates.put("required", required);
        return this;
    }
    public MapSchema sizeof(int size) {
        Predicate<Map<String, String>> mapSize = map -> map.size() >= size;
        mapOfPredicates.put("sizeof", mapSize);
        return this;
    }
    public MapSchema shape(Map<String, BaseSchema<String>> shemas) {
        mapOfPredicates.put("shape", map -> {
            for (var entry : shemas.entrySet()) {
                String st = map.get(entry.getKey());
                if (!entry.getValue().isValid(st)) {
                    return false;
                }
            }
            return true;
        });
        return this;
    }
}
