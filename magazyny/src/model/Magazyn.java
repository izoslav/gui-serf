package model;

import java.util.ArrayList;
import java.util.Collections;

public class Magazyn {
    private ArrayList<Pomieszczenie> listaPomieszczen;

    public Magazyn() {
        this.listaPomieszczen = new ArrayList<>();
    }

    public void dodajPomieszczenie(Pomieszczenie pomieszczenie) {
        listaPomieszczen.add(pomieszczenie);

        Collections.sort(listaPomieszczen);
    }
}
