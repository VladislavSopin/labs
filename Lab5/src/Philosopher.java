import java.lang.Runnable;
import java.util.Random;

/**
 * Класс Philosopher реализует поведение философов
 */
class Philosopher implements Runnable {

    private final float chanceToEat = 0.3f; // Шанс, что философ будет есть
    private final float chanceToThink = 0.3f; // Шанс, что философ будет думать
    private int number; // Номер философа
    private Fork leftFork; // Левая вилка
    private Fork rightFork; // Правая вилка
    private Random random; // Переменная для последовательности псевдослучайных чисел
    private STATES state; // Создаем перечисление констант для состояний философов
    // Задаем конкретные перечисления
    private enum STATES {
        THINKING, // Думает
        EATING; // Ест
    }

    /**
     * Метод для инициализации философа
     * @param number номер философа
     * @param leftFork вилка слева от философа
     * @param rightFork вилка справа от философа
     */
    public Philosopher(int number, Fork leftFork, Fork rightFork) {
        this.number = number;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        random = new Random(System.nanoTime()); // Случайное число от 0 до 1 с точностью около 1/10000-й секунды
        state = STATES.THINKING; // Начальное состояние философа (думает)
    }

    /**
     * Метод определяет когда пора есть
     * @return возвращает "Истинну", если случайное число от 0 до 1 < 0.3
     */
    boolean isTimeToEat() {
        return random.nextFloat() < chanceToEat;
    }

    /**
     * Метод определяет когда пора думать
     * @return возвращает "Истинну", если случайное число от 0 до 1 < 0.3
     */
    boolean isTimeToThink() {
        return random.nextFloat() < chanceToThink;
    }

    /**
     * Переопределение метода, который выполняется при запуске потока
     */
    @Override
    public void run() {
        System.out.println("Философ № " + number + " думает.");
        // Создается бесконечный цикл
        while(true) {
            try {
                // Проверяется статус философа
                switch(state) {
                    // Когда статус философа "думает"
                    case THINKING:
                        // Если настало время есть (isTimeToEat() возвращает истину)
                        if(isTimeToEat()) {
                            boolean wait = true; // Задаем ожидание в значение "Истина"
                            int i = 0; // Переменная для контроля вывода ожидающих философов
                            // Создаем цикл для ожидания вилок
                            while(wait) {
                                // Синхронизируем левую и правую вилки, чтобы доступ
                                // к ним имел только 1 поток
                                synchronized(leftFork) {
                                    synchronized(rightFork) {
                                        // Если количество разрешений в счетчике на текущий момент > 0 то
                                        if(leftFork.availablePermits() > 0 && rightFork.availablePermits() > 0) {
                                            leftFork.acquire(); // Запрашиваем разрешение на доступ к ресурсу (левой вилке)
                                            rightFork.acquire();// Запрашиваем разрешение на доступ к ресурсу (правой вилке)
                                            wait = false; // Устанавливаем ожидание в значение "Ложь" для выхода из цикла
                                            System.out.println("Философ № " + number + " ест.");
                                            state = STATES.EATING; // Устанавливаем статус философа в значение "Ест"
                                        } else {
                                            // Если количество разрешений равно 0, то
                                            // философ ожидает своей очереди
                                            if(i++ == 0) { // Сверяем i с 0, а затем увеличиваем его на 1
                                                System.out.println("Философ № " + number + " ждет.");
                                            }
                                            if(i > 100) { // Если i > 100, то произошла взаимная блокировка
                                                System.out.println("DEADLOCK");
                                            }
                                            Thread.sleep(1000); // Приостанавливаем поток на 1 секунду
                                        }
                                    }
                                }
                            }
                        } break;
                    // Когда статус философа "ест"
                        case EATING:
                            // Если настало время думать isTimeToThink() возвращает истину)
                            if(isTimeToThink()) {
                                leftFork.release(); // Философ освобождает левую вилку
                                rightFork.release(); // Философ освобождает правую вилку
                                System.out.println("Философ № " + number + " думает.");
                                state = STATES.THINKING; // Устанавливаем статус философа в значение "Думает"
                            }
                        }
                        Thread.sleep(1000); // Приостанавливаем поток на 1 секунду
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
