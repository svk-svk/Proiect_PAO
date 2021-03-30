package Etapa_1;

import java.util.ArrayList;
import java.util.Scanner;

public class Interogare {

    ArrayList<User> users = new ArrayList<>();


    void addUser(Scanner cin){
        System.out.println("User Name");
        String userName = cin.next();
        System.out.println("Parola");
        String password = cin.next();
        System.out.println("Suma cont");
        int sumaCont = Integer.parseInt(cin.next());
        User user = new User(userName, password, sumaCont);
        users.add(user);
    }


    User cautUser(int MedicId){
        for (User user : users) {

            return user;
        }
        return null;
    }


}







