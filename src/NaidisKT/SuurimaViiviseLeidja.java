package NaidisKT;/*
 * Created by L1ND3 on 18.03.2017. 
 */

public class SuurimaViiviseLeidja implements Kontrollija {
    private double suurimViivis = 0;
    private String omanik;
    private String teos;

    @Override
    public void salvestaViivis(String kirjelddus, String laenutaja, double viivis) {
        if (viivis > suurimViivis){
            suurimViivis = viivis;
            omanik = laenutaja;
            teos = kirjelddus;
        }
    }

    public void saadaHoiatus(){
        System.out.println("Suurim viivis(" + suurimViivis + " eurot): " + omanik + " teos: " + teos);
    }
}
