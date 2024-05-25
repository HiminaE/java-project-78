package hexlet.code.schemas;

import java.util.function.Predicate;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        Predicate<String> required =  value -> value != null && !value.isEmpty();
        mapOfPredicates.put("required", required);
        return this;
    }
    public StringSchema minLength(int length) {
        Predicate<String> minLen = str -> str == null || str.length() >= length;
        mapOfPredicates.put("minLength", minLen);
        return this;
    }
    public StringSchema contains(String substring) {
        Predicate<String> containsPredicate = str -> str == null || str.contains(substring);
        mapOfPredicates.put("contains", containsPredicate);
        return this;
    }
}
