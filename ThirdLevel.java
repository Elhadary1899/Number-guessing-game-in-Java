import java.util.InputMismatchException;
import java.util.Scanner;

public class ThirdLevel extends NumberGuessingGame{
    public void PlayThirdLevel(){
        Scanner in = new Scanner(System.in);
        this.setGeneratedNumber();
        for (int i=1;i<=1;i++){
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
                System.out.println("Well played, you've guessed it correct!\n");
                break;
            }else{
                System.out.println("Wrong guess! you loose:( the number was " + super.getGeneratedNumber());
                System.out.println();
            }
        }

    }
}
