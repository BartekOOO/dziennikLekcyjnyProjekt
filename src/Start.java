import java.sql.Date;

public class Start {


public static void zacznijZTestowymiDanymi(){
    Dziennik dziennik = new Dziennik();
    dziennik.dodajUcznia("Bartłomiej","Władimiruk",new Date(2003,8,16));
    dziennik.dodajUcznia("Anna", "Nowak", new Date(2004, 1, 12));
    dziennik.dodajUcznia("Michał", "Kowalski", new Date(2003, 10, 23));
    dziennik.dodajUcznia("Julia", "Wiśniewska", new Date(2004, 3, 7));
    dziennik.dodajUcznia("Szymon", "Zieliński", new Date(2003, 5, 30));
    dziennik.dodajUcznia("Katarzyna", "Kamińska", new Date(2004, 6, 15));
    dziennik.dodajUcznia("Jan", "Lewandowski", new Date(2003, 11, 19));
    dziennik.dodajUcznia("Aleksandra", "Szymańska", new Date(2004, 4, 3));
    dziennik.dodajUcznia("Mateusz", "Wójcik", new Date(2003, 9, 14));
    dziennik.dodajUcznia("Zofia", "Kozłowska", new Date(2004, 12, 28));

    dziennik.dodajNauczyciela("Mgr","Adrian","Bednarek",new Date(1970,5,20));
    dziennik.dodajNauczyciela("Dr", "Joanna", "Kowalska", new Date(1975, 3, 14));
    dziennik.dodajNauczyciela("Mgr", "Michał", "Nowak", new Date(1980, 7, 22));

    dziennik.dodajKlase("1ftg");
    dziennik.dodajKlase("1fhg");

    dziennik.przypiszUczniaDoKlasy(1,1);
    dziennik.przypiszUczniaDoKlasy(2,1);
    dziennik.przypiszUczniaDoKlasy(3,1);
    dziennik.przypiszUczniaDoKlasy(4,1);
    dziennik.przypiszUczniaDoKlasy(5,1);

    dziennik.przypiszUczniaDoKlasy(6,2);
    dziennik.przypiszUczniaDoKlasy(7,2);
    dziennik.przypiszUczniaDoKlasy(8,2);
    dziennik.przypiszUczniaDoKlasy(9,2);
    dziennik.przypiszUczniaDoKlasy(10,2);


    dziennik.dodajPrzedmiot("Matematyka");
    dziennik.dodajPrzedmiot("Polski");
    dziennik.dodajPrzedmiot("Angielski");
    dziennik.dodajPrzedmiot("Chemia");
    dziennik.dodajPrzedmiot("Fizyka");

    dziennik.wstawOcene(1,1,1,5);
    dziennik.wstawOcene(1,2,2,4);
    dziennik.wstawOcene(1,3,3,4);
    dziennik.wstawOcene(1,1,1,4);

    // Dodawanie uczniów
    dziennik.dodajUcznia("Marcin", "Nowicki", new Date(2003, 7, 21));
    dziennik.dodajUcznia("Patrycja", "Piotrowska", new Date(2004, 2, 10));
    dziennik.dodajUcznia("Tomasz", "Pawlak", new Date(2003, 11, 5));
    dziennik.dodajUcznia("Magdalena", "Krawczyk", new Date(2004, 8, 19));
    dziennik.dodajUcznia("Filip", "Dąbrowski", new Date(2003, 3, 22));
    dziennik.dodajUcznia("Alicja", "Wojciechowska", new Date(2004, 9, 30));
    dziennik.dodajUcznia("Kacper", "Kwiatkowski", new Date(2003, 6, 15));
    dziennik.dodajUcznia("Natalia", "Majewska", new Date(2004, 5, 27));
    dziennik.dodajUcznia("Paweł", "Sikorski", new Date(2003, 12, 13));
    dziennik.dodajUcznia("Olga", "Ostrowska", new Date(2004, 4, 18));

// Dodawanie nauczycieli
    dziennik.dodajNauczyciela("Dr", "Piotr", "Zieliński", new Date(1965, 9, 8));
    dziennik.dodajNauczyciela("Mgr", "Anna", "Wiśniewska", new Date(1985, 6, 2));
    dziennik.dodajNauczyciela("Prof", "Jan", "Jankowski", new Date(1950, 11, 25));

// Dodawanie klas
    dziennik.dodajKlase("2a");
    dziennik.dodajKlase("2b");
    dziennik.dodajKlase("3a");

// Przypisywanie uczniów do klas
    dziennik.przypiszUczniaDoKlasy(11, 3);
    dziennik.przypiszUczniaDoKlasy(12, 3);
    dziennik.przypiszUczniaDoKlasy(13, 3);
    dziennik.przypiszUczniaDoKlasy(14, 3);
    dziennik.przypiszUczniaDoKlasy(15, 3);

    dziennik.przypiszUczniaDoKlasy(16, 4);
    dziennik.przypiszUczniaDoKlasy(17, 4);
    dziennik.przypiszUczniaDoKlasy(18, 4);
    dziennik.przypiszUczniaDoKlasy(19, 4);
    dziennik.przypiszUczniaDoKlasy(20, 4);

// Dodawanie nowych przedmiotów
    dziennik.dodajPrzedmiot("Historia");
    dziennik.dodajPrzedmiot("Geografia");
    dziennik.dodajPrzedmiot("Biologia");

// Wstawianie ocen
    dziennik.wstawOcene(1, 4, 1, 3);  // Bartłomiej Władimiruk, Historia, Ocena 3
    dziennik.wstawOcene(2, 1, 2, 4);  // Anna Nowak, Geografia, Ocena 4
    dziennik.wstawOcene(3, 2, 3, 5);  // Michał Kowalski, Biologia, Ocena 5
    dziennik.wstawOcene(4, 3, 1, 4);  // Julia Wiśniewska, Matematyka, Ocena 4
    dziennik.wstawOcene(5, 4, 2, 5);  // Szymon Zieliński, Polski, Ocena 5
    dziennik.wstawOcene(6, 1, 3, 3);  // Katarzyna Kamińska, Angielski, Ocena 3
    dziennik.wstawOcene(7, 2, 4, 4); // Jan Lewandowski, Chemia, Ocena 4
    dziennik.wstawOcene(8, 3, 5, 5); // Aleksandra Szymańska, Fizyka, Ocena 5
    dziennik.wstawOcene(9, 4, 4, 3); // Mateusz Wójcik, Historia, Ocena 3
    dziennik.wstawOcene(10, 1, 5, 4); // Zofia Kozłowska, Geografia, Ocena 4
    dziennik.wstawOcene(11, 2, 6, 5); // Marcin Nowicki, Biologia, Ocena 5
    dziennik.wstawOcene(12, 3, 7, 4); // Patrycja Piotrowska, Matematyka, Ocena 4
    dziennik.wstawOcene(13, 4, 8, 3); // Tomasz Pawlak, Polski, Ocena 3
    dziennik.wstawOcene(14, 1, 9, 4); // Magdalena Krawczyk, Angielski, Ocena 4
    dziennik.wstawOcene(15, 2, 10, 5); // Filip Dąbrowski, Chemia, Ocena 5
    dziennik.wstawOcene(16, 3, 11, 3); // Alicja Wojciechowska, Fizyka, Ocena 3
    dziennik.wstawOcene(17, 4, 12, 4); // Kacper Kwiatkowski, Historia, Ocena 4


    // Wstawianie ocen dla uczniów
    dziennik.wstawOcene(1, 1, 1, 5); // Bartłomiej Władimiruk, Matematyka, Ocena 5
    dziennik.wstawOcene(1, 2, 2, 4); // Bartłomiej Władimiruk, Polski, Ocena 4
    dziennik.wstawOcene(1, 3, 3, 3); // Bartłomiej Władimiruk, Angielski, Ocena 3

    dziennik.wstawOcene(2, 4, 1, 4); // Anna Nowak, Matematyka, Ocena 4
    dziennik.wstawOcene(2, 1, 2, 5); // Anna Nowak, Polski, Ocena 5
    dziennik.wstawOcene(2, 2, 3, 3); // Anna Nowak, Angielski, Ocena 3

    dziennik.wstawOcene(3, 3, 1, 3); // Michał Kowalski, Matematyka, Ocena 3
    dziennik.wstawOcene(3, 4, 2, 4); // Michał Kowalski, Polski, Ocena 4
    dziennik.wstawOcene(3, 1, 3, 5); // Michał Kowalski, Angielski, Ocena 5

    dziennik.wstawOcene(4, 2, 1, 4); // Julia Wiśniewska, Matematyka, Ocena 4
    dziennik.wstawOcene(4, 3, 2, 4); // Julia Wiśniewska, Polski, Ocena 4
    dziennik.wstawOcene(4, 4, 3, 5); // Julia Wiśniewska, Angielski, Ocena 5

    dziennik.wstawOcene(5, 1, 1, 3); // Szymon Zieliński, Matematyka, Ocena 3
    dziennik.wstawOcene(5, 2, 2, 3); // Szymon Zieliński, Polski, Ocena 3
    dziennik.wstawOcene(5, 3, 3, 4); // Szymon Zieliński, Angielski, Ocena 4

    dziennik.wstawOcene(6, 4, 1, 5); // Katarzyna Kamińska, Matematyka, Ocena 5
    dziennik.wstawOcene(6, 1, 2, 4); // Katarzyna Kamińska, Polski, Ocena 4
    dziennik.wstawOcene(6, 2, 3, 4); // Katarzyna Kamińska, Angielski, Ocena 4

    dziennik.wstawOcene(7, 3, 1, 3); // Jan Lewandowski, Matematyka, Ocena 3
    dziennik.wstawOcene(7, 4, 2, 5); // Jan Lewandowski, Polski, Ocena 5
    dziennik.wstawOcene(7, 1, 3, 4); // Jan Lewandowski, Angielski, Ocena 4

    dziennik.wstawOcene(8, 2, 1, 4); // Aleksandra Szymańska, Matematyka, Ocena 4
    dziennik.wstawOcene(8, 3, 2, 4); // Aleksandra Szymańska, Polski, Ocena 4
    dziennik.wstawOcene(8, 4, 3, 5); // Aleksandra Szymańska, Angielski, Ocena 5

    dziennik.wstawOcene(9, 1, 1, 5); // Mateusz Wójcik, Matematyka, Ocena 5
    dziennik.wstawOcene(9, 2, 2, 3); // Mateusz Wójcik, Polski, Ocena 3
    dziennik.wstawOcene(9, 3, 3, 4); // Mateusz Wójcik, Angielski, Ocena 4

    dziennik.wstawOcene(10, 4, 1, 3); // Zofia Kozłowska, Matematyka, Ocena 3
    dziennik.wstawOcene(10, 1, 2, 5); // Zofia Kozłowska, Polski, Ocena 5
    dziennik.wstawOcene(10, 2, 3, 4); // Zofia Kozłowska, Angielski, Ocena 4

    dziennik.wstawOcene(11, 3, 1, 4); // Marcin Nowicki, Matematyka, Ocena 4
    dziennik.wstawOcene(11, 4, 2, 5); // Marcin Nowicki, Polski, Ocena 5
    dziennik.wstawOcene(11, 1, 3, 3); // Marcin Nowicki, Angielski, Ocena 3

    dziennik.wstawOcene(12, 2, 1, 5); // Patrycja Piotrowska, Matematyka, Ocena 5
    dziennik.wstawOcene(12, 3, 2, 4); // Patrycja Piotrowska, Polski, Ocena 4
    dziennik.wstawOcene(12, 4, 3, 3); // Patrycja Piotrowska, Angielski, Ocena 3

    dziennik.wstawOcene(13, 1, 1, 4); // Tomasz Pawlak, Matematyka, Ocena 4
    dziennik.wstawOcene(13, 2, 2, 4); // Tomasz Pawlak, Polski, Ocena 4
    dziennik.wstawOcene(13, 3, 3, 5); // Tomasz Pawlak, Angielski, Ocena 5

    dziennik.wstawOcene(14, 4, 1, 3); // Magdalena Krawczyk, Matematyka, Ocena 3
    dziennik.wstawOcene(14, 1, 2, 4); // Magdalena Krawczyk, Polski, Ocena 4
    dziennik.wstawOcene(14, 2, 3, 5); // Magdalena Krawczyk, Angielski, Ocena 5

    dziennik.wstawOcene(15, 3, 1, 5); // Filip Dąbrowski, Matematyka, Ocena 5
    dziennik.wstawOcene(15, 4, 2, 3); // Filip Dąbrowski, Polski, Ocena 3
    dziennik.wstawOcene(15, 1, 3, 4); // Filip Dąbrowski, Angielski, Ocena 4

    dziennik.wstawOcene(16, 2, 1, 4); // Alicja Wojciechowska, Matematyka, Ocena 4
    dziennik.wstawOcene(16, 3, 2, 4); // Alicja Wojciechowska, Polski, Ocena 4
    dziennik.wstawOcene(16, 4, 3, 5); // Alicja Wojciechowska, Angielski, Ocena 5

    dziennik.wstawOcene(17, 1, 1, 5); // Kacper Kwiatkowski, Matematyka, Ocena 5
    dziennik.wstawOcene(17, 2, 2, 4); // Kacper Kwiatkowski, Polski, Ocena 4
    dziennik.wstawOcene(17, 3, 3, 3); // Kacper Kwiatkowski, Angielski, Ocena 3

    dziennik.wstawOcene(18, 4, 1, 4); // Natalia Majewska, Matematyka, Ocena 4
    dziennik.wstawOcene(18, 1, 2, 5); // Natalia Majewska, Polski, Ocena 5
    dziennik.wstawOcene(18, 2, 3, 3); // Natalia Majewska, Angielski, Ocena 3

    dziennik.wstawOcene(19, 3, 1, 3); // Paweł Sikorski, Matematyka, Ocena 3
    dziennik.wstawOcene(19, 4, 2, 5); // Paweł Sikorski, Polski, Ocena 5
    dziennik.wstawOcene(19, 1, 3, 4); // Paweł Sikorski, Angielski, Ocena 4

    dziennik.wstawOcene(20, 2, 1, 4); // Olga Ostrowska, Matematyka, Ocena 4
    dziennik.wstawOcene(20, 3, 2, 4); // Olga Ostrowska, Polski, Ocena 4
    dziennik.wstawOcene(20, 4, 3, 5); // Olga Ostrowska, Angielski, Ocena 5



}




}
