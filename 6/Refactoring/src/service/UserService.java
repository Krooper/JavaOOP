package service;

import model.User;
import source.UserDB;

import java.util.HashMap;

public class UserService {
    public void saveUser(User user, HashMap<Integer, User> userBase){
        UserDB.addUser(user);
    }
}
