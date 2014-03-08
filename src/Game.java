import java.io.Console;
import java.util.Random;


public class Game {
    public static void main(String[] args) {
        int humanrocks, botrocks, humanthinks, botthinks, rocksum, humanchoise, botchoise;
        boolean gameend=false;
        humanrocks=4;   // по 4 камня, чтобы рандом брал от 0 до 3
        botrocks=4;
        Random r = new Random();
        Console c = System.console();
        do {

            boolean correct=false;
            System.out.println();     //чтобы не сливались строки

            do {             //ввод юзером камушков + проверка на идиота
                System.out.println("Choose how many stone you take(You have "+(humanrocks-1)+", bot have "+(botrocks-1)+"): ");
                humanchoise = Integer.valueOf(c.readLine());
                if ((humanchoise>=0) & (humanchoise<=humanrocks-1)) correct=true;
                else {
                    System.out.println("Incorrect input. Try again.");
                    System.out.println();   //чтобы не сливались строки
                    continue;
                };
            }while(correct==false);

            botchoise = r.nextInt(botrocks);
            rocksum=humanchoise+botchoise;

            correct=false;
            do {    //спрашиваем вариант юзера о сумме + проверка на невероятного кретина
                System.out.println("What do you think about the sum of rocks?");
                humanthinks = Integer.valueOf(c.readLine());
                if ((humanthinks<=humanrocks+botrocks-2) & (humanthinks>=0)) correct=true;
                else {
                    if (humanthinks>humanrocks+botrocks-2) System.out.println("It's not possible, there are no so many rocks in the game! Try again: ");
                    if (humanthinks<0) System.out.println("How can it be a negative number?! Try again: ");
                    continue;
                }
            }while(correct==false);

            do {
                botthinks = botchoise+r.nextInt(humanrocks);
            }while(botthinks == humanthinks);  //сверяем с ответом юзера (не самое изящное решение, да)

            if (humanthinks==rocksum) {
                --humanrocks;
                System.out.println("Yes! You've guessed rocks sum.");
            }
            else if (botthinks==rocksum) {
                --botrocks;
                System.out.println("Hah, bot is right. His answer is: " +botthinks);
                }
                    else System.out.println("No one guessed");


            if (humanrocks==1) {
                System.out.println("Congratulations! You have won!");
                gameend=true;
            }
            if (botrocks==1) {
                System.out.println("Lol, look at this looser!");
                gameend=true;
            }

        } while(gameend==false);
    }

}
