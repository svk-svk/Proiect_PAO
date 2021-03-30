package Etapa_1;
import java.util.Date;
public class Marfiri extends Obiect {

    protected int numarLot;
    protected Date dataExpirare;

    public Marfiri(int valoare, int numarLot, Date dataExpirare) {

        super(valoare);
        this.numarLot=numarLot;
        this.dataExpirare=dataExpirare;

    }

    public void setNumarLot(int numarLot){

        this.numarLot=numarLot;

    }

    public int getNumarLot()
    {
        return  numarLot;
    }



    public void setDataExpirare(Date dataExpirare){

        this.dataExpirare=dataExpirare;

    }

    public Date getDataExpirare()
    {
        return  dataExpirare;
    }
}
