import java.io.Serializable;
import java.util.ArrayList;

public class Klasa implements Serializable, Tabelowe{
    private String nazwaKlasy;

    public Klasa(String nazwaKlasy){
        this.nazwaKlasy=nazwaKlasy;
    }

    public String getNazwaKlasy(){
        return nazwaKlasy;
    }

}