package org.abrbz.switchPlay;

import java.util.Arrays;

public class SwitchPlayJDK14 {


    public void play(){

        System.out.println("""
                
                ##########
                # SWITCH #
                ##########
                """);
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

        System.out.println(printRecap(new Honda()));
        System.out.println(printRecap(new Kawasaki()));
        System.out.println(printRecap(new Triumph()));
        System.out.println(printRecap(new Ducati()));


    }

    private String printRecap(MotorcycleBrand motorcycleBrand){
        return switch (motorcycleBrand) {
            case Honda honda -> honda.recap();
            case Kawasaki kawasaki -> kawasaki.recap();
            case Triumph triumph -> triumph.recap();
            case Ducati ducati -> ducati.recap();
        };
    }

    private boolean areWeWorking (Days day){

        return switch (day) {
            case lundi, mardi, mercredi, jeudi, vendredi -> true;
            case samedi, dimanche -> false;
        };
    }
}

