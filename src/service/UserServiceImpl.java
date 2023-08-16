package service;

import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public interface UserServiceImpl {
    void registerUser (Scanner input, ArrayList<User> users);
    void loginUser (Scanner input, ArrayList<User> users, User currentUser);
}
