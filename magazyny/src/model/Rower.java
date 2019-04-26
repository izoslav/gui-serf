package model;

public class Rower extends Przedmiot {
    final private int liczbaPrzerzutek;
    final private String typHamulcow;
    final private int liczbaAmortyzatorow;

    public Rower(String nazwa, int rozmiar, int liczbaPrzerzutek, String typHamulcow, int liczbaAmortyzatorow) {
        super(nazwa, rozmiar);
        this.liczbaPrzerzutek = liczbaPrzerzutek;
        this.typHamulcow = typHamulcow;
        this.liczbaAmortyzatorow = liczbaAmortyzatorow;
    }

    public Rower(String nazwa, int dlugosc, int szerokosc, int wysokosc, int liczbaPrzerzutek, String typHamulcow, int liczbaAmortyzatorow) {
        this(nazwa, dlugosc * szerokosc * wysokosc, liczbaPrzerzutek, typHamulcow, liczbaAmortyzatorow);
    }

    public boolean czyAmortyzowany() {
        return liczbaAmortyzatorow > 0;
    }

    @Override
    public String toString() {
        return "Rower{" +
                "liczbaPrzerzutek=" + liczbaPrzerzutek +
                ", typHamulcow='" + typHamulcow + '\'' +
                ", liczbaAmortyzatorow=" + liczbaAmortyzatorow +
                ", czyAmortyzowany=" + czyAmortyzowany() +
                '}';
    }
}
