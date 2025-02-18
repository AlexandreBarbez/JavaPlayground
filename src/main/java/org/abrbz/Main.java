package org.abrbz;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        PersonneGenerateur personneGenerateur = new PersonneGenerateur();
        List<Personne> personnes = personneGenerateur.generate(10);

    }
}