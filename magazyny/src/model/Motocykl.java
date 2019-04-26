package model;

public class Motocykl extends Przedmiot {
    final private int pojemnoscSilnika;
    final private boolean czyHomologowany;

    public Motocykl(String nazwa, int rozmiar, int pojemnoscSilnika, boolean czyHomologowany) {
        super(nazwa, rozmiar);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.czyHomologowany = czyHomologowany;
    }

    public Motocykl(String nazwa, int dlugosc, int szerokosc, int wysokosc, int pojemnoscSilnika, boolean czyHomologowany) {
        this(nazwa, dlugosc * szerokosc * wysokosc, pojemnoscSilnika, czyHomologowany);
    }

    @Override
    public String toString() {
        return "Motocykl{" +
                "pojemnoscSilnika=" + pojemnoscSilnika +
                ", czyHomologowany=" + czyHomologowany +
                '}';
    }
}
