package com.example.javatutorial.concurrency.ThreadManagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Minh họa 2 cách định nghĩa và khởi chạy Thread cơ bản nhất trong tài liệu Oracle:
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html
 * 
 * Cách 1: Implement interface Runnable
 * Cách 2: Subclass (kế thừa) class Thread
 */
@RestController
@RequestMapping("/api/threads")
public class SimpleThreadController {

    // =========================================================================
    // CÁCH 1: Cung cấp một đối tượng Runnable (Providing a Runnable object)
    // =========================================================================
    public static class HelloRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(">> [HelloRunnable] Xin chào từ một thread triển khai Runnable! Thread: " 
                    + Thread.currentThread().getName());
        }
    }

    /**
     * API Cách 1: new Thread(new HelloRunnable()).start()
     */
    @GetMapping("/runnable")
    public Map<String, Object> testRunnable() {
        String callerThread = Thread.currentThread().getName();

        // 1. Tạo instance của Runnable
        HelloRunnable task = new HelloRunnable();

        // 2. Truyền Runnable vào constructor của Thread
        Thread thread = new Thread(task, "Thread-Runnable-Worker");

        // 3. Khởi chạy luồng
        thread.start();

        return Map.of(
                "method", "1. Implement interface Runnable",
                "callerThread", callerThread,
                "newThreadName", thread.getName(),
                "newThreadState", thread.getState().name(),
                "oracleReference", "new Thread(new HelloRunnable()).start()",
                "advantage", "Linh hoạt hơn vì class vẫn có thể kế thừa (extends) class khác."
        );
    }

    // =========================================================================
    // CÁCH 2: Kế thừa trực tiếp lớp Thread (Subclassing Thread)
    // =========================================================================
    public static class HelloThread extends Thread {
        public HelloThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(">> [HelloThread] Xin chào từ một thread kế thừa class Thread! Thread: " 
                    + Thread.currentThread().getName());
        }
    }

    /**
     * API Cách 2: (new HelloThread()).start()
     */
    @GetMapping("/subclass")
    public Map<String, Object> testSubclassThread() {
        String callerThread = Thread.currentThread().getName();

        // 1. Khởi tạo đối tượng từ class kế thừa Thread
        HelloThread thread = new HelloThread("Thread-Subclass-Worker");

        // 2. Khởi chạy luồng trực tiếp
        thread.start();

        return Map.of(
                "method", "2. Subclassing class Thread",
                "callerThread", callerThread,
                "newThreadName", thread.getName(),
                "newThreadState", thread.getState().name(),
                "oracleReference", "(new HelloThread()).start()",
                "disadvantage", "Kém linh hoạt hơn vì Java là đơn kế thừa (không thể extends class nào khác nữa)."
        );
    }
}
