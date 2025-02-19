package org.abrbz.threadplay;

public class ThreadPlayJDK19 {

    public void play(){

        System.out.println("""
                
                ##########
                # THREAD #
                ##########""");
        classicThread();
        virtualThread();

    }

    private void classicThread(){
        for (int i = 0; i < 10_000; i++) {
           new Thread(() -> System.out.println("hello from a classic thread :" +Thread.currentThread().getName())).start();
        }
    }

    private void virtualThread(){
        for (int i = 0; i < 10_000; i++) {
            Thread.startVirtualThread(()->System.out.println("hello from a virtual thread :" +Thread.currentThread()));
        }
    }


}
