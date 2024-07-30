package PublicTransportStop;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Ввведите числовой идентификатор остановки: ");
                int num = scanner.nextInt();
                System.out.println();
                Document document = Request.httpRequest(num);
                Input.parse(document);
                System.out.println("\nЕсли желаете завершить работу программы, введите exit. В противном случае введите любой символ");
                if (scanner.next().equals("exit")) break;
            }
        } catch (
                InputMismatchException e) {
            System.err.println("Ошибка. Некорректный ввод.");
        }
    }

    public static void parse(Document document) {
        Element headers = document.select("thead").getFirst();
        Elements td = headers.select("td");
        System.out.printf("%-14s", td.get(0).text());
        System.out.printf("%-59s", td.get(1).text());
        System.out.printf("%s", td.get(2).text());
        System.out.println();

        Elements tr = document.select("tbody").select("tr");

        for (int i = 0; i < tr.size(); i++) {
            Elements el = tr.get(i).select("td.trans-num, a, div.trans-model, td.trans-position");
            for (int j = 0; j < el.size() / 2; j++) {
                System.out.printf("%-14s", el.get(j).ownText());
            }
            System.out.println();

            for (int j = el.size() / 2; j < el.size(); j++) {
                System.out.printf("%27s", el.get(j).ownText());
                System.out.print("%-73s");
                //73
            }
            System.out.println();
        }
    }
}
