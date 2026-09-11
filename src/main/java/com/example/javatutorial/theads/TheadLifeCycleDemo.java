package com.example.javatutorial.theads;

public class TheadLifeCycleDemo {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("====THƯC HIỆN BẮT ĐẦU THREAD====");

        // ==========================================================
        // PHẦN 1: CÁC TRẠNG THÁI CƠ BẢN NEW -> RUNNABLE -> TERMINATED
        // ==========================================================

        Thread t1 = new Thread(() -> {}, "Staff Beginning");

        System.out.println("1. TRẠNG KHỞI TẠO STAFF: " + t1.getState()); // NEW

        t1.start();
        System.out.println("2. TRẠNG THÁI STAFF LÀM VIỆC: " + t1.getState()); // RUNNABLE

        t1.join(); // Kết thúc
        System.out.println("3. TRẠNG THÁI LÀM VIỆC XONG: " + t1.getState()); // TERMINATED

        System.out.println("---------------------------------------------"); //

        // ==========================================================
        // PHẦN 2: WAITING, TIME_WAITING VÀ BLOCKED
        // ==========================================================

        // 3 nhân viên sẽ thực hiện các quy trình khác nhau trong một nhà kho

        Object warehouseKey = new Object();

        // Nhân viên 1: Kiểm tra kho (Sẽ rơi vào Waiting). không thời hạn

        Thread staffCheck = new Thread(() -> {
            synchronized (warehouseKey){
                try {
                    System.out.println("[Staff-check] Vào kho kiểm hàng, hết hàng -> ra ngoài chờ ");
                    warehouseKey.wait(); // Nhả khóa và ra ngoài chờ -> Trạng thái WAITING.
                    System.out.println("[Staff-check] Đã có hàng và kiểm tra xong !");
                }catch (InterruptedException e){
                    e.fillInStackTrace();
                }
            }
        }, "Staff check");

        // Nhân viên 2: Nhập hàng (Gây ra TIME_WAITTING, giữ khóa và làm blocked người khác), có thời hạn
        Thread staffImport = new Thread(() -> {
            synchronized (warehouseKey){
                try {
                    System.out.println("[Staff-import] Đang vào nhập kho và giữ khóa 3s");
                    Thread.sleep(3000); // Ngủ 3s(TIME_WAITING) nhưng mà vẫn giữ khóa. TIME_WAITING sẽ có long

                    System.out.println("[Staff-import] Nhập hàng xong và báo cho Staff check biết");
                    warehouseKey.notify(); // Thông báo cho Staff check, đánh thức ông đang wait (Staff check).
                }catch (InterruptedException e){
                    e.fillInStackTrace();
                }
            }
        }, "Staff import");
        // Nhân viên 3: Cần gấp (Bị blocked)
        Thread staffUrgent = new Thread(() -> {
            System.out.println("[Staff-Urgent] Đang đi đến cửa kho");
            synchronized (warehouseKey){ // Cố gắng lấy khóa
                System.out.println("[Staff-Urgent] Vào được kho");
            }
        }, "Staff Urgent");

        // B1: Staff check vào trước, thấy hết hàng và quay ra đợi
        staffCheck.start();
        Thread.sleep(500); // Đợi cho staffCheck vào wait()
        System.out.println("[Staff-check] Chờ hàng: " + staffCheck.getState()); // WAITING

        // B2: Staff import vào kho
        staffImport.start();
        Thread.sleep(500); // Đợi cho staffImport vào sleep()
        System.out.println("[Staff-import] Đang nhập hàng: " + staffCheck.getState()); // TIME_WAITING


        // B2: Staff Urgent vào kho
        staffUrgent.start();
        Thread.sleep(500); // Đợi cho việc va chạm xảy ra khi cố gắng lấy lại khóa
        System.out.println("[Staff-Urgent] Đứng chờ: " + staffCheck.getState()); // BLOCKED


        staffCheck.join();
        staffUrgent.join();
        staffImport.join();

        System.out.println("Kết thúc DEMO");

    }
}
