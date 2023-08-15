import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> {
        //учтём, что в делитель теоретически можно передать 0 и обработаем эту ситуацию
        if (y == 0) {
            System.out.println("Обнаружено деление на 0, в консоль будет будет выведено максимальное значение Integer, но это невалидное значение");
            return Integer.MAX_VALUE;
        } else {
            return x / y;
        }
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
