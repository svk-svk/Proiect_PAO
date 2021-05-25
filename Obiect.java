package Etapa_1;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class Obiect {

    protected int id;
    protected int valoare;
    protected String tipObiect;


    private static int counter= 0;

    public Obiect(int valoare, String tipObiect){

        this.valoare =  valoare;
        counter++;
        this.id = counter;
        this.tipObiect=tipObiect;
    }

    public void AfisareDate(){


System.out.println("aaaa");

    }



    public void setValoareObiect(int valoare) {
        this.valoare =  valoare;
    }

    public int getIdObiect() {
        return id;
    }

    public String getTipObiect(){
        return this.tipObiect;
    }

    public int getValoareObiect() {
        return valoare;
    }


    public void Scriere_Fisier(FileWriter out) throws IOException {
    }

    public  void Scriere_FisierBD(Connection conection) throws SQLException {

    }
}
