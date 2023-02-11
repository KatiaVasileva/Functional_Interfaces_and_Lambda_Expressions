import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {

        insertSeparator();
        System.out.println("Задача 1");
        insertSeparator();
        // Напишите реализации функционального интерфейса Predicate, которые проверяют, является ли число положительным.
        // Если число положительное, то предикат должен возвращать true, в противном случае — false.
        System.out.println("Реализация интерфейса Predicate через анонимный класс:");

        Predicate<Integer> predicate1 = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };
        System.out.println(predicate1.test(7));
        System.out.println(predicate1.test(-7));

        System.out.println("Реализация интерфейса Predicate через лямбду:");
        Predicate<Integer> predicate2 = integer -> (integer >= 0);
        System.out.println(predicate2.test(-3));
        System.out.println(predicate2.test(0));

        insertSeparator();
        System.out.println("Задача 2");
        insertSeparator();
        // Создайте функциональный интерфейс Consumer, который принимает на вход имя человека и выводит в консоль приветствие в его адрес.
        System.out.println("Реализация интерфейса Consumer через анонимный класс:");

        Consumer<String> consumer1 = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Доброе утро, " + name + "!");
            }
        };
        consumer1.accept("Алексей");
        consumer1.accept("Ольга");

        System.out.println("Реализация интерфейса Consumer через лямбду:");
        Consumer<String> consumer2 = name -> System.out.println("Доброе утро, " + name + "!");
        consumer2.accept("Екатерина");
        consumer2.accept("Захар");

        insertSeparator();
        System.out.println("Задача 3");
        insertSeparator();

    }

    public static void insertSeparator() {
        System.out.println("======================================================");
    }
}