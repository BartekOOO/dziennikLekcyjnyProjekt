import java.io.Serializable;

public class Przedmiot implements Serializable, Tabelowe {
    private String nazwa;
    public Przedmiot(String nazwa){
        this.nazwa = nazwa;
    }
    public String getNazwa(){
        return nazwa;
    }
}
