package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        Predicate<Integer> required = Objects::nonNull;
        mapOfPredicates.put("required", required);
        return this;
    }
    public NumberSchema positive() {
        Predicate<Integer> pos = num -> num == null || num > 0;
        mapOfPredicates.put("positive", pos);
        return this;
    }
    public NumberSchema range(int min, int max) {
        Predicate<Integer> range = num -> num != null && num >= min && num <= max;
        mapOfPredicates.put("range", range);
        return this;
    }
}
