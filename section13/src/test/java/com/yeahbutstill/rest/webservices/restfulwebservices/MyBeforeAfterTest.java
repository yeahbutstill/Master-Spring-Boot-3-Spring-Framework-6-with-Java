package com.yeahbutstill.rest.webservices.restfulwebservices;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

class MyBeforeAfterTest {

    private final List<String> todos = Arrays.asList("AWS", "Docker", "Vault");

    @BeforeAll
    static void sampleBeforeAll() {
        System.out.println("Before All");
    }

    @BeforeEach
    void sampleBefore() {
        System.out.println("Before");
    }

    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    void test3() {
        System.out.println("test3");
    }

    @AfterEach
    void sampleAfter() {
        System.out.println("After");
    }

    @AfterAll
    static void sampleAfterAll() {
        System.out.println("Before All");
    }

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
