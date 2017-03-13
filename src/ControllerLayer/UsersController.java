package ControllerLayer;

import AppLayer.User;
import AppLayer.Users;
import DataLayer.UserDB;
import UILayer.UsersView;

/**
 * Created by jonb on 12/03/17.
 */
public class UsersController
{

    private Users usersModel;
    private UsersView usersView;
    private UserDB usersDb;

    public UsersController(Users usersModel, UsersView usersView, UserDB usersDb)
    {
        this.usersModel = usersModel;
        this.usersView = usersView;
        this.usersDb = usersDb;
    }

    public void usersMenuController()
    {
        boolean exitApp = false;

        int choice = 0;

        while (!exitApp)
        {
            choice = usersView.usersMenu ();

            switch (choice)
            {
                case 1:
                    verifyUserCredentials ();
                    break;
                case 2:
                    usersView.showUsers (usersModel);
                    break;
                case 3:
                    exitApp = true;
                    break;
            }
        }

    }

    public void verifyUserCredentials()
    {
        User userObject = new User ();
        userObject = usersView.inputUserCredentials();

        boolean isValidLogin = usersDb.validLogin(userObject);

        if (isValidLogin)
        {
            usersModel.addUser(userObject);
        }

        usersView.usersValidationResult(isValidLogin);
    }
}