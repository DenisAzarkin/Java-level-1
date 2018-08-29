/*
 * lesson_01.java
 * Java. Level 1. Lesson 6. Homework
 * 
 * Task 1 - Создать классы Dog и Cat с наследованием от класса Animal.
 * Task 2 - Животные могут выполнять действия: бежать плыть,
 *   перепрыгивать препятствие. В качестве параметра каждому методу
 *   передаётся величина, означающая или длину препятствия (для бега и
 *   плавания), или высоту (для прыжков).
 * Task 3 - У каждого животного есть ограничения на действия (бег: кот
 *   200 м., собака 500 м.; прыжок: кот 2 м., собака 0.5 м.; плавание:
 *   кот не умеет плавать, собака 10 м.).
 * Task 4 - При попытке животного выполнить одно из этих действий, оно
 *   должно сообщить результат в консоль.
 * 
 * @author Denis Azarkin
 * @version Aug 30, 2018
 */

public class Lesson_06 {

    public static void main (String[] args) {
        IAnimal[] animals = {new Cat("Barsik", 200, 2, 10),
            new Cat("Pushok", 210, 33, 7),
            new Dog("Tuzik", 500, 0.5d, 10),
            new Dog("Reks", 500, 0.6d, 9)};
            for (IAnimal animal : animals)
                System.out.println(animal + " does " + "run: " + 
                animal.run()+ ", " + "swim: " + animal.jump() + ", " + 
                "jump: " + animal.swim());
    }
}

class Cat extends Animal {
    Cat(String name, int run, double jump, int swim) {
        super(name, run, jump, swim);
    }
    @Override
    public boolean run() {
        if (run <= 200) {
            return true;
        }
        return false;
    }
    @Override
    public boolean jump() {
        if (jump <= 2) {
            return true;
        }
        return false;
    }
    @Override
    public boolean swim() {
        return false;
    }
}

class Dog extends Animal {
    Dog(String name, int run, double jump, int swim) {
        super(name, run, jump, swim);
    }
    @Override
    public boolean run() {
        if (run <= 500) {
            return true;
        }
        return false;
    }
    @Override
    public boolean jump() {
        if (jump <= 0.5d) {
            return true;
        }
        return false;
    }
    @Override
    public boolean swim() {
        if (swim <= 10) {
            return true;
        }
        return false;
    }
}

interface IAnimal {
    abstract boolean run();
    abstract boolean jump();
    abstract boolean swim();
}

abstract class Animal implements IAnimal{
    String name;
    int run;
    double jump;
    int swim;

    Animal (String name, int run, double jump, int swim) {
        this.name = name;
        this.run = run;
        this.jump = jump;
        this.swim = swim;
    }

    public abstract boolean run();
    public abstract boolean jump();
    public abstract boolean swim();

    @Override
    public String toString() {
        return name;
    }
}
