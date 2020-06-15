package Next;

import java.io.StreamCorruptedException;
import java.util.Random;
import java.util.Scanner;

public class PoleChudes {

    static Random rand = new Random();
    static int n;
    static Scanner sc = new Scanner(System.in);
    static char[] word;
    static int[] opening;
    static int score = 1000;
    static int c = 0;

    public static void Theme() {
        int f = rand.nextInt(7);
        String[] questions = {
                "Железная дорога с канатной тягой, устраиваемая на крутых подьемах",
                "Бедный, неказистый домишко, избенка",
                "В Чили находится самое крупное сооружение подобного типа. Его длина – 1 километр",
                "Это оружие применялось для охоты на волков и лис. При таком способе охоты необходимо было нанести удар по носу зверя",
                "И болезнь, и камень",
                "Что проводит звук в десять раз быстрее воздуха",
                "Что Американская музыкальная конференция 1977 года определила как плохой деревянный духовой инструмент, на котором никто не умеет играть?"
        };
        String[] answers = {
                "фуникулер",
                "хибара",
                "бассейн",
                "нагайка",
                "нефрит",
                "гранит",
                "гобой"
        };
        System.out.println(questions[f]);
        CreateWord(answers[f]);

    }

    public static boolean GameEnd() {
        if (c == 0) {
            for (int i = 0; i < n; i++) {
                if (opening[i] == 0)
                    return true;
            }
        }
        if (c == 1) {
            System.out.println("Игра окончена! Вы уехали набрав " + score + " очков!");
            return false;
        }
        System.out.println("Игра окончена! Вы победили! Вы набрали " + score + " очков!");
        return false;
    }

    public static void WheelRotation() {
        int wheel;
        wheel = rand.nextInt(30);
        if (wheel == 5) {
            score -= 100000;
            System.out.println("Вы банкрот!");
        }
        if (wheel == 8 || wheel == 15) {
            score += 10000;
            System.out.println("Джекпот, +10000");
        }
        if (wheel == 4 || wheel == 20 || wheel == 7) {
            score += 500;
            System.out.println("Маленький подарочек, +500");
        }
        if (wheel == 9 || wheel == 17 || wheel == 23) {
            score -= 500;
            System.out.println("Не повезло, -500");
        }
        if (wheel == 24 || wheel == 11) {
            String car, yes, no;
            System.out.println("Автомобииииииииииль!!!!!!!");
            System.out.println("Забираете?");
            car = sc.nextLine();
            if (car.compareTo("нет") == 0)
                score += 10000;
            if (car.compareTo("да") == 0) {
                c = 1;
            }
        }

    }

    public static void Step() {
        char buf = 0, ok = 0;
        System.out.println("Введите букву");

        try {
            buf = sc.nextLine().charAt(0);
        } catch (java.lang.StringIndexOutOfBoundsException e) {
            System.out.println("Вы не ввели букву");
        }
        for (int i = 0; i < n; i++) {
            if (word[i] == buf || opening[i] == 1) {
                System.out.print(word[i] + " ");
                opening[i] = 1;
                if (word[i] == buf)
                    ok = 1;
            } else {
                System.out.print("_ ");
            }
        }
        System.out.println();
        if (ok == 0) {
            System.out.println("Не угадали");
            score -= 100;
        } else {
            System.out.println("Угадали!");
            score += 300;
        }
        System.out.println("Ваш счет " + score);
        System.out.println();
    }

    public static void CreateWord() {
        n = rand.nextInt(9) + 2;
        opening = new int[n];
        word = new char[n];
        for (int i = 0; i < n; i++) {
            word[i] = (char) (rand.nextInt(27) + 97);
            opening[i] = 0;
            System.out.print("_ ");
        }
        System.out.println();
        //return word;
    }

    public static void StartGame() {
        System.out.println();
        System.out.println("Приветствую тебя, дорогой игрок! Сегодня ты будешь играть в Поле чудес! Начнем же!");
        Theme();

        while (GameEnd()) {
            WheelRotation();
            if (score < 0) {
                System.out.println("К сожалению вы проиграли. Ваш счет стал отрицательным.");
                return;
            }
            if (c == 0)
                Step();
        }
    }

    public static void CreateWord(String str) {
        n = str.length();
        opening = new int[n];
        word = new char[n];
        for (int i = 0; i < n; i++) {
            word[i] = str.charAt(i);
            opening[i] = 0;
            System.out.print("_ ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StartGame();
    }
}
