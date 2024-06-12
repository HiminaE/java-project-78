package hexlet.code;

import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

public class MapSchemaTests {
    private MapSchema mapSchema;
    @BeforeEach
    void beforeEach() {
        Validator val = new Validator();
        mapSchema = val.map();
    }
    @Test
    public void testRequired() {
        assertTrue(mapSchema.required().isValid(new HashMap<>()));
        assertFalse(mapSchema.isValid(null));
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(mapSchema.isValid(data));
    }
    @Test
    public void testSizeOf() {
        assertTrue(mapSchema.sizeof(0).isValid(new HashMap<>()));
        HashMap<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        assertTrue(mapSchema.sizeof(1).isValid(data));
        assertFalse(mapSchema.sizeof(3).isValid(data));
    }
    @Test
    public void testShape() {
        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", Validator.string().required());
        schemas.put("lastName", Validator.string().required().minLength(2));
        mapSchema.shape(schemas);
        Map<String, String> human1 = new HashMap<>();
        human1.put("firstName", "John");
        human1.put("lastName", "Smith");
        assertTrue(mapSchema.isValid(human1));

        Map<String, String> human2 = new HashMap<>();
        human2.put("firstName", "John");
        human2.put("lastName", null);
        assertFalse(mapSchema.isValid(human2));

        Map<String, String> human3 = new HashMap<>();
        human3.put("firstName", "Anna");
        human3.put("lastName", "B");
        assertFalse(mapSchema.isValid(human3));
    }
}
