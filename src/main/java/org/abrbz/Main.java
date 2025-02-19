package org.abrbz;

import org.abrbz.streamPlay.StreamPlayJDK8;
import org.abrbz.switchPlay.SwitchPlayJDK14;

public class Main {
    public static void main(String[] args) {

        StreamPlayJDK8 streamPlay = new StreamPlayJDK8();
        streamPlay.play();

        SwitchPlayJDK14 switchPlay = new SwitchPlayJDK14();
        switchPlay.play();

    }


}