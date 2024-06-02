package cz.vse.java.adventura.logika;

public class Postava {
    private final String jmeno;
    private String inf;

    public Postava(String jmeno, String inf) {
        this.jmeno = jmeno;
        this.inf = inf;

    }

    public String getJmeno() {
        return jmeno;
    }

    public String getInf() {
        return inf;
    }
}
