package src;

public class Set <T extends Comparable <T>> {
    private T[] set;
    private int pojemnosc;
    private int rozmiar;

    public Set(int pojemnosc) {
        this.pojemnosc = pojemnosc;
        this.rozmiar = 0;
        this.set = (T[]) new Comparable[pojemnosc];
    }

    public void dodajElement ( T nowy){
        if(rozmiar >= pojemnosc){
            throw new IllegalStateException("Zbiór jest pełny");
        }
        if(szukaj(nowy) == -1) {
            int i = rozmiar - 1;
            while (i >= 0 && set[i].compareTo(nowy) > 0) {
                set[i + 1] = set[i];
                i--;
            }
            set[i + 1] = nowy;
            rozmiar++;
        }
    }

    public int szukaj(T element) {
        for(int i = 0; i < rozmiar; i++){
            if (set[i].compareTo(element) == 0) {
                return i;
            }
        }
        return -1;
    }

    public void usunElement(T element) {
        int index = szukaj(element);
        if(index == -1) {
            return;
        }
        for (int i = index; i < rozmiar - 1; i++) {
            set[i] = set[i + 1];
        }
        set[rozmiar - 1] = null;
        rozmiar--;

    }

    public Set<T> dodajElementy (Set<T> drugiZbior){
        int nowaPojemnosc = this.pojemnosc + drugiZbior.pojemnosc;
        Set<T> nowyZbior = new Set<>(nowaPojemnosc);

        for (int i = 0; i < this.rozmiar; i++)
            nowyZbior.dodajElement(this.set[i]);

        for(int i = 0; i < drugiZbior.rozmiar; i++){
            nowyZbior.dodajElement(drugiZbior.set[i]);
        }
        return nowyZbior;
    }

    public void odejmijElementy(Set<T> drugiZbior) {
        for (int i = 0; i < drugiZbior.rozmiar; i++) {
            this.usunElement(drugiZbior.set[i]);
        }
    }

    public Set<T> przeciecie (Set<T> drugiZbior) {
        int nowaPojemnosc = this.pojemnosc;
        if(this.pojemnosc>drugiZbior.pojemnosc)
            nowaPojemnosc = drugiZbior.pojemnosc;

        Set<T> nowyZbior = new Set<>(nowaPojemnosc);
        for (int i = 0; i < drugiZbior.rozmiar; i++) {
            if(this.szukaj(drugiZbior.set[i])>=0)
                nowyZbior.dodajElement(drugiZbior.set[i]);
        }
        return nowyZbior;
    }

    @Override
    public String toString() {
        String s = "pojemnosc: " + pojemnosc + " rozmiar: " + rozmiar + " " ;
        for(int i = 0; i < rozmiar; i++){
            s += set[i] + ", ";
        }
        return s;
    }
}
