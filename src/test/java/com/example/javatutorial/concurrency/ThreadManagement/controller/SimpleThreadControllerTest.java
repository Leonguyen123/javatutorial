package com.example.javatutorial.concurrency.ThreadManagement.controller;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SimpleThreadControllerTest {

    private final SimpleThreadController controller = new SimpleThreadController();

    @Test
    void testRunnableEndpoint() {
        Map<String, Object> response = controller.testRunnable();
        assertNotNull(response);
        assertEquals("Thread-Runnable-Worker", response.get("newThreadName"));
        assertTrue(response.containsKey("callerThread"));
        assertTrue(response.containsKey("newThreadState"));
    }

    @Test
    void testSubclassThreadEndpoint() {
        Map<String, Object> response = controller.testSubclassThread();
        assertNotNull(response);
        assertEquals("Thread-Subclass-Worker", response.get("newThreadName"));
        assertTrue(response.containsKey("callerThread"));
        assertTrue(response.containsKey("newThreadState"));
    }
}
