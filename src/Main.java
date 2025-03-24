package src;

public class Main {
    public static void main(String[] args) {

        try {
            Set<Pieczywo> pieczywa = new Set<>(5);
            pieczywa.dodajElement(new Pieczywo("Chleb", 5));
            pieczywa.dodajElement(new Pieczywo("Bułka", 2));
            pieczywa.dodajElement(new Pieczywo("Bagietka", 4));
            System.out.println(pieczywa);

            pieczywa.usunElement(new Pieczywo("Bagietka", 4));
            System.out.println("Po usunięciu Bagietki");
            System.out.println(pieczywa);

            Set<Napoje> napoje = new Set<>(5);
            napoje.dodajElement(new Napoje("Cola", 6));
            napoje.dodajElement(new Napoje("Sok", 5));
            napoje.dodajElement(new Napoje("Woda", 2));
            System.out.println(napoje);

            Set<Pieczywo> innePieczywa = new Set<>(5);
            innePieczywa.dodajElement(new Pieczywo("Bułka", 2));
            innePieczywa.dodajElement(new Pieczywo("Pączek", 3));

            Set<Pieczywo> sumaPieczywa = pieczywa.dodajElementy(innePieczywa);
            System.out.println("Suma zbiorów");
            System.out.println(sumaPieczywa);

            Set<Pieczywo> przecieciePieczywa = pieczywa.przeciecie(innePieczywa);
            System.out.println("Przecięcie zbiorów pieczywa");
            System.out.println(przecieciePieczywa);

            pieczywa.odejmijElementy(innePieczywa);
            System.out.println("Różnica zbiorów pieczywa");
            System.out.println(pieczywa);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
