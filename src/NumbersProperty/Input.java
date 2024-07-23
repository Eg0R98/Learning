package NumbersProperty;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in))  {
            System.out.print("Ввведите целое число: ");
            int num = scanner.nextInt();
            System.out.println("Введите оди из следующих типов факта: trivia, year, math, date");
            System.out.print("Тип факта: ");
            String fact = scanner.next().toLowerCase();

            System.out.println(Request.httpRequest(num, fact));
        } catch (InputMismatchException e) {
            System.err.println("Ошибка. Некорректный ввод.");
        }
    }
}
