import Lesson7.Animal;
import Lesson7.Bowl;
import Lesson7.Cat;
import Lesson7.Dog;
import Lesson7.Circle;
import Lesson7.Color;
import Lesson7.Rectangle;
import Lesson7.Triangle;

public class Main {
    public static void main(String[] args) {
        //Задание животные
        Cat fuksik = new Cat("Фуксик");
        Cat kisa = new Cat("Киса");
        Cat persik = new Cat(  "Персик");
        Dog dollar = new Dog("Доллар");
        Dog prizrak = new Dog("Призрак");
        Dog kefir = new Dog("Кефир");
        Dog zevs = new Dog("Зевс");

        fuksik.run(150);
        kisa.run(350);
        persik.swim(0);
        dollar.run(20);
        prizrak.run(400);
        kefir.swim(0);
        zevs.swim(30);
        System.out.println();

        //задание миска
        Bowl bowl = new Bowl();
        Cat[] kittens = new Cat[5];
        kittens[0] = new Cat("Бася");
        kittens[1] = new Cat("Дуся");
        kittens[2] = new Cat("Фунт");
        kittens[3] = new Cat("Хэппи");
        kittens[4] = new Cat("Мята");
        for (Cat kitten : kittens) {
            bowl.food();
            kitten.eat(bowl);
            bowl.putFood();
        }

        System.out.println("\nКотиков всего: " + Cat.getCatCount() + "\n" +
                "Собачек всего: " + Dog.getDogCount() + "\n" +
                "Животных всего: " + Animal.getAnimalCount() + "\n");

        //Задание фигуры
        Circle circle = new Circle(3, Color.GREEN, Color.ORANGE);
        circle.showInfo();

        Triangle triangle = new Triangle(6, 6, 4, Color.RED, Color.BLUE);
        triangle.showInfo();

        Rectangle rectangle = new Rectangle(6, 3, Color.BLACK, Color.WHITE);
        rectangle.showInfo();
    }
}