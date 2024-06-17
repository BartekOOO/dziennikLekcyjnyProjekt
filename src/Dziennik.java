import javax.management.StandardMBean;
import java.io.*;
import java.sql.Date;
import java.util.ArrayList;

public class Dziennik implements Serializable{
    private Tabela klasy;
    private Tabela uczniowie;
    private Tabela przedmioty;
    private Tabela nauczyciele;
    private Tabela oceny;

    public Dziennik(){
        klasy = new Tabela("Klasy.dat");
        uczniowie = new Tabela("Uczniowie.dat");
        przedmioty = new Tabela("Przedmioty.dat");
        nauczyciele = new Tabela("Nauczyciele.dat");
        oceny = new Tabela("Oceny.dat");
    }
    public void wstawOcene(int idUcznia,int idNauczyciela,int idPrzedmiotu, float wartosc){
        oceny.dodajRekord(new Ocena(idUcznia,idNauczyciela,idPrzedmiotu,wartosc));
    }
    public void usunOcene(int idOceny){
        oceny.usunRekordPoId(idOceny);
    }
    public  void dodajNauczyciela(String tytul,String imie,String nazwisko,Date dataUrodzenia){
        nauczyciele.dodajRekord(new Nauczyciel(tytul,imie,nazwisko,dataUrodzenia));
    }
    public void usunNauczyciela(int idNauczyciela){
        nauczyciele.usunRekordPoId(idNauczyciela);
    }
    public void dodajPrzedmiot(String nazwa){
        przedmioty.dodajRekord(new Przedmiot(nazwa));
    }
    public void usunPrzedmiot(int idPrzedmiotu){
        przedmioty.usunRekordPoId(idPrzedmiotu);
    }
    public Rekord pobierzPrzedmiot(int idPrzedmiotu){
        return przedmioty.pobierzRekordPoId(idPrzedmiotu);
    }
    public Rekord pobierzKlase(int idKlasy){
        return klasy.pobierzRekordPoId(idKlasy);
    }
    public void dodajUcznia(String imie, String nazwisko, java.util.Date dataUrodzenia){
        uczniowie.dodajRekord(new Uczen(imie,nazwisko,dataUrodzenia,0));
    }
    public void przypiszUczniaDoKlasy(int idUcznia,int idKlasy){
        Rekord rekord = (Rekord) uczniowie.pobierzDanePoId(idUcznia);
        Uczen uczen = (Uczen)rekord.getDane();
        uczen.setIdKlasy(idKlasy);
        uczniowie.nadpiszRekord(idUcznia,uczen);
    }
    public void usunUcznia(int idUcznia){
        uczniowie.usunRekordPoId(idUcznia);
    }
    public ArrayList<Ocena> pobierzOcenyUcznia(int idUcznia){
        ArrayList<Ocena> ocenyUcznia = new ArrayList<Ocena>();
        for(Rekord rekord:oceny.pobierzWszystkieRekordy()){
            Ocena ocena = (Ocena) rekord.getDane();
            if(ocena.getIdUcznia().equals(idUcznia)){
                ocenyUcznia.add(ocena);
            }
        }
        return ocenyUcznia;
    }
    public void dodajKlase(String nazwa){
        klasy.dodajRekord(new Klasa(nazwa));
    }
    public void usunKlase(int idKlasy){
        klasy.usunRekordPoId(idKlasy);
    }
    public Tabela getKlasy() {
        return klasy;
    }
    public Tabela getUczniowie() {
        return uczniowie;
    }
    public Tabela getPrzedmioty() {
        return przedmioty;
    }
    public Tabela getNauczyciele() {
        return nauczyciele;
    }
    public Tabela getOceny() {
        return oceny;
    }
}
