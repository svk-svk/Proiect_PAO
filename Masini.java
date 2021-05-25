package Etapa_1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Masini extends Obiect {
    protected int idMasina;
    protected int capacitateCilindrica;
    protected int anFabricatie;
    protected int kmParcursi;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;



    public Masini(int valoare, int capacitateCilindrica, int anFabricatie, int kmParcursi, String descriere, String locatie) {
        super(valoare,"Masina");
        this.capacitateCilindrica = capacitateCilindrica;
        this.anFabricatie=anFabricatie;
        this.kmParcursi=kmParcursi;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idMasina = counter;

    }




    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Masina= "+this.idMasina);
        System.out.print(" Capacitate Cilindrica="+this.capacitateCilindrica);
        System.out.print(" An de fabricatie="+this.anFabricatie);
        System.out.print(" Km Parcursi="+this.kmParcursi);
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();


    }

    public  void Scriere_Fisier(FileWriter out) throws IOException {
        out.write( this.tipObiect + ","  + this.valoare +","  + this.capacitateCilindrica +","  + this.anFabricatie +","  + this.kmParcursi +","  + this.descriere +","+ this.locatie   +"\n");
        out.flush();


    }


    public  void Scriere_FisierBD(Connection conection) throws SQLException {


        String sql="INSERT INTO obiecte (tip_obiect, valoare,descriere,locatie,capacitateCilindrica,anFabricatie,kmParcursi)"+"VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement=conection.prepareStatement(sql);
        statement.setString(1,this.tipObiect);
        statement.setInt(2,this.valoare);
        statement.setString(3,this.descriere);
        statement.setString(4,this.locatie);
        statement.setInt(5,this.capacitateCilindrica);
        statement.setInt(6,this.anFabricatie);
        statement.setInt(7,this.kmParcursi);
        statement.executeUpdate();
    }




}
