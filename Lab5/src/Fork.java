import java.util.concurrent.Semaphore;
/**
 * Класс для реализации доступа к вилкам
 */
class Fork extends Semaphore {
    /**
     * Метод предназначен для синхронизации доступа к ресурсу (вилкам)
     * @param permits параметр, определяющий сколько потоков одновременно
     *                могут иметь доступ к ресурсу (вилкам)
     */
    public Fork(int permits) {
        super(permits);
    }
}
