package PublicTransportStop;

import org.jsoup.select.Elements;

import java.util.Scanner;

public class Input {
    public static void headersPrintFromServer(Elements elements) {
        System.out.printf("%-14s", elements.get(0).text());
        System.out.printf("%-59s", elements.get(1).text());
        System.out.printf("%s", elements.get(2).text());
        System.out.println();
    }

    public static void tablePrintFromServer(Elements elements) {
        for (int i = 0; i < elements.size(); i++) {
            Elements el = elements.get(i).select("td.trans-num, a, div.trans-model, td.trans-position");
            for (int j = 0; j < el.size() / 2; j++) {
                System.out.printf("%-14s", el.get(j).ownText());
            }
            System.out.println();
            for (int j = el.size() / 2; j < el.size(); j++) {
                System.out.printf("%-14s", "");
                System.out.printf("%-45s", el.get(j).ownText());
            }
            System.out.println();
        }
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

    public static void PrintFromCache(String headersAndTableFromCache) {
        System.out.println(headersAndTableFromCache);
    }


}
