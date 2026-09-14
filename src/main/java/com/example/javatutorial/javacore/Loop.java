package com.example.javatutorial.javacore;

public class Loop {
    public static void main(String[] args){
        /*
         * For Each Biến lặp x trong vòng lặp for-each chỉ lưu trữ bản sao giá trị của từng phần tử trong mảng ở mỗi bước lặp
         * Không làm thay đổi giá trị trong mảng.
         */
        int[] numbers = { 1, 2, 3, 4, 5 };
        for (int x : numbers) { // giá trị truyền vào lại bản sao.
            x = x * 2;
        }

        for (int x : numbers) {
            System.out.println(x);
        }
    }
}
