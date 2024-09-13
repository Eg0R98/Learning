package publicTransportStop;

import java.util.List;
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

    public static void printMatches(List<Stop> matches) {
        for (int i = 0; i < matches.size(); i++) {
            Stop stop = matches.get(i);
            System.out.printf(Stop.createFullStopTitle(stop, i + 1));
            System.out.println();

            if (!stop.getBuses().isEmpty()) {
                System.out.printf("автобусы: %s", stop.getBuses());
                System.out.println();
            }
            if (!stop.getTrolleybuses().isEmpty()) {
                System.out.printf("троллейбусы: %s", stop.getTrolleybuses());
                System.out.println();
            }
            if (!stop.getTrams().isEmpty()) {
                System.out.printf("травмваи: %s", stop.getTrams());
                System.out.println();
            }
            if (!stop.getElectricTrains().isEmpty()) {
                System.out.printf("электрички: %s", stop.getElectricTrains());
                System.out.println();
            }
            if (!stop.getRiverTransports().isEmpty()) {
                System.out.printf("речной транспорт: %s", stop.getRiverTransports());
                System.out.println();
            }
            if (!stop.getMetros().isEmpty()) {
                System.out.printf("станции метро: %s", stop.getMetros());
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
}
