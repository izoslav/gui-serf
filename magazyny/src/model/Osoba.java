package model;

import java.util.Date;

public class Osoba {
    final private String imie;
    final private String nazwisko;
    final private int pesel;
    final private String adresZamieszkania;
    final private Date dataUrodzenia;
    private Date dataPierwszegoNajmu;

    public Osoba(String imie, String nazwisko, int pesel, String adresZamieszkania, Date dataUrodzenia) {
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
        this.dataPierwszegoNajmu = dataPierwszegoNajmu;
    }
}
