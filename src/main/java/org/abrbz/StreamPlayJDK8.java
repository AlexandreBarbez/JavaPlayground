package org.abrbz;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPlayJDK8 {


    public void play() {
        PersonneGenerateur personneGenerateur = new PersonneGenerateur();
        List<Personne> personnes = personneGenerateur.generate(100);

        //toutes les personnes majeures
        ArrayList<Personne> personnesmajeures = personnes
                .stream()
                .filter(personne -> personne.age() >= 18)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Majeurs : " + personnesmajeures);

        //toutes les personnes dont le prénom commence par un A
        ArrayList<Personne> personnesEnA = personnes
                .stream()
                .filter(personne -> personne.prenom().startsWith("A"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("Prenoms en A : " + personnesEnA);

        //toutes les personnes avec un prénom composé
        ArrayList<Personne> personnesPrenomCompose = personnes
                .stream()
                .filter(personne -> personne.prenom().contains("-"))
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("prénoms composés : " + personnesPrenomCompose);

        //la moyenne des ages
        double moyenne = personnes
                .stream()
                .mapToInt(Personne::age)
                .average()
                .orElse(0);
        System.out.println("Moyenne des ages : " + moyenne);

        //la moyenne des ages par prénoms
        Map<String, IntSummaryStatistics> moyenneAgeparPrenom = personnes
                .stream()
                .collect(Collectors.groupingBy(Personne::prenom, Collectors.summarizingInt(Personne::age)));

        moyenneAgeparPrenom.forEach( (key, value) -> System.out.println(key + " : moyenne=" + value.getAverage() + " : total=" + value.getCount() ));
    }
}
