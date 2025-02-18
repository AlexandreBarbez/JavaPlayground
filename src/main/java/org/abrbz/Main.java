package org.abrbz;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PersonneGenerateur personneGenerateur = new PersonneGenerateur();

        Set<String> prenoms = personneGenerateur.prenomReader();
        Set<String> noms = personneGenerateur.nomReader();

        //prenoms.forEach(System.out::println);
        //noms.forEach(System.out::println);

        System.out.println(personneGenerateur.telephoneGenerator());
        System.out.println(personneGenerateur.adresseReader());

    }
}