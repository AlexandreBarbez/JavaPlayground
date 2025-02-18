package org.abrbz;

public class Main {
    public static void main(String[] args) {

        StreamPlayJDK8 streamPlay = new StreamPlayJDK8();
        streamPlay.play();

        SwitchPlayJDK14 switchPlay = new SwitchPlayJDK14();
        switchPlay.play();

    }


}