package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import model.User;

import java.io.InputStream;
import java.util.List;


public class JsonParseTest {


        @Test
        void parseJsonTest() throws Exception {
            String path = "test_json.json";

            // Map JSON -> POJO
            ObjectMapper mapper = new ObjectMapper();
            List<User> users;

            // Read file
            try (InputStream stream = getClass().getClassLoader().getResourceAsStream(path)) {
                users = mapper.readValue(stream, new TypeReference<>() {
                });
            }

            Assertions.assertNotNull(users);
            Assertions.assertEquals(4, users.size());

                    // Первый пользователь
            var user = users.getFirst();

            Assertions.assertEquals("Jonathan Little", user.name);
            Assertions.assertEquals("+13736195635", user.phoneNumber);
            Assertions.assertEquals("windler.darlene@langosh.com", user.email);
            Assertions.assertEquals("404 Boehm Forge Kubstad, MS 43076", user.address);


            // Домашние животные
            Assertions.assertNotNull(user.pets);
            Assertions.assertEquals(2, user.pets.size());

            var pet1 = user.pets.get(0);
            Assertions.assertAll("pets[0]",
                    () -> Assertions.assertEquals("Rex", pet1.name),
                    () -> Assertions.assertEquals("dog", pet1.species),
                    () -> Assertions.assertEquals("male", pet1.sex),
                    () -> Assertions.assertEquals(4, pet1.age)
            );

            var pet2 = user.pets.get(1);
            Assertions.assertAll("pets[1]",
                    () -> Assertions.assertEquals("Murry", pet2.name),
                    () -> Assertions.assertEquals("cat", pet2.species),
                    () -> Assertions.assertEquals("female", pet2.sex),
                    () -> Assertions.assertEquals(1, pet2.age)
            );

        }
}
