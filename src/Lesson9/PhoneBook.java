package Lesson9;

import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String surname, String phoneNumber) {
        if (!phoneBook.containsKey(surname)) {
            phoneBook.put(surname, new ArrayList<>());
        }
        phoneBook.get(surname).add(phoneNumber);
    }

    public List<String> get(String surname) {
        return phoneBook.get(surname);
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "678-456-7890");
        phoneBook.add("Иванов", "345-765-4321");
        phoneBook.add("Васильков", "555-123-4567");
        phoneBook.add("Сидоров", "555-888-9999");

        System.out.println("Телефоны Ивановых:");
        List<String> ivanovPhones = phoneBook.get("Иванов");
        for (String phone : ivanovPhones) {
            System.out.println(phone);
        }

        System.out.println("Телефоны Васильковых:");
        List<String> petrovPhones = phoneBook.get("Васильков");
        for (String phone : petrovPhones) {
            System.out.println(phone);
        }

        System.out.println("Телефоны Сидоровых:");
        List<String> sidorovPhones = phoneBook.get("Сидоров");
        for (String phone : sidorovPhones) {
            System.out.println(phone);
        }
    }
}
