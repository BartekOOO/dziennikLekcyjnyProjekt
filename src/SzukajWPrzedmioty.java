public class SzukajWPrzedmioty implements PobieraniePoId{
    @Override
    public Rekord szukajPoId(Tabela tabela,Integer id){
        for(Rekord rekord:tabela.pobierzWszystkieRekordy()){
            if(rekord.getId().equals(id)){
                return rekord;
            }
        }
        throw new RekordDoesNotExistsException("[Przedmiot usunięty]");
    }
}
