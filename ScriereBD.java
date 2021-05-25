package Etapa_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ScriereBD {

    private static ScriereBD scriereDBInstance= null;

    private ScriereBD(){}

    public static ScriereBD getInstance(){
        if (scriereDBInstance == null){
            scriereDBInstance = new ScriereBD();
        }
        return scriereDBInstance;
    }



    public static void  ScriereUserBD(ArrayList<User> users) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");


            for (User aux : users){
                String sql="INSERT INTO users (nume, parola, sumaCont)"+"VALUES(?,?,?)";
                PreparedStatement statement=conection.prepareStatement(sql);
                statement.setString(1,aux.userName);
                statement.setString(2,aux.password);
                statement.setInt(3,aux.sumaCont);
                statement.executeUpdate();
            }




        } catch (Exception e) {
            System.out.println(e);
        }

    }






    public static void  ScriereBidBD(ArrayList<Bid> bids) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");


            for (Bid aux : bids){
                String sql="INSERT INTO bids (id_user, id_produs, valoare)"+"VALUES(?,?,?)";
                PreparedStatement statement=conection.prepareStatement(sql);
                statement.setInt(1,aux.idUser);
                statement.setInt(2,aux.idProdus);
                statement.setInt(3,aux.valoare);
                statement.executeUpdate();
            }




        } catch (Exception e) {
            System.out.println(e);
        }

    }



    public static void  ScriereLicitatiiBD(ArrayList<Licitatie> licitaties) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");


            for (Licitatie aux : licitaties){
                String sql="INSERT INTO licitatie (id_obiect, pretPornire)"+"VALUES(?,?)";
                PreparedStatement statement=conection.prepareStatement(sql);
                statement.setInt(1,aux.id_obiect);
                statement.setInt(2,aux.pretPornire);

                statement.executeUpdate();
            }




        } catch (Exception e) {
            System.out.println(e);
        }

    }




    public static void  ScriereObiecteBD(ArrayList<Obiect> obiects) {


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");


            for (Obiect aux : obiects){
              aux.Scriere_FisierBD(conection);
            }




        } catch (Exception e) {
            System.out.println(e);
        }

    }



}
