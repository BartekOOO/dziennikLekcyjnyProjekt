import java.io.Serializable;

public class Rekord implements Serializable {
    private Integer id;
    private Tabelowe dane;

    public Rekord(Integer id,Tabelowe dane){
        this.id=id;
        this.dane=dane;
    }

    public Integer getId(){
        return id;
    }
    public Object getDane(){
        return dane;
    }
}
