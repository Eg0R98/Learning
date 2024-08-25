package publicTransportStop;

import java.util.List;
import java.util.Scanner;

public class Input {
    public static void printResponse(String response) {
        System.out.println(response);
    }

    public static String inputTitle(Scanner scanner) {
        System.out.print("Ввведите название остановки: ");
        String title = scanner.nextLine();
        System.out.println();
        return title;

    }

    public static boolean isStopProgram(Scanner scanner) {
        System.out.print("Если желаете завершить работу программы, введите exit. В противном случае введите любой символ: ");
        String str = scanner.nextLine();
        System.out.println();
        if (str.equals("exit")) {
            return true;
        }
        return false;
    }

    public static void printMatches(List<String> matches) {
        for (String s : matches) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static String chooseNumberOfMatches(Scanner scanner) {
        System.out.print("Выберите соответвующую вашему запросу остановку и направление из списка. Для этого введите их номер: ");
        String numberStop = scanner.nextLine();

        return numberStop;
    }

}
