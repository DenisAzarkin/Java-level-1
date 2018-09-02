/*
 * Lesson_07.java
 * Java. Level 1. Lesson 7. Homework
 * 
 * Task 1 - Расширить задачу про котов и тарелки с едой.
 * Task 2 - Сделать так, чтобы в тарелке с едой не могло получиться
 *   отрицательного количества еды (например, в миске 10 еды, а кот
 *   пытается покушать 15-20)
 * Task 3 - Каждому коту нужно добавить поле сытость (когда создаем
 *   котов, они голодны). Если коту удалось покушать (хватило еды),
 *   сытость = true
 * Task 4. Считаем, что если коту мало еды в тарелке, то он ее просто
 *   не трогает, то есть не может быть наполовину сыт (это сделано для
 *   упрощения логики программы)
 * Task 5. Создать массив котов и тарелку с едой, попросить всех котов
 *   покушать из этой тарелки и потом вывести информацию о сытости котов
 *   в консоль
 * Task 6 - Добавить в тарелку метод, с помощью которого можно было бы
 *   добавлять еду в тарелку
 * 
 * @author Denis Azarkin
 * @version Sep 03, 2018
 */
 
public class Lesson_07 {
    public static void main (String[] args) {
        Cat[] cat = new Cat[15];
        Plate plate = new Plate(100);
        plate.info();

        for (int i = 0; i < cat.length - 1; i++) {
            cat[i] = new Cat("Cat" + i, 11);
            cat[i].eat(plate);
            if (plate.info() < 0) {
                break;
            }
            if (plate.info() == 0) {
                System.out.println("Cat" + i + " satiety: " 
                + cat[i].satietyInfo(true));
                break;
            }
            else {
                System.out.println("Cat" + i + " satiety: " 
                + cat[i].satietyInfo(false));
            }
            plate.info();
        }
    }
}

class Cat {
    private String name;
    private int appetite;
    private boolean satiety = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }
    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
    public boolean satietyInfo(boolean satiety) {
        if (satiety == false) {
            return false;
        }
        return true;
    }
}

class Plate {
    private int food;
    public Plate(int food) {
        this.food = food;
    }
    public void decreaseFood(int n) {
        if ((food - n) == 0) {
            System.out.println("Food is out!");
            food -= n;
        }
        if ((food - n) > 0) {
            food -= n;
        }
    }
    public int info() {
        System.out.println("plate: " + food);
        return food;
    }
}
