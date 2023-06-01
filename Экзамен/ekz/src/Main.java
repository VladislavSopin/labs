import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Пример кода, который выбрасывает исключение, если пользователь вводит пустую строку, строку из пробелов
 * или строку со значением "exception", или если при чтении из файла встречается пустая строка.
 */
class EmptyStringExceptionExample {

    /**
     * Основной метод программы.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите строку:");
        String input = scanner.nextLine();

        try {
            if (isStringEmpty(input)) {
                throw new EmptyStringException("Введена пустая строка или строка из пробелов.");
            }

            if (input.equalsIgnoreCase("exception")) {
                throw new CustomException("Введено значение \"exception\".");
            }

            // Дальнейшая обработка введенной строки
            System.out.println("Введенная строка: " + input);

            // Чтение из файла
            String filename = "example.txt";
            processFile(filename);
        } catch (EmptyStringException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (CustomException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при чтении из файла: " + e.getMessage());
        } catch (OutOfMemoryError e) {
            System.out.println("Ошибка: Нехватка памяти. Пожалуйста, освободите память и повторите попытку.");
        }
    }

    /**
     * Проверяет, является ли строка пустой или состоящей только из пробелов.
     *
     * @param str проверяемая строка
     * @return {@code true}, если строка пустая или состоит только из пробелов, иначе {@code false}
     */
    private static boolean isStringEmpty(String str) {
        return str.trim().isEmpty();
    }

    /**
     * Читает строки из файла и выполняет обработку.
     *
     * @param filename имя файла
     * @throws IOException              если возникла ошибка при чтении файла
     * @throws EmptyStringException     если встретилась пустая строка в файле
     * @throws OutOfMemoryError         если возникла нехватка памяти
     */
    private static void processFile(String filename) throws IOException, EmptyStringException, OutOfMemoryError {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            if (isStringEmpty(line)) {
                reader.close();
                throw new EmptyStringException("Обнаружена пустая строка в файле.");

            }
            // Дальнейшая обработка строки из файла
            System.out.println("Прочитанная строка из файла: " + line);
        }
        reader.close();
    }
}

/**
 * Исключение, выбрасываемое при пустой строке или строке из пробелов.
 */
class EmptyStringException extends Exception {

    /**
     * Конструктор класса исключения.
     *
     * @param message сообщение об ошибке
     */
    public EmptyStringException(String message) {
        super(message);
    }
}

/**
 * Исключение, выбрасываемое при вводе строки со значением "exception".
 */
class CustomException extends Exception {

    /**
     * Конструктор класса исключения.
     *
     * @param message сообщение об ошибке
     */
    public CustomException(String message) {
        super(message);
    }
}