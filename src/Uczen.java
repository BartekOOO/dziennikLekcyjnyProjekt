import java.util.ArrayList;
import java.util.Date;

public class Uczen extends Osoba implements Tabelowe{
    private Integer idKlasy;
    public Uczen(String imie, String nazwisko, Date dataUrodzenia, Integer idKlasy){
        super(imie,nazwisko,dataUrodzenia);
        this.idKlasy=idKlasy;
    }
    public void setIdKlasy(int idKlasy){
        this.idKlasy=idKlasy;
    }

    public String pobierzKlaseUcznia(){
        try {
            if (idKlasy.equals(0)) {
                return "Uczeń bez klasy";
            }
            PobieraniePoId klasa = new SzukajWKlasy();
            Rekord rekotdKlasy = klasa.szukajPoId(new Tabela("Klasy.dat"), idKlasy);
            Klasa klasa1 = (Klasa) rekotdKlasy.getDane();
            String klasaUcznia = klasa1.getNazwaKlasy();
            return klasaUcznia;
        }catch (RekordDoesNotExistsException e){
            return e.getMessage();
        }
    }

    @Override
    public String toString(){
        return imie+" "+nazwisko+", Klasa: "+pobierzKlaseUcznia();
    }


}
