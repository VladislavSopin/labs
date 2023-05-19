import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class linkFinder {
    /** На вход программы подается произвольный html-файл, затем происходит
     * извлечение из него всех ссылок и считается их повторение
     * @param inPath   путь к файлу с HTML-кодом, который нужно обработать
     * @param outPath  путь к файлу, в который нужно записать результат
     */
    public static void findeLink(Path inPath, String outPath) {
        // Чтение HTML-кода из файла
        String html;
        try {
            html = Files.readString(inPath);
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            return;
        }

        // Создание регулярного выражения для поиска тегов с ссылками
        Pattern pattern = Pattern.compile("<[link|a|img]+\\s+(?:[^>]*?\\s+)?[src|href]+=[\"']([^\"']*)['\"]");
        // Поиск ссылок в html файле
        Matcher matcher = pattern.matcher(html);
        // Создается HashMap для хранения ссылок и их повторений
        Map<String, Integer> links = new HashMap<>();
        // Перебираем ссылки
        while (matcher.find()) {
            String link = matcher.group(1);
            // Если ссылка уже существует, то увеличавается число ее повторений на 1
            // Иначе добавляется новая запись в HashMap links
            if (links.containsKey(link)) {
                links.put(link, links.get(link) + 1);
            } else {
                links.put(link, 1);
            }

        }
        // Запись в выходной файл
        try {
            FileWriter writer = new FileWriter(outPath);
            for (Map.Entry<String, Integer> entry : links.entrySet()) {
                String link = entry.getKey();
                int count = entry.getValue();
                writer.write(link + " " + count + "\n");
                // Вывод в консоль
                System.out.println(link + " " + count);
            }
            writer.close();
            System.out.println("Запись в файл прошла успешно!");
        } catch (Exception e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    /** Точка входа в программу.
     * @param args аргументы командной строки(не используется)
     */
    public static void main(String[] args) {
        Path inPath = Paths.get("inFile.html"); // Путь к входному файлу
        String outPath = "outFile.txt"; // Путь к выходному файлу
        findeLink(inPath, outPath);
    }
}
