package main.java.ExceptionsExerciseOneB;

public class Human {
    private String name;
    public Human(String name){
        super();
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
