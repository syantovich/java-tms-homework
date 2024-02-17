import java.util.Scanner;

public class CounterTens {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberFull = scanner.nextInt();

        int countTens = 0;
        boolean isShown = false;

        int tensThousands = numberFull / 10000;
        numberFull = numberFull % 10000;

        if(tensThousands != 0){
            isShown = true;
            countTens += 1;
            System.out.print(tensThousands + " десятков тысяч, ");
        }

        int thousands = numberFull / 1000;
        numberFull = numberFull % 1000;

        if(thousands != 0 || isShown){
            isShown = true;
            countTens += 1;
            System.out.print(thousands + " тысяч, ");
        }


        int hundreds = numberFull / 100;
        numberFull = numberFull % 100;

        if(hundreds != 0 || isShown){
            isShown = true;
            countTens += 1;
            System.out.print(hundreds + " сотен, ");
        }

        int tens = numberFull / 10;
        numberFull = numberFull % 10;

        if(tens != 0 || isShown){
            isShown = true;
            countTens += 1;
            System.out.print(tens + " десятков, ");
        }

        if(numberFull != 0 || isShown) {
            countTens += 1;
            System.out.print(numberFull + " единиц, ");
        }

        System.out.print("всего " + countTens + " знака");
    }
}
