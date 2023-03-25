package com.tk.java_jedis_download;

public class MyMin {
    public static void main(String[] args){
        Thread thread = new Thread(new MyRun("普通用户", 5));
        Thread thread01 = new Thread(new MyRun("vip用户", 10));
        Thread thread02 = new Thread(new MyRun("svip用户", 30));
        thread.start();
        thread01.start();
        thread02.start();
    }
}
