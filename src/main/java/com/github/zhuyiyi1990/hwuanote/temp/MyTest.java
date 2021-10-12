package com.github.zhuyiyi1990.hwuanote.temp;

public class MyTest {

    public static void main(String[] args) {
        String str = "abcd一二三四efd";
        System.out.println(str.length());
        System.out.println(str.codePointCount(0, str.length()));
        str.codePoints().forEach(System.out::println);
    }

}
