public class LessonTwoExerciseThreeB {
    public static void main(String[] args) {
        int[] array = new int[10];
        //создаем массив на 10 ячеек
        for (int a = 0; a < array.length; a++) {
            array[a] = (int) (Math.random() * 100 + 1);
        }
        //заполняем ячейки массива случайными целыми числами в диапазоне (0;100]
        System.out.println("Сгенерированный массив: ");
        for (int j : array) {
            System.out.print(j + " ");
        }
        //Выводим массив до сортировки
        for (int min = 0; min < array.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < array.length; j++) {
                if (array[j] < array[least]) {
                    least = j;
                }
            }
            int temp = array[min];
            array[min] = array[least];
            array[least] = temp;
        }
        //Сортировка выбором(Selection sort). На лекции мы обсуждали только метод
        //Arrays.sort(), который выполняет алгоритм Quick Sort.
        //Поэтому я посмотрел алгоритм работы моей сортировки в Википедии.
        System.out.println("\nОтсортированный массив: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        //Выводим отсортированный массив
    }
}
