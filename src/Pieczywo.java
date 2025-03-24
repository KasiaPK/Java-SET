package src;

public class Pieczywo implements Comparable<Pieczywo>{
    private String nazwa;
    private int cena;
    public Pieczywo(String nazwa, int cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }
    @Override
    public String toString() {
        return nazwa + " " + cena + " zł";
    }

    @Override
    public int compareTo(Pieczywo o){
        return Integer.compare(this.cena, o.cena);
    }
}

