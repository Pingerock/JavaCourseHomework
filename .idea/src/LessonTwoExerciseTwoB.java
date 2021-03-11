public class LessonTwoExerciseTwoB {
    public static void main(String[] args) {
        double A = Math.random() * 200 - 100;
        //A - вещественное число, случайно сгенерированное
        //в диапазоне от [-100;100].
        int N = (int) (Math.random() * 99 + 1);
        //N - целое случайное число в диапазоне (0; 100]
        System.out.println("Число А равно: " + A);
        System.out.println("Число N равно: " + N);
        double result = 1;
        for (int count = 1; count <= N; count++) {
            //count - количество итераций, не превышающий N.
            result += A * count;
        }
        //Цикл суммы формулы 1 + A + A * 2 + A * 3 + ... + A * N.
        //ПРИМЕЧАНИЕ: задание просит одним циклом найти сумму формулы, но
        //я вынес первое слагаемое (result = 1) за пределы цикла, так как
        //считаю это оптимальным решением.
        result = Math.round(result * 1000.0) / 1000.0;
        //Для упрощения вида, я округлил результат до 3 десятичных знаков.
        System.out.println("Результат вычисления формулы: " + result);
    }
}
