import model.*;

public class Main {
    public static void main(String[] args) {
        Menu m = new Menu();

        m.uruchom();
    }

    private void test() throws Exception {
        Magazyn magazyn = new Magazyn();

        Pomieszczenie p1 = new Pomieszczenie(10, true);
        Pomieszczenie p2 = new Pomieszczenie(2, 3, 4, true);

        magazyn.dodajPomieszczenie(p2); // najpierw większe
        magazyn.dodajPomieszczenie(p1); // potem mniejsze

        System.out.println(magazyn);

        Samochod s1 = new Samochod("Mazda", 12, 2, "gaz");

        Rower r1 = new Rower("BMX", 3, 4, "tarczowe", 0);
        Rower r2 = new Rower("Składak", 2, 5, "cokolwiek", 4);

        Motocykl m1 = new Motocykl("HONDAAAAAA", 7, 1, true);
        Motocykl m2 = new Motocykl("SU-ZU-KIII", 8, 2, false);

        System.out.println(s1);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(m1);
        System.out.println(m2);

        // p1.dodajPrzedmiot(s1); // rzuca wyjątek! samochód za duży, żeby dodać!
        p1.dodajPrzedmiot(r1);
        p1.dodajPrzedmiot(r2);
//        p1.dodajPrzedmiot(m1); // rzuca wyjątek! r1+r2+m1 = 12 > 10 rozmiar pomieszczenia
    }
}
