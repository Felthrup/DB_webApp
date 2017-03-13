import AppLayer.Users;
import ControllerLayer.UsersController;
import DataLayer.UserDB;
import UILayer.UsersView;

public class Main {

    public static void main(String[] args) {

        Users usersModel = new Users();
        UsersView usersView = new UsersView();
        UserDB usersDb = new UserDB();
        UsersController usersController = new UsersController(usersModel, usersView, usersDb);

        usersController.usersMenuController ();
    }
}