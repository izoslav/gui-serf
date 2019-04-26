package model;

import java.util.ArrayList;
import java.util.Date;

public class Osoba {
    final private String imie;
    final private String nazwisko;
    final private long pesel;
    final private String adresZamieszkania;
    final private Date dataUrodzenia;
    private Date dataPierwszegoNajmu;

    private ArrayList<Przedmiot> listaPrzedmiotow = new ArrayList<>();

    public Osoba(String imie, String nazwisko, long pesel, String adresZamieszkania, Date dataUrodzenia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.adresZamieszkania = adresZamieszkania;
        this.dataUrodzenia = dataUrodzenia;
    }

    // Getter i setter dataPierwszegoNajmu
    // autogeneracja Alt + Insert

    public Date getDataPierwszegoNajmu() throws NeverRentException {
        if (dataPierwszegoNajmu == null) {
            throw new NeverRentException("Nigdy nie wynajmował/a.");
        }

        return dataPierwszegoNajmu;
    }

    public void setDataPierwszegoNajmu(Date dataPierwszegoNajmu) {
        if (this.dataPierwszegoNajmu != null) {
            this.dataPierwszegoNajmu = dataPierwszegoNajmu;
        }
    }

    public ArrayList<Przedmiot> getListaPrzedmiotow() {
        return listaPrzedmiotow;
    }

    public void wypiszListePrzedmiotow() {
        System.out.println("Lista przedmiotów użytkownika " + imieNazwisko() + ":");

        for (int i = 0; i < listaPrzedmiotow.size(); i++) {
            System.out.println((i+1) + ". " + listaPrzedmiotow.get(i));
        }
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel=" + pesel +
                ", adresZamieszkania='" + adresZamieszkania + '\'' +
                ", dataUrodzenia=" + dataUrodzenia +
                ", dataPierwszegoNajmu=" + dataPierwszegoNajmu +
                '}';
    }

    public String imieNazwisko() {
        return imie + " " + nazwisko;
    }
}
