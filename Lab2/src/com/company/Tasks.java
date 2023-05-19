package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Класс Tasks описывает 8 задач 2-ой лабораторной работы. "
 * @author Сопин Владислав
 */
public class Tasks
{
    /** Метод task1 вычисляет значение выражения по формуле 17 варианта.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task1(int inputMode) throws FileNotFoundException {
        double x;
        double y;
        double result;
        if (inputMode == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите x = ");
            x = scanner.nextDouble();
            System.out.print("Введите y = ");
            y = scanner.nextDouble();
        } else {
            String path = "dataT1.txt";
            Scanner scanner = new Scanner(new File(path));
            x = scanner.nextDouble();
            System.out.println("Ввод x из файла, x = " + x);
            y = scanner.nextDouble();
            System.out.println("Ввод y из файла, y = " + y);
        }
        result = Math.exp(x) - (Math.pow(y,2) + 12 * x * y - 3 * Math.pow(x,2)) / (18 * y - 1);
        System.out.println("Результат: " + result);
    }

    /** Вычисляет площадь треугольника, две стороны которого равны а и b,
     * а угол между этими сторонами равен g.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла
     */
    public void task2(int inputMode) throws FileNotFoundException {
        double a;
        double b;
        double g;
        if (inputMode == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите сторону a: ");
            a = scan.nextDouble();
            System.out.print("Введите сторону b: ");
            b = scan.nextDouble();
            System.out.print("Введите угол между ними g: ");
            g = scan.nextDouble();
        } else {
            String path = "dataT2.txt";
            Scanner scanner = new Scanner(new File(path));
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            g = scanner.nextDouble();
            System.out.println("Ввод из файла, сторона a = " + a);
            System.out.println("Ввод из файла, сторона b = " + b);
            System.out.println("Ввод из файла, угол между ними g = " + g);
        }
        double result = 0.5 * a * b * Math.sin(Math.PI * g / 180);
        System.out.println("Площадь треугольника = " + result);
    }

    /** Метод task3 вычисляет плату за пользование телефоном для введенного
     * времени разговоров за месяц
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException при ошибке открытия файла
     */
    public void task3(int inputMode) throws FileNotFoundException {
        double A, B, C, D;
        if (inputMode == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите установленную норму времени раговора A мин. в месяц: ");
            A = scan.nextDouble();
            System.out.print("Введите плату за устоновленную норму времени разговора B руб.: ");
            B = scan.nextDouble();
            System.out.print("Введите плату за время разговора сверх нормы С руб./мин.: ");
            C = scan.nextDouble();
            System.out.print("Введите время разговоров за месяц D мин.: ");
            D = scan.nextDouble();
        } else {
            String path = "dataT3.txt";
            Scanner scanner = new Scanner(new File(path));
            A = scanner.nextDouble();
            B = scanner.nextDouble();
            C = scanner.nextDouble();
            D = scanner.nextDouble();
            System.out.println("Ввод установленной нормы времени раговора A мин. в месяц из файла, A = " + A);
            System.out.println("Ввод платы за устоновленную норму времени разговора B руб. из файла, B = " + B);
            System.out.println("Ввод платы за время разговора сверх нормы С руб./мин. из файла, С = " + C);
            System.out.println("Ввод времени разговоров за месяц D мин. из файла, D = " + D);
        }
        double pay;
        if (D <= A) {
            pay = B;
        } else {
            pay = B + (D - A) * C;
        }
        System.out.println("Плата за разговоры в этом месяце: " + pay);
    }

    /** Метод task4 по последней цифре числа определяет последнюю цифру его квадрата.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла
     */
    public void task4(int inputMode) throws FileNotFoundException {
        double n, m;
        if (inputMode == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите число n: ");
            n = scan.nextDouble();
        } else {
            String path = "dataT4.txt";
            Scanner scanner = new Scanner(new File(path));
            n = scanner.nextDouble();
            System.out.println("Ввод числа из файла, n = " + n);
        }
        System.out.println("Квадрат числа n = " + n * n);

        n = n % 10; // Последняя цифра числа n
        System.out.println("Последняя цифра числа n = " + n);
        m = (n*n) % 10; // Последняя цифра квадрата числа n
        System.out.print("Последняя цифра квадрата числа = " + m);
    }

    /** Метод task5 Программа по последней цифре данного числа
     * определяет последнюю цифру куба этого числа
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task5(int inputMode) throws FileNotFoundException {
        double n;
        if (inputMode == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите число n: ");
            n = scan.nextDouble();
        } else {
            String path = "dataT5.txt";
            Scanner scanner = new Scanner(new File(path));
            n = scanner.nextDouble();
            System.out.println("Ввод числа из файла, n = " + n);
        }
        System.out.println("Куб числа n = " + Math.pow(n,3));

        n = n % 10; // Последняя цифра числа n
        System.out.println("Последняя цифра числа n = " + n);
        System.out.print("Последняя цифра куба числа n = ");
        switch ((int) n) {
            case 2:
                System.out.println(8);
                break;
            case 3:
                System.out.println(7);
                break;
            case 7:
                System.out.println(3);
                break;
            case 8:
                System.out.println(2);
                break;
            default:
                System.out.println(n);
                break;
        }
    }

    /** Метод task6 выводит на экран простые числа от 2 до введенного n.
     * @param inputMode параметр передает режим ввода данных
     * @exception FileNotFoundException При ошибке открытия файла
     * */
    public void task6(int inputMode) throws FileNotFoundException {
        int n;
        if (inputMode == 1) {
            Scanner scan = new Scanner(System.in);
            System.out.print("Введите число n > 2: ");
            n = scan.nextInt();
        } else {
            String path = "dataT6.txt";
            Scanner scanner = new Scanner(new File(path));
            n = scanner.nextInt();
            System.out.println("Ввод числа n из файла, n = " + n);
        }
        for (int i = 2; i <= n; i++) {
            for (int k = 2; k <= n; k++) {
                if (i % k == 0 && i != k) break;
                else if (i == k) System.out.print(i + " ");
            }
        }
    }

    /** Метод task7 находит сумму n членов ряда
     * @param inputMode параметр передает режим ввода данных
     * @exception FileNotFoundException При ошибке открытия файла
     */
    public void task7(int inputMode) throws FileNotFoundException {
        int n;
        float x;
        float sum = 0;
        if (inputMode == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число n: ");
            n = scanner.nextInt();
            System.out.print("Введите число x: ");
            x = scanner.nextFloat();
        } else {
            String path = "dataT7.txt";
            Scanner scanner = new Scanner(new File(path));
            n = scanner.nextInt();
            System.out.println("Ввод из файла числa n: " + n);
            x = scanner.nextFloat();
            System.out.println("Ввод из файла числa x: " + x);
        }
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(-1,i - 1) * (Math.cos(i * x) / n);
        }
        System.out.println("Сумма n членов ряда = " + sum);
    }

    /** Метод task8.
     * @param inputMode параметр передает режим ввода данных.
     * @exception FileNotFoundException При ошибке открытия файла.
     */
    public void task8(int inputMode) throws FileNotFoundException {
        int n;
        if (inputMode == 1) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите число n: ");
            n = scanner.nextInt();
        } else {
            String path = "dataT8.txt";
            Scanner scanner = new Scanner(new File(path));
            n = scanner.nextInt();
            System.out.println("Ввод из файла числa n: " + n);
        }
        System.out.println("Таблица квадратов");
        for (int i = n; i < n + 10; i++) {
            System.out.println("Квадрат числа " + i + " = " + Math.pow(i,2));
        }
    }
}


