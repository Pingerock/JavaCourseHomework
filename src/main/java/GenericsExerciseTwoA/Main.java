package main.java.GenericsExerciseTwoA;

public class Main {
    public static void main(String[] args) {
        Task task = new Task<>();
        task.addObject(552);
        task.addObject("magic");
        task.addObject(123);
        task.addObject(552);
        task.addObject("flower");
        task.printList();
        task.deleteDuplicates(552);
        task.printList();
    }
}
