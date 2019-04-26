package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Pomieszczenie implements Comparable<Pomieszczenie> {
    private static int licznik = 1;

    final private int identyfikator;
    final private int powierzchnia;
    private boolean dostepne;
    private ArrayList<Przedmiot> listaPrzedmiotow;

    private Osoba najemca;
    private Date dataNajmu;
    private int dniNajmu;

    public Pomieszczenie(int powierzchnia) {
        this.identyfikator = generujId();
        this.powierzchnia = powierzchnia;
        this.dostepne = true;
        this.listaPrzedmiotow = new ArrayList<>();
    }

    public Pomieszczenie(int dlugosc, int szerokosc, int wysokosc) {
        this(dlugosc * szerokosc * wysokosc);
    }

    private int generujId() {
        return licznik++;
    }

    // obsługa przedmiotów

    private boolean czySieZmiesci(Przedmiot nowyPrzedmiot) {
        int zajmowanaPowierzchnia = 0;

        for (int i = 0; i < listaPrzedmiotow.size(); ++i) {
            zajmowanaPowierzchnia += listaPrzedmiotow.get(i).getRozmiar();
        }

        return (zajmowanaPowierzchnia + nowyPrzedmiot.getRozmiar()) <= powierzchnia;
    }

    public void dodajPrzedmiot(Przedmiot przedmiot) throws TooManyThingsException {
        if (!czySieZmiesci(przedmiot)) {
            throw new TooManyThingsException();
        }

        listaPrzedmiotow.add(przedmiot);

        // https://howtodoinjava.com/sort/collections-sort/
        Collections.sort(listaPrzedmiotow);
    }

    // Pomieszczenie p1 = new Pomieszczenie(3);
    // Pomieszczenie p2 = new Pomieszczenie(5);
    // p1.compareTo(p2);
    public int compareTo(Pomieszczenie pomieszczenie) {
        return Integer.compare(this.powierzchnia, pomieszczenie.powierzchnia);
    }
}
