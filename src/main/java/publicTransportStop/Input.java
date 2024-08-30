package publicTransportStop;

import java.util.Map;
import java.util.Scanner;

public class Input {
    public static void printResponse(String response) {
        System.out.println(response);
    }

    public static String inputTitle(Scanner scanner) {
        System.out.print("Ввведите название остановки: ");
        String title = scanner.next();
        System.out.println();
        return title;

    }

    public static boolean isStopProgram(Scanner scanner) {
        System.out.print("Если желаете завершить работу программы, введите exit. В противном случае введите любой символ: ");
        String str = scanner.next();
        System.out.println();
        if (str.equals("exit")) {
            return true;
        }
        return false;
    }

    public static void printMatches(Map<Integer, Stop> matches) {
        for (int key : matches.keySet()) {
            System.out.printf("%s. %s %s %s", key, matches.get(key).getTitle(), matches.get(key).getAdjacentStreet(), matches.get(key).getDirection());
            System.out.println();

            if (!matches.get(key).getBusNumbers().isEmpty()) {
                System.out.printf("автобусы: %s", readyBusesForPrint(matches.get(key).getBusNumbers()));
                System.out.println();
            }
            if (!matches.get(key).getTrolleybusesNumbers().isEmpty()) {
                System.out.printf("троллейбусы: %s", matches.get(key).getTrolleybusesNumbers());
                System.out.println();
            }
            if (!matches.get(key).getTramsNumbers().isEmpty()) {
                System.out.printf("травмваи: %s", matches.get(key).getTramsNumbers());
                System.out.println();
            }
            if (!matches.get(key).getElectricTrainsNumbers().isEmpty()) {
                System.out.printf("электрички: %s", matches.get(key).getElectricTrainsNumbers());
                System.out.println();
            }
            if (!matches.get(key).getRiverTransportsNumbers().isEmpty()) {
                System.out.printf("речной транспорт: %s", matches.get(key).getRiverTransportsNumbers());
                System.out.println();
            }
            if (!matches.get(key).getMetrosNumbers().isEmpty()) {
                System.out.printf("станции метро: %s", matches.get(key).getMetrosNumbers());
                System.out.println();
            }
        }
        System.out.println();
    }

    public static int chooseNumberOfMatches(Scanner scanner) {
        System.out.print("Выберите соответвующую вашему запросу остановку и направление из списка. Для этого введите их номер: ");
        int numberStop = scanner.nextInt();

        return numberStop;
    }

    private static String readyBusesForPrint(String buses) {
        int index = buses.lastIndexOf(", ");
        StringBuilder builder = new StringBuilder(buses);
        builder.deleteCharAt(index);
        return builder.toString();
    }


}
