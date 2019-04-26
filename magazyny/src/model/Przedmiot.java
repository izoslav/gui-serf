package model;

abstract public class Przedmiot implements Comparable<Przedmiot> {
    final private String nazwa;
    private int rozmiar;

    public Przedmiot(String nazwa, int rozmiar) {
        this.nazwa = nazwa;
        this.rozmiar = rozmiar;
    }

    public Przedmiot(String nazwa, int dlugosc, int szerokosc, int wysokosc) {
        this(nazwa, dlugosc * szerokosc * wysokosc);
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(int rozmiar) {
        this.rozmiar = rozmiar;
    }

    // część https://howtodoinjava.com/sort/collections-sort/
    @Override
    public int compareTo(Przedmiot przedmiot) {
        if (rozmiar == przedmiot.rozmiar) {
            return nazwa.compareTo(przedmiot.nazwa);
        }

        return Integer.compare(rozmiar, przedmiot.rozmiar);
    }
}
