package NaidisKT;/*
 * Created by L1ND3 on 18.03.2017. 
 */

import java.util.ArrayList;
import java.util.List;

public class ViiviseHoiataja implements Kontrollija {
    private double viiviseLiimit;
    private List<String> volglased = new ArrayList<>();

    public ViiviseHoiataja(double viiviseLiimit) {
        this.viiviseLiimit = viiviseLiimit;
    }

    @Override
    public void salvestaViivis(String kirjelddus, String laenutaja, double viivis) {
        if (viiviseLiimit < viivis && !volglased.contains(laenutaja)){
            volglased.add(laenutaja);
        }
    }

    public List<String> getHoiatatavadLaenutajad(){
        return volglased;
    }
}
