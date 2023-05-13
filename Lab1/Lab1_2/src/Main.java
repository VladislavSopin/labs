/** Программа, в которой все переданные во входную строку
 * аргументы выводятся на экран в обратном порядке.
 * @author Сопин Владислав
 */
import java.util.Scanner;
public class Main {
    /** Метод предназначен для вывода введенных символов строки
     * в обратном порядке в консоль
     * @param args (не используется)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку");
        String str;
        str = scan.nextLine();
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }
}