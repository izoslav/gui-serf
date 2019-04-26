package model;

import java.util.ArrayList;
import java.util.Collections;

public class Magazyn {
    private ArrayList<Pomieszczenie> listaPomieszczen = new ArrayList<>();

    public void dodajPomieszczenie(Pomieszczenie pomieszczenie) {
        listaPomieszczen.add(pomieszczenie);

        Collections.sort(listaPomieszczen);
    }

    public ArrayList<Pomieszczenie> getListaPomieszczen() {
        return listaPomieszczen;
    }

    // automatycznie wygenerowane alt+insert
    @Override
    public String toString() {
        return "Magazyn{" +
                "listaPomieszczen=" + listaPomieszczen +
                '}';
    }
}
