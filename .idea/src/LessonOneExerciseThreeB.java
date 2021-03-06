import java.util.Scanner;

public class LessonOneExerciseThreeB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float x, y;
        boolean check = false;
        System.out.println("Введите переменную X: ");
        x = scanner.nextFloat();
        System.out.println("Введите переменную Y: ");
        y = scanner.nextFloat();

        if (x >= -1) {
            if (y <= 1) {
                if ((y <= x) && (x <= y)) {
                    System.out.println("Успех! Координаты попадают в область.");
                    check = true;
                }
            }
        }
        if (!check) {
            System.out.println("Провал. Координаты не попадают в область.");
        }
        scanner.close();
    }
}
