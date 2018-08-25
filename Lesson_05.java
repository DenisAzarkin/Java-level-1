/*
 * lesson_05.java
 * Java. Level 1. Lesson 5. Homework
 * 
 * 1. Создать класс "Сотрудник" с полями: ФИО, должность, email,
 *   телефон, зарплата, возраст.
 * 2. Конструктор класса должен заполнять эти поля при создании объекта.
 * 3. Внутри класса "Сотрудник" написать метод, который выводит
 *   информацию об объекте в консоль.
 * 4. Создать массив из 5 сотрудников
 * 
 * * Вывести информацию объ объекте с помощью toString.
 * 
 * @author Denis Azarkin
 * @version Aug 25, 2018
 */
 
public class Lesson_05 {
    
    public static void main (String[] args) {
        Person[] persArray = new Person[5];
        persArray[0] = new Person
        ("Alex", "Coder", "alex@hooli.com", 43210, 7500, 19);
        persArray[1] = new Person
        ("Jon", "Manager", "jon@hooli.com", 43212, 20000, 25);
        persArray[2] = new Person
        ("Max", "Boss", "max@hooli.com", 43217, 150000, 47);
        persArray[3] = new Person
        ("Katrin", "Manager", "katrin@hooli.com", 43214, 14000, 32);
        persArray[4] = new Person
        ("Vladimir", "Driver", "vladimir@hooli.com", 43215, 80000, 41);
        
        // Show all persons
        for (int i = 0; i < persArray.length; i++) {
            System.out.println(persArray[i].showPerson());
        }
        
        System.out.println();
        
        // Show persons over 40 years old
        System.out.println("Persons over 40 years old:");
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() >= 40) {
                System.out.println(persArray[i].showPerson());
            }
        }
        
        System.out.println();
        
        System.out.println("Show all persons with toString:");
        
        // Show all persons with toString
        for (int i = 0; i < persArray.length; i++) {
            System.out.println(i+1 + ". " + persArray[i]);
        }
    }
}

// Class Person
class Person {

    private String name;
    private String job;
    private String email;
    private int tel;
    private int zarPlata;
    private int age;

    public Person(String _name, String _job, String _email, int _tel,
    int _zarPlata, int _age) {
        name = _name;
        job = _job;
        email = _email;
        tel = _tel;
        zarPlata = _zarPlata;
        age = _age;
    }

    public String showPerson() {
        return name + ", " + job + ", " + email + ", " + tel + ", " +
        zarPlata + ", " + age;
    }

    public String toString() {
        return name + ", " + job + ", " + email + ", " + tel + ", " +
        zarPlata + ", " + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {return name;}

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {return job;}

    public void setEmail(String job) {
        this.email = email;
}

    public String getEmail() {return email;}

    public void setTel(int tel) {
        if (age > 0) 
            this.tel = tel;
        else
            System.out.println("Введён некорректный номер");
    }

    public int getTel() {return tel;}

    public void setZarPlata(int zarPlata) {
        if (age > 0) 
            this.zarPlata = zarPlata;
        else
            System.out.println("Введана некорректная зарплата");
    }

    public int getZarPlata() {return zarPlata;}

    public void setAge (int age) {
        if (age > 0) 
            this.age = age;
        else
            System.out.println("Введён некорректный возраст");
    }

    public int getAge() {return age;}
}
