import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Task1 task1 = new Task1(10);

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();

        new Task2(length);

        int[] randomArr = task1.getRandomArr(100);

        int[] duplicateInfo = task1.getDuplicateItem(randomArr);

        System.out.println("Массив - " + Arrays.toString(randomArr));

        if(duplicateInfo[1]!=0){
            System.out.println("Повторяеться элемент " + duplicateInfo[0] + " - " + duplicateInfo[1] + " раз");
        }else {
            System.out.println("Duplicate element not found");
        }
    }
}
