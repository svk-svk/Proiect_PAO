package Etapa_1;


import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CitireBD {


    private static CitireBD citireDBInstance = null;

    private CitireBD(){}

    public static CitireBD getInstance(){
        if (citireDBInstance == null){
            citireDBInstance = new CitireBD();
        }
        return citireDBInstance;
    }





    public  ArrayList<Licitatie>  CitireLicitatieBD() {

        ArrayList<Licitatie> licits = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");
            Statement stmt= conection.createStatement();

            ResultSet rs= stmt.executeQuery("SELECT * from licitatie");
            while (rs.next()) {
                Licitatie licitatie = new Licitatie(rs.getInt(2), rs.getInt(3));
                licits.add(licitatie);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return licits;
    }


    public  ArrayList<User>  CitireUsersBD() {

        ArrayList<User> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");
            Statement stmt= conection.createStatement();

            ResultSet rs= stmt.executeQuery("SELECT * from users");
            while (rs.next()) {
                User user = new User(rs.getString(2), rs.getString(3), rs.getInt(4));
                users.add(user);
            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return users;
    }


    public  ArrayList<Bid>  CitireBidsBD() {

        ArrayList<Bid> bids = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");
            Statement stmt= conection.createStatement();

            ResultSet rs= stmt.executeQuery("SELECT * from bids");
            while (rs.next()) {
                Bid bid = new Bid(rs.getInt(2), rs.getInt(3), rs.getInt(4));
                bids.add(bid);

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return bids;
    }



    public  ArrayList<Obiect>  CitireObiecteBD() {

        ArrayList<Obiect> obiects = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");
            Statement stmt= conection.createStatement();

            ResultSet rs= stmt.executeQuery("SELECT * from obiecte");
            while (rs.next()) {


                if(rs.getString(2).equals("Masina")){
                    Masini masini= new Masini(rs.getInt(3),rs.getInt(9),rs.getInt(10),rs.getInt(11), rs.getString(4),rs.getString(5));
                    obiects.add(masini);
                }else
                if(rs.getString(2).equals("Marfuri")){

                    Marfuri marfuri= new Marfuri(rs.getInt(3),rs.getInt(12),rs.getInt(13), rs.getString(4),rs.getString(5));
                    obiects.add(marfuri);
                }
                else      if(rs.getString(2).equals("Teren")){
                    Terenuri terenuri= new Terenuri(rs.getInt(3),rs.getInt(14), rs.getString(4),rs.getString(5));
                    obiects.add(terenuri);
                }
                else      if(rs.getString(2).equals("Casa")){
                    Case casa= new Case(rs.getInt(3), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getString(4),rs.getString(5));
                    obiects.add(casa);
                }

            }


        } catch (Exception e) {
            System.out.println(e);
        }
        return obiects;
    }




}
