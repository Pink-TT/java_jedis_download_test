package com.tk.java_jedis_download;

public class MyRun implements Runnable {
    private Server sc;

    public MyRun(String id, int num) {
        this.sc = new Server(id, num);
    }

    @Override
    public void run() {
        while (true){
            sc.server();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
