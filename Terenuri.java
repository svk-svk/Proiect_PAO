package Etapa_1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Terenuri extends Obiect{

    protected int idTeren;
    protected int suprafataMp;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;


    public Terenuri(int valoare,int suprafataMp, String descriere, String locatie) {

        super(valoare,"Teren");
        this.suprafataMp=suprafataMp;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idTeren = counter;

    }

    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Teren="+this.idTeren);
        System.out.print(" Suprafata Teren="+this.suprafataMp+" metri patrati");
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();

    }

    public  void Scriere_Fisier(FileWriter out) throws IOException {
        out.write( this.tipObiect + ","  + this.valoare +","  + this.suprafataMp  +","  + this.descriere +","+ this.locatie   +"\n");
        out.flush();

    }

    public  void Scriere_FisierBD(Connection conection) throws SQLException {


        String sql="INSERT INTO obiecte (tip_obiect, valoare,descriere,locatie,suprafataMP)"+"VALUES(?,?,?,?,?)";
        PreparedStatement statement=conection.prepareStatement(sql);
        statement.setString(1,this.tipObiect);
        statement.setInt(2,this.valoare);
        statement.setString(3,this.descriere);
        statement.setString(4,this.locatie);
        statement.setInt(5,this.suprafataMp);

        statement.executeUpdate();
    }





}
