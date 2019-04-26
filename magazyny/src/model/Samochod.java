package model;

public class Samochod extends Przedmiot {
    final private int pojemnoscSilnika;
    final private String rodzajPaliwa;

    public Samochod(String nazwa, int rozmiar, int pojemnoscSilnika, String rodzajPaliwa) {
        super(nazwa, rozmiar);
        this.pojemnoscSilnika = pojemnoscSilnika;
        this.rodzajPaliwa = rodzajPaliwa;
    }

    public Samochod(String nazwa, int dlugosc, int szerokosc, int wysokosc, int pojemnoscSilnika, String rodzajPaliwa) {
        this(nazwa, dlugosc * szerokosc * wysokosc, pojemnoscSilnika, rodzajPaliwa);
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "pojemnoscSilnika=" + pojemnoscSilnika +
                ", rodzajPaliwa='" + rodzajPaliwa + '\'' +
                '}';
    }
}
