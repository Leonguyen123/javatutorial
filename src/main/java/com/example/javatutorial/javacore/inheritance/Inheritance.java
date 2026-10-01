package com.example.javatutorial.javacore.inheritance;
/*

* BÀI TẬP 1: HỆ THỐNG THANH TOÁN
*
* 1. Payment → Abstract class
* * Các phương thức thanh toán có chung state: paymentId,
* ```
   amount, createdAt, status.
  ```
* * Có logic chung và mỗi loại có cách xử lý thanh toán riêng.
* * Vì có dữ liệu và hành vi chung thực sự nên chọn abstract class,
* ```
   không chỉ là một contract.
  ```
*
* 2. Refundable → Interface
* * Đại diện cho khả năng hoàn tiền (can-do).
* * Chỉ những phương thức hỗ trợ refund mới implement interface này.
*
* 3. CardPayment → extends Payment, implements Refundable
* * Kế thừa dữ liệu và hành vi chung từ Payment.
* * Triển khai xử lý thanh toán qua payment gateway và refund.
*
* 4. BankTransferPayment → extends Payment
* * Kiểm tra giao dịch ngân hàng.
* * Không implement Refundable nếu nghiệp vụ không hỗ trợ hoàn tiền.
*
* 5. EWalletPayment → extends Payment
* * Gọi API ví điện tử để xử lý thanh toán.
*
* KẾT LUẬN:
* * Abstract class: dùng khi có state và logic chung giữa các lớp.
* * Interface: dùng để định nghĩa contract hoặc khả năng tùy chọn.
* * Việc có hỗ trợ refund hay không phụ thuộc vào yêu cầu nghiệp vụ,
* không phụ thuộc đơn thuần vào loại phương thức thanh toán.
  */


public class Inheritance {
    public static void main(String[] args){
        System.out.println("test Inheritance");

        // Thay chỗ, Dog có thể đại diện cho Animal
        // Animal animal1 = new Animal();
        // animal1 = new Dog();

        // Dymanic Binding.
        Animal animal = new Dog();

        // Polymorphism - tính đa hình
        animal.sound();

        /*
         * Compile-time:
         * Biến staff được khai báo kiểu Employee nên compiler chỉ cho phép
         * gọi các phương thức được khai báo trong Employee hoặc kế thừa từ lớp cha.
         *
         * Mặc dù object thực tế được khởi tạo là Manager và có phương thức manage(),
         * nhưng Employee không khai báo phương thức này nên staff.manage() gây lỗi compile.
         *
         * Muốn gọi manage(), cần ép kiểu staff sang Manager vì object thực tế là Manager.
         */

        Employee staff = new Manager();
        staff.work();
        // staff.manage(); // lỗi

        Manager manager = (Manager) staff;
    }
}
