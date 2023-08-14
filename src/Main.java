public class Main {
    public static void main(String[] args) {

        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1,1);
        int c = calc.divide.apply(a, b); // при исходных данных ошибка возникает из-за того, что b инициализируется нулём
        //соответственно получаем исключение. Полагаю, что приемлемым вариантом в этой реализации будет переписать лямбда-выражение для divide

        calc.println.accept(c);
    }
}