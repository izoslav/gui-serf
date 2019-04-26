package model;

public class NeverRentException extends Exception {
    public NeverRentException(String wiadomosc) {
        super(wiadomosc);
    }
}
