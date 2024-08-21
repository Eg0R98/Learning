package numbersProperty;

import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static int inputNumber(Scanner scanner) {
        System.out.print("Ввведите целое число: ");
        int num = scanner.nextInt();
        return num;
    }

    public static String inputFact(Scanner scanner) throws IOException {
        System.out.println("Введите один из следующих типов факта: trivia, year, math, date");
        System.out.print("Тип факта: ");
        String fact = scanner.next().toLowerCase();
        if (!fact.equals("trivia") && !fact.equals("year")
                && !fact.equals("math") && !fact.equals("date")) throw new IOException("Некорректный ввод факта");
        return fact;
    }

    public static boolean isStopProgram(Scanner scanner) {
        System.out.print("Если желаете завершить работу программы, введите exit. В противном случае введите любой символ: ");
        String str = scanner.next();
        if (str.equals("exit")) {
            return true;
        }
        return false;
    }

    public static void printResponse(String response) {
        System.out.println(response);
    }
}
