package Lesson6;
public class Employee {
    private String FullName;
    private String position;
    private String email;
    private String phone;
    private int age;
    private int salary;


    public Employee(String FullName, String position, String email, String phone, int age, int salary) {
        this.FullName = FullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
    }

public void printInfo() {
    System.out.println("Имя: " + FullName);
    System.out.println("Должность: " + position);
    System.out.println("Email: " + email);
    System.out.println("Телефон: " + phone);
    System.out.println("Возраст: " + age);
    System.out.println("Зарплата: " + salary);
    System.out.println();
}
}
