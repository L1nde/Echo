package NaidisKT;/*
 * Created by L1ND3 on 18.03.2017. 
 */

public class Raamat extends Teos {
    private String tahis;

    public Raamat(String kirjeldus, String tahis, String laenutaja, int pikkus) {
        super(kirjeldus, tahis, laenutaja, pikkus);
        this.tahis = tahis;
    }

    @Override
    boolean kasHoidlast() {
        return tahis.equals("sinine") || tahis.equals("kollane");
    }

    @Override
    public String toString() {
        return "Raamat: " + super.toString();
    }
}
