package model;

import java.util.ArrayList;
import java.util.Date;

public class Pomieszczenie {
    private static int licznik = 1;

    final private int identyfikator;
    final private int powierzchnia;
    private boolean dostepne;
    private ArrayList<Przedmiot> przedmioty;

    private Osoba najemca;
    private Date dataNajmu;
    private int dniNajmu;

    public Pomieszczenie(int powierzchnia) {
        this.identyfikator = generujId();
        this.powierzchnia = powierzchnia;
        this.dostepne = true;
        this.przedmioty = new ArrayList<>();
    }

    public Pomieszczenie(int dlugosc, int szerokosc, int wysokosc) {
        this(dlugosc * szerokosc * wysokosc);
    }

    private int generujId() {
        return licznik++;
    }
}
