import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> divide = (x, y) -> {
        //обернём в try-catch, чтобы программа завершалась корректно.
        //возврат 0 в случае деления на 0, конечно, тоже не очень хорошо, так как это вполне себе значение,
        //но чтобы этого не делать (возвращать 0), нужно править код в Mаin, а этого, наверное, нельзя делать
        int result = 0;
        try {
            result = x / y;
        } catch (ArithmeticException e) {
            System.out.println("Обнаружено деление на 0, в консоль будет будет выведен 0, но это невалидное значение");
        }
        return result;
    };

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
