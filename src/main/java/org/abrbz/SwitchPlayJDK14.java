package org.abrbz;

import java.util.Arrays;

public class SwitchPlayJDK14 {


    public void play(){

        //jour ou on travaille
        System.out.println("on travaille : ");
        Arrays.stream(Days.values())
                .filter(days -> areWeWorking(days))
                .forEach(day -> System.out.println(day));

        //jours oun on travaille pas
        System.out.println("on travaille pas : ");
        Arrays.stream(Days.values())
                .filter(days -> !areWeWorking(days))
                .forEach(day -> System.out.println(day));

    }

    private boolean areWeWorking (Days day){

        return switch (day) {
            case lundi, mardi, mercredi, jeudi, vendredi -> true;
            case samedi, dimanche -> false;
        };
    }
}

enum Days {
    lundi, mardi, mercredi, jeudi, vendredi, samedi, dimanche;
}