package org.abrbz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class PersonneGenerateur {



    public Set<String> prenomReader() {
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

    public Set<String> nomReader() {
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

    public String mailGenerator(String nom, String prenom) {
        return prenom + "." + nom + "@mail.com";
    }

    public String telephoneGenerator() {
        return "06"+ String.format("%02d", (int) (Math.random() * 100000000));
    }

    public Set<String> adresseReader() {
        String line;
        String csvSeparator = ";";
        String filename = "adresses-05.csv";

        try (InputStream inputStream = Main.class.getClassLoader().getResourceAsStream(filename);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {

            HashSet<String> adresses = new HashSet<>();
            while ((line = reader.readLine()) != null) {
                String[] values  = line.split(csvSeparator);
                String adresse = values[2] + " " + values[4] + " " + values[5] + " " + values[7];
                adresses.add(adresse);
            }
            return adresses;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
