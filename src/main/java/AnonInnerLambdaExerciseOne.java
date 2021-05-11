package main.java;

public class AnonInnerLambdaExerciseOne {

    public static void main(String[] args) {
        Name person = new Name("Igor");
        person.setSurname("Kiselev");
    }
}

class Name{
    private final String name;

    Name(String name){
        this.name = name;
    }

    public void setSurname(String familyName){
        //внутренний класс
        class Surname{
            void whoAmI(){
                System.out.printf("Тебя зовут %s %s ", name, familyName);
                //анонимный класс
                Anonim anon = new Anonim() {
                    void fatherName(String fatherName){
                        System.out.printf("%s. \n", fatherName);
                    }
                };
                anon.fatherName("Anatolyevich");
            }
            void howManyLetters(){
                //лямбда выражения
                Mathematics math = (int x, int y)->x+y;
                System.out.println("Имя + фамилия = " + math.sum(name.length(),familyName.length()) + " букв.");
            }
        }
        Surname surname = new Surname();
        surname.whoAmI();
        surname.howManyLetters();
    }
}

interface Mathematics{
    int sum(int x, int y);
}

class Anonim {
    void fatherName(String fName){
    }
}