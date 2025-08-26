public class JavaCorePart1 {

    public static void main(String[] args) {
        int a = (int) (Math.random() * 10);
        int b = (int) (Math.random() * 10);
        double c = (Math.random() * 10);
        double d = 0.0 / 0.0;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println();


        // арифметические операции ( + , -, * , /) над двумя примитивами типа int
        System.out.println("Сложение a и b -> " + (a + b));
        System.out.println("Вычитание a и b -> " + (a - b));
        System.out.println("Умножение a и b -> " + (a * b));
        System.out.println("Деление a и b -> " + (a / b));
        System.out.println();

        //арифметические операции над int и double в одном выражении
        System.out.println("Умножение a и c -> " + (a * c));
        System.out.println("Деление a и c -> " + (a + c));
        System.out.println();

        //логические операции ( < , >, >=, <= )
        System.out.println("Сравнение a и b -> " + (a > b));
        System.out.println("Сравнение a и c -> " + (b >= c));
        System.out.println();

        //диапазоны типов данных для вещественных / чисел с плавающей точкой
        //максимальные и минимальные значения
        System.out.println("Минимальное значение типа Float -> " + Float.MIN_VALUE);
        System.out.println("Максимальное значение типа Float -> " + Float.MAX_VALUE);
        System.out.println("Минимальное значение типа Double -> " + Double.MIN_VALUE);
        System.out.println("Максимальное значение типа Double -> " + Double.MAX_VALUE);
        System.out.println();

        //переполнение
        System.out.println("Переполнение через нижнюю границу типа Float -> " + (Float.MIN_VALUE - 1));
        System.out.println("Переполнение через верхнюю границу типа Float -> " + (Float.MAX_VALUE + 1));
        System.out.println("Результат деления на ноль -> " + d);
        System.out.println("Переполнение при арифметической операции через верхнюю границу типа Integer -> " + (Integer.MAX_VALUE + 1));
        System.out.println("Переполнение при арифметической операции через нижнюю границу типа Integer -> " + (Integer.MIN_VALUE - 1));

    }
}
