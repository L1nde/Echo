package NaidisKT;/*
 * Created by L1ND3 on 18.03.2017. 
 */

public abstract class Teos implements Comparable<Teos> {
    private String kirjeldus;
    private String tahis;
    private String laenutaja;
    private int pikkus;

    public Teos(String kirjeldus, String tahis, String laenutaja, int pikkus) {
        this.kirjeldus = kirjeldus;
        this.tahis = tahis.trim();
        this.laenutaja = laenutaja;
        this.pikkus = pikkus;
    }

    abstract boolean kasHoidlast();

    public int laenutusaeg(){
        switch (tahis){
            case("roheline"):
                return 1;
            case("puudub"):
                return 1;
            case("kollane"):
                return 30;
            case("sinine"):
                return 60;
            default:
                return 0;
        }
    }

    public double päevaneViivis(){
        switch (tahis){
            case("roheline"):
                return 2;
            case("puudub"):
                return 0.15;
            case("kollane"):
                return 0.05;
            case("sinine"):
                return 0.05;
            default:
                return 0;
        }
    }

    public void arvutaViivis(Kontrollija kontrollija){
        if (laenutusaeg() < pikkus){
            kontrollija.salvestaViivis(kirjeldus, laenutaja, (pikkus-laenutusaeg())*päevaneViivis());
        }
    }

    @Override
    public String toString() {
        double viivis;
        if (laenutusaeg() < pikkus) {
            viivis = (pikkus - laenutusaeg()) * päevaneViivis();
        }
        else{
            viivis = 0;
        }
        return kirjeldus + "\nlaenutaja: " + laenutaja + "\nteose tähis: " + tahis + "\nlaenutuse pikkus hetkel: " + pikkus + "\nVaja tellida hoidlast: " + kasHoidlast() + "\nViivis: " + viivis +" eurot\n";
    }

    @Override
    public int compareTo(Teos o) {
        return kirjeldus.compareTo(o.kirjeldus);
    }
}
