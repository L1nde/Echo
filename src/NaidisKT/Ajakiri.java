package NaidisKT;/*
 * Created by L1ND3 on 18.03.2017. 
 */

public class Ajakiri extends Teos {
    private int aasta;

    public Ajakiri(String kirjeldus, String tahis, String laenutaja, int pikkus) {
        super(kirjeldus, tahis, laenutaja, pikkus);
        this.aasta = Integer.parseInt(kirjeldus.split("/")[1].split(",")[0]);
    }

    @Override
    boolean kasHoidlast() {
        return aasta <= 2000;
    }

    @Override
    public String toString() {
        return "Ajakiri: " + super.toString();
    }
}
