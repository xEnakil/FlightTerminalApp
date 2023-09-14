import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    public static void userRegister (ArrayList<User> users, Scanner input) {

        boolean loopState = true;
        while (loopState) {
        System.out.println("----------------------------------------");
        System.out.print("Enter username: ");
        String username = input.next();
        loopState = false;
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    loopState = true;
                    System.out.println("That name already exist. Try Again!");
                    break;
                }
            }
            if (!loopState) {
                System.out.print("Enter password: ");
                String password = input.next();
                System.out.print("Enter name: ");
                String name = input.next();
                System.out.print("Enter surname: ");
                String surname = input.next();

                User user = new User(username, password, name, surname);
                users.add(user);
                System.out.println("User has been created successfully!");
                System.out.println("----------------------------------------");
            }
        }
    }

    public static void userLogin (ArrayList<User> users, Scanner input) {

    }
}
