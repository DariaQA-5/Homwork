package Lesson7;

import java.util.Random;

public class Cat extends Animal {
    private boolean isHungry;
    private final int needToBeFull;
    private static int catCount = 0;

    public Cat(String name) {
        super(name);
        catCount++;
        isHungry = true;
        needToBeFull = catNeedsToEat();
    }

    private int catNeedsToEat() {
        Random random = new Random();
        return random.nextInt(25) + 5;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200 && distance > 0) {
            System.out.println("\uD83D\uDC08 " + name + " пробежал " + distance + "м.");
        } else if (distance < 0) {
            System.out.println("Нельзя пробежать отрицательную дистанцию!");
        } else if (distance == 0) {
            System.out.println("\uD83D\uDC08 " + name + " никуда не пошёл, " + name + " лежит.");
        } else {
            System.out.println("\uD83D\uDC08 " + name + " не может пробежать " + distance + " метров!");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("\uD83D\uDC08 Коты не умеют плавать!");
    }

    public void eat(Bowl bowl) {
        if (!isHungry) {
            System.out.println(name + " не голоден.");
            return;
        }
        if (bowl.getFoodAmount() < needToBeFull) {
            System.out.println("В миске недостаточно еды! " + name + " нужно " + needToBeFull + ". " + name
                    + " остался голодным.");
            return;
        }
        isHungry = false;
        bowl.setFoodAmount(bowl.getFoodAmount() - needToBeFull);
        System.out.println(name + " теперь сыт.");
    }

    public static int getCatCount() {
        return catCount;
    }
}