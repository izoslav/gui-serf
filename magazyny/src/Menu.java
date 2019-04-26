import model.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Menu {
    private ArrayList<Osoba> listaOsob = new ArrayList<>();
    private Osoba wybranaOsoba;
    private Magazyn magazyn = new Magazyn();

    public Menu() {
        // tworzenie osob
        Osoba o1 = new Osoba("Marek", "Iksiński", 91010101234L, "Prosta 4, 01-234 Ktosiowo", new Date(1991, 1, 1));
        Osoba o2 = new Osoba("Katarzyna", "Igrek", 88020201235L, "Krzywa 2, 01-534 Ktosiowo", new Date(1988, 2, 2));
        listaOsob.add(o1);
        listaOsob.add(o2);

        // domyślnie wybrana jest pierwsza osoba
        wybranaOsoba = o1;

        // tworzenie pomieszczen
        Pomieszczenie p1 = new Pomieszczenie(2, 3, 4, true);
        Pomieszczenie p2 = new Pomieszczenie(10, true);
        Pomieszczenie p3 = new Pomieszczenie(100, false);

        magazyn.dodajPomieszczenie(p1);
        magazyn.dodajPomieszczenie(p2);
        magazyn.dodajPomieszczenie(p3);

        // dodawanie przedmiotów
        Samochod o1s1 = new Samochod("Mazda", 6, 8, "rakietowe");
        Rower o1r1 = new Rower("Składak", 2, 5, "tarczowe", 2);
        Motocykl o1m1 = new Motocykl("Honda", 4, 2, true);

        o1.getListaPrzedmiotow().add(o1s1);
        o1.getListaPrzedmiotow().add(o1r1);
        o1.getListaPrzedmiotow().add(o1m1);

        Samochod o2s1 = new Samochod("Niemazda", 6, 8, "rakietowe");
        Rower o2r1 = new Rower("BMX", 2, 5, "tarczowe", 2);
        Motocykl o2m1 = new Motocykl("Honnieda", 4, 2, true);

        o2.getListaPrzedmiotow().add(o2s1);
        o2.getListaPrzedmiotow().add(o2r1);
        o2.getListaPrzedmiotow().add(o2m1);
    }

    // główna pętla programu
    public void uruchom() {
        Scanner skaner = new Scanner(System.in);

        while (true) {
            wyswietlMenuGlowne();

            switch (skaner.nextInt()) {
                case 0:
                    System.out.println("Do widzenia!");
                    System.exit(0);
                case 1:
                    wybierzOsobe();
                    break;
                case 2:
                    wypiszDaneIPomieszczenia();
                    break;
                case 3:
                    wypiszWolnePomieszczenia();
                    break;
                case 4:
                    wynajmijPomieszczenie();
                    break;
                case 5:
                    wlozPrzedmiot();
                    break;
                case 6:
                    wyjmijPrzedmiot();
                    break;
                case 7:
                    zapiszDoPliku();
                    break;
                default:
                    System.out.println("Wybrano niepoprawną opcję, ponów próbę!");
                    break;
            }
        }
    }

    private void zapiszDoPliku() {
        try {
            FileWriter fw = new FileWriter("stanMagazynu.txt");
            fw.write(magazyn.toString());
            fw.flush();

            System.out.println("Zapisano!");
        }
        catch (IOException e) {
            System.out.println("Błąd zapisu! " + e.getMessage());
        }
    }

    private void wyjmijPrzedmiot() {
        System.out.println("Wybierz pomieszczenie, z którego chcesz wyjąć przedmiot (naciśnij 0, aby wyjść):");

        int licznik = 0;
        int indeksy[] = new int[magazyn.getListaPomieszczen().size()];

        for (int i = 0; i < magazyn.getListaPomieszczen().size(); i++) {
            if (magazyn.getListaPomieszczen().get(i).getNajemca() == wybranaOsoba) {
                indeksy[licznik++] = i;
                System.out.println(licznik + ". " + magazyn.getListaPomieszczen().get(i));
            }
        }

        Scanner skaner = new Scanner(System.in);
        int idPomieszczenia = skaner.nextInt();

        if (idPomieszczenia == 0) {
            System.exit(0);
        }

        if (idPomieszczenia > 0 && idPomieszczenia <= licznik) {
            System.out.println("Wybierz przedmiot do wyjęcia (naciśnij 0, aby wyjść):");

            for (int i = 0; i < magazyn.getListaPomieszczen().get(indeksy[idPomieszczenia-1]).getListaPrzedmiotow().size(); i++) {
                System.out.println((i+1) + ". " + magazyn.getListaPomieszczen().get(indeksy[idPomieszczenia-1]).getListaPrzedmiotow().get(i));
            }

            int idPrzedmiotu = skaner.nextInt();

            if (idPrzedmiotu == 0 ) {
                System.exit(0);
            }

            if (idPrzedmiotu > 0 && idPrzedmiotu <= magazyn.getListaPomieszczen().get(indeksy[idPomieszczenia-1]).getListaPrzedmiotow().size()) {
                magazyn.getListaPomieszczen().get(indeksy[idPomieszczenia-1]).usunPrzedmiot(idPrzedmiotu - 1);
            }
            else {
                System.out.println("Wybrano niepoprawny przedmiot!");
            }
        }

        else {
            System.out.println("Wybrano niepoprawny identyfikator pomieszczenia!");
        }
    }

    private void wlozPrzedmiot() {
        System.out.println("Wybierz jeden z przedmiotów (naciśnij 0, aby wyjść):");
        wybranaOsoba.wypiszListePrzedmiotow();

        Scanner skaner = new Scanner(System.in);
        int idPrzedmiotu = skaner.nextInt();

        if (idPrzedmiotu == 0) {
            System.exit(0);
        }

        if (idPrzedmiotu > 0 && idPrzedmiotu <= wybranaOsoba.getListaPrzedmiotow().size()) {
            System.out.println("Wybrany przedmiot: " + wybranaOsoba.getListaPrzedmiotow().get(idPrzedmiotu-1));

            System.out.println("Wybierz pomieszczenie (naciśnij 0, aby wyjść):");

            int licznik = 0;
            int indeksy[] = new int[magazyn.getListaPomieszczen().size()];

            for (int i = 0; i < magazyn.getListaPomieszczen().size(); i++) {
                if (magazyn.getListaPomieszczen().get(i).getNajemca() == wybranaOsoba) {
                    indeksy[licznik++] = i;
                    System.out.println(licznik + ". " + magazyn.getListaPomieszczen().get(i));
                }
            }

            int idPomieszczenia = skaner.nextInt();

            if (idPomieszczenia == 0) {
                System.exit(0);
            }

            if (idPomieszczenia > 0 && idPomieszczenia <= licznik) {
                try {
                    magazyn.getListaPomieszczen().get(indeksy[idPomieszczenia-1]).dodajPrzedmiot(
                            wybranaOsoba.getListaPrzedmiotow().get(idPrzedmiotu - 1)
                    );
                }
                catch (TooManyThingsException e) {
                    System.out.println("Wybrany przedmiot nie zmieści się do pomieszczenia!");
                }
            }
        }
        else {
            System.out.println("Wybrano nieistniejący przedmiot!");
        }
    }

    private void wynajmijPomieszczenie() {
        for (int i = 0; i < magazyn.getListaPomieszczen().size(); i++) {
            System.out.println((i + 1) + ". " + magazyn.getListaPomieszczen().get(i));
        }

        System.out.println("Wybierz pomieszczenie do wynajmu (naciśnij 0, aby wyjść):");

        Scanner skaner = new Scanner(System.in);
        int id = skaner.nextInt();

        if (id == 0) {
            System.exit(0);
        }

        if (id > 0 && id <= magazyn.getListaPomieszczen().size()) {
            if (magazyn.getListaPomieszczen().get(id - 1).czyMozliwyWynajem()) {
                System.out.println("Na ile chcesz wynająć?");
                int dniNajmu = skaner.nextInt();

                magazyn.getListaPomieszczen().get(id - 1).wynajmij(wybranaOsoba, dniNajmu);
            }
            else {
                System.out.println("Nie można wynająć wybranego pomieszczenia, wybierz inne!");
                wynajmijPomieszczenie();
            }
        }
        else {
            System.out.println("Wybrano niepoprawny identyfikator pomieszczenia, ponów próbę!");
            wynajmijPomieszczenie();
        }
    }

    private void wypiszWolnePomieszczenia() {
        System.out.println("Wolne pomieszczenia (niewynajęte i aktywne):");

        for (int i = 0; i < magazyn.getListaPomieszczen().size(); i++) {
            if (magazyn.getListaPomieszczen().get(i).czyMozliwyWynajem()) {
                System.out.println((i + 1) + ". " + magazyn.getListaPomieszczen().get(i));
            }
        }
    }

    private void wypiszDaneIPomieszczenia() {
        System.out.println("Twoje dane: " + wybranaOsoba);

        System.out.println("Twoje pomieszczenia:");

        for (int i = 0; i < magazyn.getListaPomieszczen().size(); i++) {
            if (wybranaOsoba == magazyn.getListaPomieszczen().get(i).getNajemca()) {
                System.out.println(magazyn.getListaPomieszczen().get(i));
            }
        }
    }

    public void wybierzOsobe() {
        System.out.println("Wybierz osobę, aby się zalogować (naciśnij 0, aby wyjść):");

        for (int i = 0; i < listaOsob.size(); i++) {
            System.out.println((i + 1) + ". " + listaOsob.get(i));
        }

        Scanner skaner = new Scanner(System.in);
        int id = skaner.nextInt();

        if (id == 0) {
            System.exit(0);
        }

        if (id > 0 && id <= listaOsob.size()) {
            wybranaOsoba = listaOsob.get(id - 1);
        }
        else {
            System.out.println("Wybrano niepoprawne id, ponów próbę!");
            wybierzOsobe();
        }
    }

    public void wyswietlMenuGlowne() {
        final String opcje =
            "Zalogowano jako: " + wybranaOsoba.imieNazwisko() + "\n" +
            "0. Wyjdź z programu\n" +
            "1. Wybierz osobę\n" +
            "2. Wypisz swoje dane i wynajęte pomieszczenia\n" +
            "3. Wyświetl wolne pomieszczenia\n" +
            "4. Wynajmij pomieszczenie\n" +
            "5. Włóż nowe przedmioty\n" +
            "6. Wyjmij przedmioty\n" +
            "7. Zapisz aktualny stan magazynu do pliku" +
            "Wpisz jedną z opcji [0-8]: ";

        System.out.println(opcje);
    }
}
