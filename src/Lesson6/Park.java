package Lesson6;

import java.util.ArrayList;
import java.util.List;

public class Park {
    private String name;
    private List<Attraction> attractions = new ArrayList<>();

    public Park(String name) {
        this.name = name;
    }

    public void addAttraction(String name, String schedule, int price) {
        attractions.add(new Attraction(name, schedule, price));
    }

    public void showInfo() {
        System.out.println("Парк: " + name);
        for (Attraction attraction : attractions) {
            System.out.println("Аттракцион: " + attraction.getName());
            System.out.println("Расписание: " + attraction.getSchedule());
            System.out.println("Цена: " + attraction.getPrice());
            System.out.println();
        }
    }
}

class Attraction {
    private String name;
    private String schedule;
    private int price;

    public Attraction(String name, String schedule, int price) {
        this.name = name;
        this.schedule = schedule;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getPrice() {
        return price;
    }
}
