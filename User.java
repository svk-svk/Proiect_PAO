
package Etapa_1;

public class User {

    protected int id;
    protected String userName;
    protected String password;
    protected int sumaCont;

    private static int counterUser = 0;


    public User(String userName, String password,int sumaCont) {
        this.userName = userName;
        this.password = password;
        this.sumaCont =  sumaCont;
        counterUser++;
        this.id = counterUser;
    }


    public void setUserName( String userName) {
        this.userName = userName;
    }

    public void setPassword( String password) {
        this.password = password;
    }

    public void setSumaCont( int sumaCont) {
        this.sumaCont =  sumaCont;
    }

    public String getNumeUser() {
        return userName;
    }

    public int getIdUser() {
        return id;
    }

    public int getSumaContUser() {
        return sumaCont;
    }




}
