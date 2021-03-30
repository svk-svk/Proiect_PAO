package Etapa_1;

public class Bid {

    protected int id;
    protected int idUser;
    protected int idProdus;
    protected int valoare;

    private static int counterBid = 0;

    public Bid(int idUser, int idProdus, int valoare) {
        this.idUser = idUser;
        this.idProdus =idProdus;
        this.valoare =valoare;
        counterBid++;
        this.id = counterBid;
    }


    public void setIdUser( int idUser) {
        this.idUser = idUser;
    }

    public void setIdProdus( int idProdus) {
        this.idProdus = idProdus;
    }
    public void setValoare(int valoare) {
        this.valoare =  valoare;
    }

    public int getIdBid() {
        return id;
    }

    public int getValoareBid() {
        return valoare;
    }

}
