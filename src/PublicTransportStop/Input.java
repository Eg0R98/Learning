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
                Document document = Request.httpRequest(num);
                Parsing.parseTableFromTransportStop(document);
                System.out.println("\nЕсли желаете завершить работу программы, введите exit. В противном случае введите любой символ");
                if (scanner.next().equals("exit")) break;
            }
        } catch (
                InputMismatchException e) {
            System.err.println("Ошибка. Некорректный ввод.");
        }
    }


}
