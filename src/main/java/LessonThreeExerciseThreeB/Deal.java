package main.java.LessonThreeExerciseThreeB;

public class Deal {

    String[] cardName = {"Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь",
            "Девять", "Десять", "Валет", "Дама", "Король", "Туз"};

    String[] suit = {"Черви", "Бубен", "Трефы", "Пики"};

    String[] deck = new String[52];

    //Создаёт отсортированную колоду
    public void makeADeck() {
        int deckNumber = 0;
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < cardName.length; j++) {
                deck[deckNumber] = cardName[j] + " " + suit[i];
                deckNumber++;
            }
        }
    }

    //раздача карт между указанным количеством игроков
    public void cardDeal(int n) {
        String[][] player = new String[5][n];
        int deckNumber = 0;
        for (int b = 0; b < 5; b++) {
            for (int a = 0; a < n; a++) {
                player[b][a] = deck[deckNumber];
                deckNumber++;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Рука игрока №" + (i + 1));
            for (int u = 0; u < 5; u++) {
                System.out.println(player[u][i]);
            }
            System.out.print("\n");
        }
        System.out.println("Раздача выполнена. Начинается игра.");
    }
}
