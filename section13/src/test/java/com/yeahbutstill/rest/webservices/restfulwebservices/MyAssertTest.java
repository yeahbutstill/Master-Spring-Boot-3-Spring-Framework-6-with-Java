package com.yeahbutstill.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class MyAssertTest {

    private final List<String> todos = Arrays.asList("AWS", "Docker", "Vault");

    @Test
    void testCheckListTodos() {

        boolean checkListTodos = todos.contains("AWS"); // Result
        boolean checkNoOnListTodos = todos.contains("OCP");

        Assertions.assertEquals(3, todos.size());
        // This work to boolean value
        Assertions.assertTrue(checkListTodos);
        Assertions.assertFalse(checkNoOnListTodos);
        Assertions.assertArrayEquals(todos.toArray(), todos.toArray());

    }

}
