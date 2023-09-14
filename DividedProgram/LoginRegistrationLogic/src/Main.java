import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<User> users = new ArrayList<>();
        User xenakil = new User("xenakil", "1234", "Elmin", "Mugalov");
        users.add(xenakil);
        while (true) {
            System.out.println("Main Menu:\n1. Login\n2. Register\n3. Exit");
            System.out.println("----------------------------------------");
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    UserService.userLogin(users, input);
                    break;
                case 2:
                    UserService.userRegister(users, input);
                    break;
                case 3:
                    System.out.println("Thanks for using our software <3");
                    System.out.println("----------------------------------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("There is no such choice.");
            }
        }
    }
}
