import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessingGame {
    private int generatedNumber;
    private int guessedNumber;
    boolean flag;
    int counter = 0;

    NumberGuessingGame(){
        flag = true;
    }

    public int getGeneratedNumber() {
        return generatedNumber;
    }

    public void setGeneratedNumber() {
        this.generatedNumber = (int) (Math.random()*10) + 1;
    }

    public int getGuessedNumber() {
        return guessedNumber;
    }

    public void setGuessedNumber(int guessedNumber) throws InputMismatchException {
        if (guessedNumber < 1 || guessedNumber > 10) {
            System.out.println("Invalid input! try again");
            this.flag = false;
        } else {
            this.guessedNumber = guessedNumber;
        }
    }

    public boolean playAgain(){
        Scanner in = new Scanner(System.in);
        System.out.println("Do you want to play again?\nType 'y' for Yes or 'n' for No: ");
        try {
            char again = in.next().charAt(0);
            if (again == 'n'){
                System.out.println("Thanks for playing the game!");
                return false;
            }else if (again!='y'){
                System.out.println("invalid input!");
                System.out.println("Thanks for playing the game!");
                return false;
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input!");
            return false;
        }
        System.out.println();
        return true;
    }

    public void start(){
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the number guessing game!\nyou must guess a number from 1 to 10.");
        while (true) {
            System.out.println("Please choose a level:\n\"1\" for Level 1: 3 trials\n\"2\" Level 2: 2 trials only\n\"3\" Level 3: 1 trial only");
            System.out.println();
            int choice = in.nextInt();
            if (choice<1 || choice>3){
                System.out.println("Wrong input! please try again.");
                continue;
            }
            switch (choice){
                case 1:
                    FirstLevel firstLevel = new FirstLevel();
                    firstLevel.playFirstLevel();
                    break;
                case 2:
                    SecondLevel secondLevel = new SecondLevel();
                    secondLevel.playSecondLevel();
                    break;
                case 3:
                    ThirdLevel thirdLevel = new ThirdLevel();
                    thirdLevel.PlayThirdLevel();
                    break;
            }
            if (!playAgain()){
                break;
            }
        }
    }
}