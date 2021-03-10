import java.util.Scanner;

public class LessonOneExerciseThreeB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float x, y;

        System.out.println("Введите переменную X: ");
        x = scanner.nextFloat();
        System.out.println("Введите переменную Y: ");
        y = scanner.nextFloat();

        if ((x >= -1) && (y <= 1) && (y >= x)) {
            System.out.println("Успех! Координаты попадают в область.");
        } else {
            System.out.println("Провал. Координаты не попадают в область.");
        }

        scanner.close();
    }
}
