package controller;

import model.User;
import service.UserService;
import source.UserDB;

import java.util.HashMap;

public class UserController {
    private static final UserService service = new UserService();

    public static void saveUser(User user, HashMap<Integer, User> userData){
        service.saveUser(user, userData);
    }


}
