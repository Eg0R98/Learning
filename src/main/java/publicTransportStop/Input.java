package publicTransportStop;

import java.util.Scanner;

public class Input {
    public static void printResponse(String response) {
        System.out.println(response);
    }

    public static int inputStopID(Scanner scanner) {
        System.out.print("Ввведите числовой идентификатор остановки: ");
        int num = scanner.nextInt();
        return num;
    }

    public static boolean isStopProgram(Scanner scanner) {
        System.out.print("Если желаете завершить работу программы, введите exit. В противном случае введите любой символ: ");
        String str = scanner.next();
        if (str.equals("exit")) {
            return true;
        }
        return false;
    }


}
