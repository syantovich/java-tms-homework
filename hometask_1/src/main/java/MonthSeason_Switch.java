import java.util.Scanner;

public class MonthSeason_Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.next().toLowerCase();

        switch (month){
            case "october":
            case "november":
            case "september": {
                System.out.println("Autumn");
                break;
            }
            case "december":
            case "january":
            case "february": {
                System.out.println("Winter");
                break;
            }
            case "march":
            case "april":
            case "may": {
                System.out.println("Spring");
                break;
            }
            case "june":
            case "july":
            case "august": {
                System.out.println("Summer");
                break;
            }
        }
    }
}
