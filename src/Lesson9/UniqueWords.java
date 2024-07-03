package Lesson9;

import java.util.*;

public class UniqueWords {
    public static void main(String[] args) {
        // Create an array of words
        String[] words = {
                "клубника", "яхонтовый", "прелест", "счастье", "забота", "любовь",
                "пираты карибского моря", "гарри поттер", "фифа", "машина", "море",
                "солнце", "работа", "лето", "осень", "зима", "весна", "новый год",
                "рождество", "клубника", "любовь", "машина", "лето"
        };

        // Create a HashSet to store unique words
        Set<String> uniqueWords = new HashSet<>();

        // Create a HashMap to store word frequencies
        Map<String, Integer> wordFrequencies = new HashMap<>();

        // Iterate through the array of words
        for (String word : words) {
            // Add the word to the set of unique words
            uniqueWords.add(word);

            // Increment the frequency of the word in the map
            wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
        }

        // Print the list of unique words
        System.out.println("Unique words:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        // Print the frequency of each word
        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
