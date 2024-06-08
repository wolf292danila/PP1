package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    private final static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        userService.createUsersTable();

        userService.saveUser("Мария", " Петрова", (byte) 66);
        userService.saveUser("Петр", " Петров", (byte) 57);
        userService.saveUser("Влад", " Владислав", (byte) 52);
        userService.saveUser("Елена", "Смирнова", (byte) 68);

        userService.removeUserById(1);
        List<User> allUsers = userService.getAllUsers();
        userService.cleanUsersTable();
//        userService.dropUsersTable();
    }
}
