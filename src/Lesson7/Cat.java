package Lesson7;

public class Cat extends Animal {
    private static int catCount = 0;
    private final String name;
    private int fullness;

    public Cat(String name) {
        this.name = name;
        catCount++;
        this.fullness = 0;
    }

    public static int getCatCount() {
        return catCount;
    }

    public boolean eat(int foodAmount) {
        if (foodAmount > 0) {
            fullness += foodAmount;
            if (fullness > 100) {
                fullness = 100;
            }
            return true;
        } else {
            return false;
        }
    }

    public int getFullness() {
        return fullness;
    }
}