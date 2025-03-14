package com.ooz.Our.Own.Zeta.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Civilization {

    private int age;
    private Map<String, Integer> resources = new HashMap<>(); // <Resources Name, Level>
    private Map<String, Integer> discoveries = new HashMap<>(); // <Discoveries Name, Level>
    private int population;
    private Map<Person, String> importantIndividuals = new HashMap<>(); //<Person object, Name of the person>
    private List<String> eventsLog = new ArrayList<>();
    private Map<String, Double> languagePatterns = new HashMap<>();

    public Map<String, Double> getLanguagePatterns() {
        return languagePatterns;
    }

    public void setLanguagePatterns(Map<String, Double> languagePatterns) {
        this.languagePatterns = languagePatterns;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Map<String, Integer> getResources() {
        return resources;
    }

    public void setResources(Map<String, Integer> resources) {
        this.resources = resources;
    }

    public Map<String, Integer> getDiscoveries() {
        return discoveries;
    }

    public void setDiscoveries(Map<String, Integer> discoveries) {
        this.discoveries = discoveries;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Map<Person, String> getImportantIndividuals() {
        return importantIndividuals;
    }

    public void setImportantIndividuals(Map<Person, String> importantIndividuals) {
        this.importantIndividuals = importantIndividuals;
    }

    public List<String> getEventsLog() {
        return eventsLog;
    }

    public void setEventsLog(List<String> eventsLog) {
        this.eventsLog = eventsLog;
    }

    public Civilization() {
        this.age = 0;
        this.discoveries = new HashMap<>();
        this.eventsLog = new ArrayList<>();
        this.resources = new HashMap<>();
        this.population = 0;
        this.importantIndividuals = new HashMap<>();
        this.languagePatterns = new HashMap<>();
        languagePatterns.put("VowelsPerWord", 0.0);
        languagePatterns.put("ConsonantsPerWord", 0.0);
        languagePatterns.put("VowelClusterRate", 0.0);
        languagePatterns.put("XYZRate", 0.0);
        languagePatterns.put("HRate", 0.0);

    }

    public void passTime(int years) {
        age += years;
    }

    public Person createImportantPerson(int age, String name, String field, Map<String, Integer> discoveries, boolean alive, int knowledge) {
        Person person = null;
        switch (field) {
            case "Scientist":
                person = new Scientist(age, name, field, discoveries, alive, knowledge);
                break;
            case "Artist":
                person = new Artist(age, name, field, discoveries, alive, knowledge);
                break;
            case "Athlete":
                person = new Athlete(age, name, field, discoveries, alive, knowledge);
                break;
            case "Doctor":
                person = new Doctor(age, name, field, discoveries, alive, knowledge);
                break;
        }
        return person;
    }

    public Double calculateVowelsAvgInWords(String word, String... others) {
        char[] wordInChar = word.toLowerCase().toCharArray();
        double amountOfVowels = 0;
        int totalWords = 1 + others.length;

        amountOfVowels += countVowels(word);

        for (String other : others) {
            amountOfVowels += countVowels(other);
        }

        return amountOfVowels / totalWords;
    }

    private int countVowels(String word) {
        int count = 0;
        for (char character : word.toLowerCase().toCharArray()) {
            if (character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u') {
                count++;
            }
        }
        return count;
    }

    public Double calculateConsonantsAvgInWords(String word, String... others) {
        char[] wordInChar = word.toLowerCase().toCharArray();
        double amountOfConsonants = 0;
        int totalWords = 1 + others.length;

        amountOfConsonants += countConsonants(word);

        for (String other : others) {
            amountOfConsonants += countConsonants(other);
        }

        return amountOfConsonants / totalWords;
    }

    private int countConsonants(String word) {
        int count = 0;
        for (char character : word.toLowerCase().toCharArray()) {
            if (character != 'a' && character != 'e' && character != 'i' && character != 'o' && character != 'u') {
                count++;
            }
        }
        return count;
    }

    public boolean checkIfWordContainsVowelCluster(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (i < (word.length() - 1)) {
                if ((word.toLowerCase().toCharArray()[i] == 'a' || word.toLowerCase().toCharArray()[i] == 'e' || word.toLowerCase().toCharArray()[i] == 'i' || word.toLowerCase().toCharArray()[i] == 'o' || word.toLowerCase().toCharArray()[i] == 'u') && (word.toLowerCase().toCharArray()[i + 1] == 'a' || word.toLowerCase().toCharArray()[i + 1] == 'e' || word.toLowerCase().toCharArray()[i + 1] == 'i' || word.toLowerCase().toCharArray()[i + 1] == 'o' || word.toLowerCase().toCharArray()[i + 1] == 'u')) {
                    return true;
                }
            }
        }
        return false;
    }

    public Double calculateVowelClusterRateInWords(String word, String... others) {
        int words = 1 + others.length;
        int wordsWCluster = 0;
        Double wordsWithVowelClusterRate = 0.0;
        if (checkIfWordContainsVowelCluster(word)) {
            wordsWCluster++;
        }

        for (int i = 0; i < others.length; i++) {
            if (checkIfWordContainsVowelCluster(others[i])) {
                wordsWCluster++;
            }
        }

        wordsWithVowelClusterRate = (wordsWCluster * 100.0 / words);

        return wordsWithVowelClusterRate;

    }

    public boolean checkIfWordContainsXYZ(String word) {
        char[] wordToChar = word.toLowerCase().toCharArray();

        for (char character : wordToChar) {
            if (character == 'x' || character == 'y' || character == 'z') {
                return true;
            }
        }
        return false;
    }

    public Double calculateXYZRateInWords(String word, String... others) {
        int amountOfWords = 1 + others.length;
        int amountOfXYZWords = 0;
        if (checkIfWordContainsXYZ(word)) {
            amountOfXYZWords++;
        }

        for (String wordOther : others) {
            if (checkIfWordContainsXYZ(wordOther)) {
                amountOfXYZWords++;
            }
        }

        return amountOfXYZWords * 100.0 / amountOfWords;
    }

    public boolean checkIfWordContainsH(String word) {
        char[] wordChar = word.toLowerCase().toCharArray();
        for (char character : wordChar) {
            if (character == 'h') {
                return true;
            }
        }
        return false;

    }

    public Double calculateHRateInWords(String word, String... others) {
        int amountOfWords = 1 + others.length;
        int wordsWithH = 0;

        if (checkIfWordContainsH(word)) {
            wordsWithH++;
        }

        for (String wordToCheck : others) {
            if (checkIfWordContainsH(wordToCheck)) {
                wordsWithH++;
            }
        }

        return wordsWithH * 100.0 / amountOfWords;

    }

}
