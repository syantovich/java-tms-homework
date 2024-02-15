import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countRow = scanner.nextInt();

        int max = 2 * countRow - 1;

        for(int i = 1; i <= countRow; i++){
            for(int j = 0; j < max; j++){
                int middle = max / 2;

                if(middle - i < j && middle + i > j){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.println(' ');
        }
    }
}