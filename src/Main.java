import Lesson6.Employee;
import Lesson6.Park;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        //Задание 1
        Employee employee = new Employee("Петр Иванов", "Строитель", "01@mail.ru",
                "89152345678", 35, 50000);
        employee.printInfo();

        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Иван Иванов", "Менеджер", "ivan@mail.ru", "89162345678",
                30, 35000);
        persArray[1] = new Employee("Сергей Петров", "Инженер", "ppp@mail.ru", "89154567891",
                35, 42000);
        persArray[2] = new Employee("Карл Белов", "CEO", "belov@gmail.com", "89856784321",
                45, 100000);
        persArray[3] = new Employee("Анна Светлова", "HR", "an@yandex.ru", "89169876549",
                36, 42000);
        persArray[4] = new Employee("Ирина Антонова", "Менеджер", "irina777@mail.ru",
                "89056789122", 32, 33000);
        for (Employee emp : persArray) {
            emp.printInfo();
        }
        //Задание 1
        Park park = new Park("Затерянный мир");
        park.addAttraction("Американские горки", "09:00 - 20:00", 500);
        park.addAttraction("Коллесо обозрения", "08:00 - 23:00", 600);
        park.addAttraction("Лабиринт потерянного города", "10:00 - 21:00", 1000);
        park.addAttraction("Комната страха", "09:00 - 20:00", 500);
        park.showInfo();
    }
}
