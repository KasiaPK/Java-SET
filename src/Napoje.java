package src;

public class Napoje implements Comparable<Napoje>{
    private String nazwa;
    private int cena;
    public Napoje(String nazwa, int cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }
    @Override
    public String toString() {
        return  nazwa + " " + cena + " zł";
    }

    @Override
    public int compareTo(Napoje o){
        return Integer.compare(this.cena, o.cena);
    }
}
