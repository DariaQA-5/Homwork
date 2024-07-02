package Lesson7;

public class Dog extends Animal {
    private static int dogCount = 0;

    public Dog() {
        ++dogCount;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может преодолеть такое расстояние.");
        }

    }

    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не умеет плавать на такие дальности.");
        }

    }
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog();
        Dog dog3 = new Dog();

        dog1.run(200);
        dog2.swim(5);
        dog3.run(600);

        System.out.println("Количество собак: " + getDogCount());
    }
}

