package Lesson7;

public class Animal {
    public Animal() {
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.run(10);
        animal.swim(20);
    }
}

