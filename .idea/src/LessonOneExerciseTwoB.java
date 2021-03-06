import java.util.Scanner;

public class LessonOneExerciseTwoB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int y;
        System.out.println("Введите число: ");
        int x = scanner.nextInt();

        if (x > 0) {
            y = 3 * x - 5;
        } else if (x < 0) {
            y = 2 * x * (-1) - 1;
        } else {
            y = 0;
        }
        System.out.println("Y равен " + y);
        scanner.close();
    }
}
