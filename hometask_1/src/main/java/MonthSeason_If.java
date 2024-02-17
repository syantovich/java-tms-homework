import java.util.Scanner;

public class MonthSeason_If {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.next().toLowerCase();

        if(month.equals("october") || month.equals("november") || month.equals("september")){
            System.out.println("Autumn");
            return;
        }

        if(month.equals("december") || month.equals("january") || month.equals("february")){
            System.out.println("Winter");
            return;
        }

        if(month.equals("march") || month.equals("april") || month.equals("may")){
            System.out.println("Spring");
            return;
        }

        if(month.equals("june") || month.equals("july") || month.equals("august")){
            System.out.println("Summer");
            return;
        }
    }
}
