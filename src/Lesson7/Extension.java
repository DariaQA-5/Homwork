package Lesson7;

public class Extension {
    public static void main(String[] args) {
        Cat[] cats = new Cat[3];
        for (int i = 0; i < 3; i++) {
            cats[i] = new Cat("Cat " + (i + 1));
        }

        Bowl bowl = new Bowl(20);

        for (Cat cat : cats) {
            if (cat.eat(bowl.getFoodAmount())) {
                System.out.println("Кот наелся.");
            } else {
                System.out.println("Недостаточно еды в миске для кота.");
            }
        }

        for (Cat cat : cats) {
            System.out.println("Сытость кота: " + cat.getFullness());
        }

        bowl.addFood(10);
        System.out.println("В миску добавлена вкусная еда." + bowl.getFoodAmount() + " еды достаточно.");
    }
}
