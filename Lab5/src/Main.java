public class Main {
    /**
     * Главный метод программы для запуска потоков
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        final int count = 5; // Количество философов
        Fork[] forks = new Fork[count]; // Вилки
        // Определяем, что к каждой вилке одновременно может
        // иметь доступ только 1 философ
        for(int i = 0; i < count; i++) {
            forks[i] = new Fork(1);
        }
        // Запуск потоков
        for(int i = 0; i < count; i++) {
            new Thread(new Philosopher(i, forks[(i + 1) % count], forks[i])).start();
        }
    }
}