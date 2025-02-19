package org.abrbz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PersonneGenerateur {

    List<Personne> personnes;
    Set<String> prenoms;
    Set<String> noms;
    Set<String> adresses;

    public PersonneGenerateur() {
        this.personnes = new ArrayList<>();
        this.prenoms = prenomReader();
        this.noms = nomReader();
        this.adresses = adresseReader();
    }

    public Personne generateOne() {

        String nom = this.noms.stream().skip(new Random().nextInt(noms.size())).findFirst().orElse(null);
        String prenom = this.prenoms.stream().skip(new Random().nextInt(prenoms.size())).findFirst().orElse(null);
        String adresse = this.adresses.stream().skip(new Random().nextInt(adresses.size())).findFirst().orElse(null);
        int age = new Random().nextInt(100);
        String email = mailGenerator(nom, prenom);
        String tel = telephoneGenerator();

        return new Personne(nom, prenom, age, email, tel, adresse);
    }

    public List<Personne> generate(int number){
        ArrayList<Personne> personnes = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            personnes.add(generateOne());
        }
        return personnes;
    }

    private Set<String> prenomReader() {
        String line;
        String csvSeparator = ";";
        String filename = "prenoms.csv";

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            HashSet<String> prenoms = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                String[] values  = line.split(csvSeparator);
                prenoms.add(values[1]);
            }
            return prenoms;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Set<String> nomReader() {
        String line;
        String csvSeparator = ",";
        String filename = "patronymes.csv";

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            HashSet<String> noms = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                String[] values  = line.split(csvSeparator);
                noms.add(values[0]);
            }
            return noms;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String mailGenerator(String nom, String prenom) {
        return prenom + "." + nom.replace(" ", "_") + "@mail.com";
    }

    private String telephoneGenerator() {
        return "06"+ String.format("%02d", (int) (Math.random() * 100000000));
    }

    private Set<String> adresseReader() {
        String line;
        String csvSeparator = ";";
        String filename = "adresses-05.csv";

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            HashSet<String> adresses = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                String[] values  = line.split(csvSeparator);

                Map<String, String> decompositionAdresses = new HashMap<>();
                decompositionAdresses.put("$numero", values[2]);
                decompositionAdresses.put("$rue", values[4]);
                decompositionAdresses.put("$codePostal", values[5]);
                decompositionAdresses.put("$ville", values[7]);

                String adresse = """
                                    n°$numero
                                    rue : $rue
                                    cp : $codePostal
                                    ville : $ville""";

                String result = adresse;
                for (Map.Entry<String, String> entry : decompositionAdresses.entrySet()) {
                    result = result.replace(entry.getKey(), entry.getValue());
                }
                adresses.add(result);
            }
            return adresses;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
