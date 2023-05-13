/** Вариант 17
 * Программа, в которой даны три целых числа, одно
 * из которых отлично от двух других, равных между собой.
 * Определить порядковый номер числа, отличного от остальных.
 * @author Сопин Владислав
 */
import java.util.Scanner;
public class Main {
    /** Метод предназначен для определения порядкового
     * номера числа, отличного от остальных.
     * @param args (не используется)
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] n = new int[3];
        System.out.println("Введите 3 целых числа, два из которых равны");
        for (int i = 0; i < 3; i++) n[i] = scan.nextInt();
        if (n[0] == n[1]) System.out.println("3е число отличается");
        else if (n[1] == n[2]) System.out.println("1е число отличается");
        else System.out.println("2е число отличается");
    }
}