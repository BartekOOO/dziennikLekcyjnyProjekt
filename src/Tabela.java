import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Predicate;

public class Tabela implements Serializable {

    private int sterownik;
    String sciezka;
    private ArrayList<Rekord> rekordy;
    public Tabela(){
        this.sterownik = 1;
        this.rekordy = new ArrayList<Rekord>();
    }

    public Tabela(String sciezka){
        this.sciezka = sciezka;
        this.sterownik=1;
        this.rekordy = new ArrayList<Rekord>();
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sciezka));
            while(true){
                try{
                    Tabela tabelka = (Tabela) ois.readObject();

                    this.rekordy = tabelka.rekordy;
                    this.sterownik = tabelka.sterownik;
                }
                catch (EOFException e){
                    break;
                }
            }
            ois.close();
        }
        catch (Exception e){

        }
    }

    public void dodajRekord(Tabelowe obiekt){
        rekordy.add(new Rekord(sterownik,obiekt));
        sterownik++;
        zapiszTabele(sciezka);
    }

    public Object pobierzDanePoId(int id){
        for(Rekord rekord:rekordy){
            if(rekord.getId().equals(id)){
                return rekord;
            }
        }
        return null;
    }

    public Rekord pobierzRekordPoId(int id){
        for(Rekord rekord:rekordy){
            if(rekord.getId().equals(id)){
                return rekord;
            }
        }
        return null;
    }
    public void usunRekordPoId(int id){
        int indeks = 0;
        for(Rekord rekord:rekordy){
            if(rekord.getId().equals(id)){
                rekordy.remove(indeks);
                break;
            }
            indeks++;
        }
        zapiszTabele(sciezka);
    }

    public void nadpiszRekord(int id,Tabelowe obiekt){
        int indeks=0;
        for(Rekord rekord:rekordy){
            if(rekord.getId().equals(id)){
                rekordy.set(indeks,new Rekord(id,obiekt));
                break;
            }
            indeks++;
        }
        zapiszTabele(sciezka);
    }

    public ArrayList<Rekord> pobierzWszystkieRekordy(){
        ArrayList<Rekord> obiekty = new ArrayList<Rekord>();
        for(Rekord rekord:rekordy){
            obiekty.add(rekord);
        }
        return obiekty;
    }
    public void zapiszTabele(String sciezka){
        try {
            ObjectOutputStream zapis = new ObjectOutputStream(new FileOutputStream(sciezka));
            zapis.writeObject(this);
            zapis.close();
        } catch (IOException e) {
        }
    }
    public int getSterownik() {
        return sterownik-1;
    }
}
