
# Валидатор данных
#### Hexlet tests and linter status:
[![Actions Status](https://github.com/HiminaE/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/HiminaE/java-project-78/actions)
[![Actions Status](https://github.com/HiminaE/java-project-78/actions/workflows/gradle.yml/badge.svg)](https://github.com/HiminaE/java-project-78/actions)
[![Maintainability](https://api.codeclimate.com/v1/badges/8220ef67b27b1f9131de/maintainability)](https://codeclimate.com/github/HiminaE/java-project-78/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/8220ef67b27b1f9131de/test_coverage)](https://codeclimate.com/github/HiminaE/java-project-78/test_coverage)

Validator - это библиотека, которая предоставляет возможность проверки данных на основе настраиваемых требований. Она поддерживает проверку строк, чисел и карт, позволяя определять конкретные правила для каждого типа данных.

### Пример использования:

~~~
Validator v = new Validator();

// Create validation rules for a map with data
// Each field is set up with its own rules
Map<String, BaseSchema> validationRules = new HashMap<>();

// Field "name" should be string and cannot be blank
validationRules.put("name", v.string().required());
// Field "age" should be a positive number if used, but can be left blank (null)
validationaRules.put("age", v.number().positive());

// Get object to check map with data using created rules
MapSchema schema = v.map().shape(validationRules);

// Check objects
Map<String, Object> user1 = Map.of(
        "name", "John",
        "age", 25
);
schema.isValid(user1); // -> true

Map<String, Object> user2 = Map.of(
        "name", "Anna",
        "age", null
);
schema.isValid(user2); // -> true, age is not required

Map<String, Object> user2 = Map.of(
        "name", "",
        "age", 18
);
schema.isValid(user3); // -> false, user name cannot be empty
~~~
