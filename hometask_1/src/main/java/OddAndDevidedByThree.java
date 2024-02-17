import java.util.Scanner;

public class OddAndDevidedByThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        for(int i = 0; i <= number; i+=1){
            if(i % 3 == 0 && i % 2 == 1) {
                System.out.println(i);
            }
        }
    }
}
