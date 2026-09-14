package com.example.javatutorial.javacore;

import java.math.BigInteger;

public class StringDemo {
    public static void main(String[] args){
        /**
         * Vì String trong Java là đối tượng bất biến (immutable)
         * mỗi lần dùng toán tử + để nối chuỗi sẽ tạo ra một đối tượng String mới hoàn toàn, gây lãng phí bộ nhớ và giảm hiệu năng
         **/
        StringBuilder str = new StringBuilder("Hi");
        str.append("Hello");
        str.append(" ");
        str.append("Everyone");

        System.out.println(str);
    }
}
