/** Программа вычисляющая факториал целого числа
 * @author Сопин Владислав
 */
import java.util.Scanner;
public class Main {
    /** Метод расчитывает факториал умножением всех чисел
     * от 1 до введенного значения
     * @param args (не используется)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число:");
        int n = scan.nextInt();//n - введенное число для которого будет расчитываться факториал
        int f = 1; //f - факториал
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        System.out.println("Факториал введенного числа равен " + f);
    }
}
