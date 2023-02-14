import java.util.function.*;

public class Main {
    public static void main(String[] args) {

        insertSeparator();
        System.out.println("Задача 1");
        insertSeparator();
        // Напишите реализации функционального интерфейса Predicate, которые проверяют, является ли число положительным.
        // Если число положительное, то предикат должен возвращать true, в противном случае — false.

        System.out.println("Реализация интерфейса Predicate через анонимный класс:");
        Predicate<Integer> positiveNumber1 = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return integer >= 0;
            }
        };
        System.out.println(positiveNumber1.test(7));
        System.out.println(positiveNumber1.test(-7));

        System.out.println("Реализация интерфейса Predicate через лямбду:");
        Predicate<Integer> positiveNumber2 = integer -> (integer >= 0.0);
        System.out.println(positiveNumber2.test(-3));
        System.out.println(positiveNumber2.test(0));

        insertSeparator();
        System.out.println("Задача 2");
        insertSeparator();
        // Создайте функциональный интерфейс Consumer, который принимает на вход имя человека
        // и выводит в консоль приветствие в его адрес.

        System.out.println("Реализация интерфейса Consumer через анонимный класс:");
        Consumer<String> greeting1 = new Consumer<>() {
            @Override
            public void accept(String name) {
                System.out.println("Доброе утро, " + name + "!");
            }
        };
        greeting1.accept("Алексей");
        greeting1.accept("Ольга");

        System.out.println("Реализация интерфейса Consumer через лямбду:");
        Consumer<String> greeting2 = name -> System.out.println("Доброе утро, " + name + "!");
        greeting2.accept("Екатерина");
        greeting2.accept("Захар");

        insertSeparator();
        System.out.println("Задача 3");
        insertSeparator();
        // Реализуйте функциональный интерфейс Function, который принимает на вход вещественное число типа
        // Double, а возвращает его округленный вариант типа Long.

        System.out.println("Реализация интерфейса Consumer через анонимный класс:");
        Function<Double, Long> roundedNumber1 = new Function<>() {
            @Override
            public Long apply(Double number) {
                return Math.round(number);
            }
        };
        System.out.println(roundedNumber1.apply(1034.98));
        System.out.println(roundedNumber1.apply(456027.0830135228));

        System.out.println("Реализация интерфейса Function через лямбду:");
        Function<Double, Long> roundedNumber2 = number -> Math.round(number);
        System.out.println(roundedNumber2.apply(653.21));
        System.out.println(roundedNumber2.apply(83450184.923402));

        insertSeparator();
        System.out.println("Задача 4");
        insertSeparator();
        // Напишите Supplier, который возвращает случайное число из диапазона от 0 до 100.

        System.out.println("Реализация интерфейса Supplier через анонимный класс:");
        Supplier<Integer> randomNumber1 = new Supplier<>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(randomNumber1.get());

        System.out.println("Реализация интерфейса Supplier через лямбду:");
        Supplier<Integer> randomNumber2 = () -> (int) (Math.random() * 100);
        System.out.println(randomNumber2.get());

        insertSeparator();
        System.out.println("Задача 5");
        insertSeparator();
        // Дан предикат condition и две функции: ifTrue и ifFalse. Напишите метод ternaryOperator, который из предиката
        // и двух функций построит новую функцию, возвращающую значение функции ifTrue, если предикат выполнен,
        // а в остальных случаях — ifFalse.
        // Реализация: если число положительное, умножаем его на 2, если отрицательное - возводим в квадрат.
        UnaryOperator<Integer> powerOfNumber = integer -> (int) (Math.pow(integer, 2));
        UnaryOperator<Integer> multipliedNumber = integer -> integer * 2;
        System.out.println(ternaryOperator(positiveNumber2, multipliedNumber, powerOfNumber).apply(3));
        System.out.println(ternaryOperator(positiveNumber2, multipliedNumber, powerOfNumber).apply(-7));
        insertSeparator();

    }

    public static Function<Integer, Integer> ternaryOperator(
            Predicate<Integer> condition,
            UnaryOperator<Integer> ifTrue,
            UnaryOperator<Integer> ifFalse) {
            return number -> condition.test(number) ? ifTrue.apply(number) : ifFalse.apply(number);
        }

    public static void insertSeparator() {
        System.out.println("======================================================");
    }
}