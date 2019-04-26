package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Pomieszczenie implements Comparable<Pomieszczenie> {
    private static int licznik = 1;

    final private int identyfikator;
    final private int powierzchnia;
    private boolean dostepne;
    private ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();

    private Osoba najemca;
    private Date dataNajmu;
    private int dniNajmu;

    public Pomieszczenie(int powierzchnia, boolean dostepne) {
        this.identyfikator = generujId();
        this.powierzchnia = powierzchnia;
        this.dostepne = dostepne;
    }

    public Pomieszczenie(int dlugosc, int szerokosc, int wysokosc, boolean dostepne) {
        this(dlugosc * szerokosc * wysokosc, dostepne);
    }

    private int generujId() {
        return licznik++;
    }

    // gettery

    public int getIdentyfikator() {
        return identyfikator;
    }

    public Osoba getNajemca() {
        return najemca;
    }

    public ArrayList<Przedmiot> getListaPrzedmiotow() {
        return listaPrzedmiotow;
    }

    public void wynajmij(Osoba osoba, int dlugoscNajmu) {
        osoba.setDataPierwszegoNajmu(new Date());
        najemca = osoba;
        dniNajmu = dlugoscNajmu;
        dataNajmu = new Date();
    }

    // dodatkowe

    public boolean czyMozliwyWynajem() {
        return dostepne == true && najemca == null;
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

    public void usunPrzedmiot(int indeksPrzedmiotu) {
        listaPrzedmiotow.remove(indeksPrzedmiotu);
    }

    // Pomieszczenie p1 = new Pomieszczenie(3);
    // Pomieszczenie p2 = new Pomieszczenie(5);
    // p1.compareTo(p2);
    public int compareTo(Pomieszczenie pomieszczenie) {
        return Integer.compare(this.powierzchnia, pomieszczenie.powierzchnia);
    }

    @Override
    public String toString() {
        return "Pomieszczenie{" +
                "identyfikator=" + identyfikator +
                ", powierzchnia=" + powierzchnia +
                ", dostepne=" + dostepne +
                ", listaPrzedmiotow=" + listaPrzedmiotow +
                ", najemca=" + najemca +
                ", dataNajmu=" + dataNajmu +
                ", dniNajmu=" + dniNajmu +
                '}';
    }
}
