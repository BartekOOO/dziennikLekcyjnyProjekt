import java.io.Serializable;

public class Ocena implements Serializable, Tabelowe{
    private Integer idUcznia;
    private Integer idPrzedmiotu;
    private Integer idNauczyciela;
    private float wartosc;
    public Ocena(Integer idUcznia,Integer idNauczyciela,Integer idPrzedmiotu,float wartosc){
        this.idUcznia = idUcznia;
        this.wartosc = wartosc;
        this.idPrzedmiotu = idPrzedmiotu;
        this.idNauczyciela = idNauczyciela;
    }

    @Override
    public String toString(){
        String nazwaPrzedmiotu="";
        String nazwaNauczyciela="";

        try {
            PobieraniePoId szukajNauczyciela = new SzukajWNauczyciele();
            Nauczyciel nauczyciel = (Nauczyciel) szukajNauczyciela.szukajPoId(new Tabela("Nauczyciele.dat"),idNauczyciela).getDane();
            nazwaNauczyciela = nauczyciel.toString();
        }catch (RekordDoesNotExistsException e){
            nazwaNauczyciela=e.getMessage();
        }

        try {
            PobieraniePoId szukajPrzedmiot = new SzukajWPrzedmioty();
            Przedmiot przedmiot = (Przedmiot) szukajPrzedmiot.szukajPoId(new Tabela("Przedmioty.dat"), idPrzedmiotu).getDane();
            nazwaPrzedmiotu = przedmiot.getNazwa();
        }catch (Exception e){
            nazwaPrzedmiotu=e.getMessage();
        }

        return nazwaPrzedmiotu + " Ocena: " + wartosc + " Wystawione przez: " + nazwaNauczyciela;
    }
    public Integer getIdUcznia() {
        return idUcznia;
    }
}
