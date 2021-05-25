package Etapa_1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class UpdateBD {


    private static UpdateBD updateDBInstance= null;

    private UpdateBD(){}

    public static UpdateBD getInstance(){
        if (updateDBInstance == null){
            updateDBInstance = new UpdateBD();
        }
        return updateDBInstance;
    }





    public static void  UpdatePasswordUserBD(String password, int id_user) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");



                String sql="UPDATE users SET parola = ? WHERE id = ? ";
                PreparedStatement statement=conection.prepareStatement(sql);
                statement.setString(1, password);
                statement.setInt(2, id_user+1);

                statement.executeUpdate(sql);





        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void  UpdatePretLicitatieBD(int pretnou, int id_lic) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");



            String sql="UPDATE licitatie SET pretPornire = ? WHERE id = ? ";
            PreparedStatement statement=conection.prepareStatement(sql);
            statement.setInt(1,pretnou);
            statement.setInt(2, id_lic+1);

            statement.executeUpdate(sql);


        } catch (Exception e) {
            System.out.println(e);
        }

    }



    public static void  UpdateSumaBidBD(int pretnou, int id_bid) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");



            String sql="UPDATE bids SET valoare = ? WHERE id = ? ";
            PreparedStatement statement=conection.prepareStatement(sql);
            statement.setInt(1,pretnou);
            statement.setInt(2, id_bid+1);

            statement.executeUpdate(sql);


        } catch (Exception e) {
            System.out.println(e);
        }

    }


    public static void  UpdateValObiectBD(int pretnou, int id_obiect) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/licitatii", "root", "");



            String sql="UPDATE obiecte SET valoare = ? WHERE id = ? ";
            PreparedStatement statement=conection.prepareStatement(sql);
            statement.setInt(1,pretnou);
            statement.setInt(2, id_obiect+1);

            statement.executeUpdate(sql);


        } catch (Exception e) {
            System.out.println(e);
        }


}

}





