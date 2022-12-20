import java.util.Scanner;


class Main {

    static int operation; //глобальная переменная которую видно в других методах
    //МЕТОД ДЛЯ ПОДСЧЕТА ЭЛЕМЕНТОВ В СТРОКЕ
    public static String[] calc(String inputString)  throws Exception {

        String[] massive_num = inputString.split(" "); //здесь мы делаем массив из строки, разделяя по пробелу
        if (massive_num.length != 3) { // проверка, если счетчик не будет равен трем
            throw new Exception("Пример должен состоять из 3 элементов разделенных пробелом: 3 + 2.");
        }
        else{
            return massive_num;
        }
    }

    // МЕТОД ДЛЯ ПРОВЕРКИ ЧИСЕЛ ОТ 1 ДО 10
    public static void check_num ( int a, int b) throws Exception {
        if (a < 1 || b < 1 || a > 10 || b > 10)
            throw new Exception("Каждое число должны быть от 1 до 10, не больше!");
    }

    // МЕТОД ДЛЯ ПРОВЕРКИ ОПЕРАЦИИ И ВЫВОДА РЕЗУЛЬТАТА
    public static int calculation (int a, char c, int b) throws Exception{

        return switch (c) {
            case '+' -> operation = a + b;
            case '-' -> operation = a - b;
            case '*' -> operation = a * b;
            case '/' -> operation = a / b;
            default -> throw new Exception("Такой операции не существует!");
        };
    }

    // ОСНОВНОЙ МЕТОД ДЛЯ ПОЛУЧЕНИЯ СТРОКИ И НАЗНАЧЕНИЯ ПЕРЕМЕННЫХ ДЛЯ РАБОТЫ С НИМИ
    public static void main (String[] args) throws Exception {

        Scanner in = new Scanner(System.in); //создал переменную из которой подтягиваю вложенную функцию
        System.out.print("Введите числа и действие: ");
        String inputString = in.nextLine(); //получаю строку в переменную с помощью подтянутой функции некстЛайн

        String [] massive_num = calc(inputString); //Объявили новый массив и вернули (вложили) результат метода сверху

        int a = Integer.parseInt(massive_num[0]); // первое число
        int b = Integer.parseInt(massive_num[2]); // второе число
        char c = massive_num[1].charAt(0); // элемент состояния (+,-,*,/) charAt вытаскивает символ из массива по индексу
        // то есть если будет набор символов +-*/ - то по индексу 0 получим первый символ

        check_num(a,b); // вызов метода для проверки чисел на исключение
        operation = calculation(a, c, b); // вызов метода для проверки операции
        System.out.println("Ваш ответ: " + operation); // вывести в терминал ответ
    }
}