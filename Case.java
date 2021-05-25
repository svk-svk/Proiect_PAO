package Etapa_1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Case extends Obiect{

    protected int idCasa;
    protected int suprafataTotala;
    protected int suptafataUtila;
    protected int nrEtaje;
    protected String descriere;
    protected String locatie;

    private static int counter= 0;



    public Case(int valoare,int suprafataTotala, int suptafataUtila, int nrEtaje, String descriere, String locatie) {

        super(valoare,"Casa");

        this.suprafataTotala=suprafataTotala;
        this.suptafataUtila=suptafataUtila;
        this.nrEtaje=nrEtaje;
        this.descriere=descriere;
        this.locatie=locatie;
        counter++;
        this.idCasa = counter;

    }


    public void AfisareDate(){

        System.out.println("Tip Obiect "+this.tipObiect);
        System.out.print("ID Casa="+this.idCasa);
        System.out.print(" Suprafata Totala="+this.suprafataTotala+"metri patrati");
        System.out.print(" Suprafata Utila="+this.suptafataUtila+"metri patrati");
        System.out.print(" Nr de etaje="+this.nrEtaje);
        System.out.print(" Descriere="+this.descriere);
        System.out.println(" Locatie="+this.locatie);
        System.out.println();


    }

    public  void Scriere_Fisier(FileWriter out) throws IOException {
        out.write( this.tipObiect + ","  + this.valoare +","  + this.suprafataTotala +","  + this.suptafataUtila +","  + this.nrEtaje +","  + this.descriere +","+ this.locatie   +"\n");
        out.flush();


    }


    public  void Scriere_FisierBD(Connection conection) throws SQLException {


        String sql="INSERT INTO obiecte (tip_obiect, valoare,descriere,locatie,suprafataTotala,suprafata_utila,nrEtaje)"+"VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement=conection.prepareStatement(sql);
        statement.setString(1,this.tipObiect);
        statement.setInt(2,this.valoare);
        statement.setString(3,this.descriere);
        statement.setString(4,this.locatie);
        statement.setInt(5,this.suprafataTotala);
        statement.setInt(6,this.suptafataUtila);
        statement.setInt(7,this.nrEtaje);

        statement.executeUpdate();
    }



}