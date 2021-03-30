package Etapa_1;

public class Obiect {

    protected int id;
    protected int valoare;



    private static int counter= 0;

    public Obiect(int valoare){

        this.valoare =  valoare;
        counter++;
        this.id = counter;
    }


    public void setValoareObiect(int valoare) {
        this.valoare =  valoare;
    }

    public int getIdObiect() {
        return id;
    }

    public int getValoareObiect() {
        return valoare;
    }
}
