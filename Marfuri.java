package Etapa_1;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
public class Marfuri extends Obiect {

    protected int idMarfa;
    protected int greutate;
    protected int volum;
    protected Date dataProductiei;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;


    public Marfuri(int valoare, int greutate, int volum, String descriere, String locatie) {

        super(valoare,"Marfuri");

        this.greutate=greutate;
        this.volum=volum;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idMarfa = counter;
    }


    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Marfa="+this.idMarfa);
        System.out.print(" Greutate="+this.greutate+"kg");
        System.out.print(" Volum="+this.volum+"metri cubi");
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();

    }

    public  void Scriere_Fisier(FileWriter out) throws IOException {
        out.write( this.tipObiect + ","  + this.valoare +","  + this.greutate +","  + this.volum  +","  + this.descriere +","+ this.locatie   +"\n");
        out.flush();

    }

    public  void Scriere_FisierBD(Connection conection) throws SQLException {


        String sql="INSERT INTO obiecte (tip_obiect, valoare,descriere,locatie,greutate,volum)"+"VALUES(?,?,?,?,?,?)";
        PreparedStatement statement=conection.prepareStatement(sql);
        statement.setString(1,this.tipObiect);
        statement.setInt(2,this.valoare);
        statement.setString(3,this.descriere);
        statement.setString(4,this.locatie);
        statement.setInt(5,this.greutate);
        statement.setInt(6,this.volum);
        statement.executeUpdate();
    }


}
