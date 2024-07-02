package Lesson6;
public class Employee {
    String FullName;
    String position;
    String email;
    String phone;
    int age;
    int salary;
    public void printInfo() {
    }
    public Employee(String FullName, String position, String email, String phone, int age, int salary) {
        this.FullName = FullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }
    public void info() {
        System.out.println("ФИО" + FullName + ";" + "Должность:" + position + "; Почта:" + email + "; Телефон:" + phone +
                "; Возраст:" + age + "; " + "Зарплата:" + salary);
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println();//Задание 1
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
        for (Employee employee1 : persArray) {
            employee.printInfo();
        }
    }
}

