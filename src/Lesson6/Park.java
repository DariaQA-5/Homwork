package Lesson6;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Park {
    private String name;
    private List<Attraction> attractions;

    public Park(String name) {
        this.name = name;
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        this.attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return this.attractions;
    }

    public static void main(String[] args) {
        Park park = new Park("Затерянный мир");
        park.addAttraction(new Attraction("Американские горки", "10:00-18:00", 500.0));
        park.addAttraction(new Attraction("Колесо обозрения", "11:00-19:00", 600.0));
        park.addAttraction(new Attraction("Лабиринт Потерянного Города", "12:00-20:00", 1000.0));
        System.out.println("Чудо:" + park.name);
        System.out.println("Затерянный мир:");
        Iterator<Attraction> var2 = park.getAttractions().iterator();

        while(var2.hasNext()) {
            Attraction attraction = var2.next();
            System.out.println("Затерянный мир " + attraction.getName() + ", Время работы: " + attraction.getWorkingHours() + ", Cost: " + attraction.getCost());
        }

    }

    public static class Attraction {
        private String name;
        private String workingHours;
        private double cost;

        public Attraction(String name, String workingHours, double cost) {
            this.name = name;
            this.workingHours = workingHours;
            this.cost = cost;
        }

        public String getName() {
            return this.name;
        }

        public String getWorkingHours() {
            return this.workingHours;
        }

        public double getCost() {
            return this.cost;
        }
    }
}
