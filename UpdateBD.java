package Etapa_1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class UpdateBD {





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






}





