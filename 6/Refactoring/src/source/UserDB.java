package source;

import model.User;

import java.util.Dictionary;
import java.util.HashMap;

public class UserDB {
    public static HashMap<Integer, User> users;
    private static Integer id;

    public static HashMap<Integer, User> getUsers() {
        return users;
    }

    public static HashMap<Integer, User> initialize() {
        users = new HashMap<Integer, User>();
        id = 0;
        return UserDB.users;
    }

    public static void addUser(User user) {
        UserDB.users.put(id, user);
        id++;
    }
}
