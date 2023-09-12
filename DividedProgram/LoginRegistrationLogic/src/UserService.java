import java.util.ArrayList;
import java.util.Scanner;

public class UserService {
    public static void userRegister (ArrayList<User> users, Scanner input) {

        System.out.print("Enter the username: ");
        String username = input.next();
        boolean loopState = true;
        while (loopState) {
            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("That name already exist. Try Again!");
                    return;
                }
            }
            System.out.print("Enter the password: ");
            String password = input.next();
            System.out.print("Enter the name: ");
            String name = input.next();
            System.out.print("Enter the surname: ");
            String surname = input.next();

            User user = new User(username, password, name, surname);
            users.add(user);
            loopState = false;
        }

    }

    public static void userLogin (ArrayList<User> users, Scanner input) {

    }
}
