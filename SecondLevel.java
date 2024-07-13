import java.util.InputMismatchException;
import java.util.Scanner;

public class SecondLevel extends NumberGuessingGame{
    public void playSecondLevel(){
        Scanner in = new Scanner(System.in);
        this.setGeneratedNumber();
        for (int i=1;i<=2;i++){
            flag = true;
            System.out.println("What's your guess? ");
            try {
                this.setGuessedNumber(in.nextInt());
            }catch (InputMismatchException e){
                System.out.println("Invalid input, please try again");
                this.flag = false;
            }
            if (!this.flag){
                i--;
                continue;
            }
            counter++;
            if (this.getGuessedNumber()==this.getGeneratedNumber()) {
                System.out.println("Well played, you've guessed it correct!");
                if (counter==1){
                    System.out.println("You made it from " + counter + " trial\n");
                }else {
                    System.out.println("You made it from " + counter + " trials\n");
                }
                break;
            }else {
                if (counter < 2) {
                    if (this.getGuessedNumber() < this.getGeneratedNumber()){
                        System.out.println("Wrong guess! try guessing a higher number.");
                    }else {
                        System.out.println("Wrong guess! try guessing a lower number.");
                    }
                }else if (counter==2){
                    System.out.println("Wrong guess! you loose:( the number was " + this.getGeneratedNumber());
                    System.out.println();
                }
            }
        }
    }
}
