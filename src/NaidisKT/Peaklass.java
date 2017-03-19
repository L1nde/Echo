package NaidisKT;/*
 * Created by L1ND3 on 18.03.2017. 
 */

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Peaklass {

    public static void main(String[] args) throws IOException {
        List<Teos> teosed = loeTeosed("laenutus.txt");
        Collections.sort(teosed);
        ViiviseHoiataja hoiataja = new ViiviseHoiataja(0.2);
        SuurimaViiviseLeidja volglane = new SuurimaViiviseLeidja();
        for (Teos teos : teosed) {
            teos.arvutaViivis(hoiataja);
            teos.arvutaViivis(volglane);
            System.out.println(teos.toString());
        }
        System.out.println("Hoiatus: " + hoiataja.getHoiatatavadLaenutajad());
        volglane.saadaHoiatus();
    }

    public static List<Teos> loeTeosed(String nimi) throws IOException{
        List<Teos> teosed = new ArrayList<>();
        File f = new File(nimi);
        Scanner scan = new Scanner(f, "UTF-8");
        while (scan.hasNextLine()){
            String[] data = scan.nextLine().split("; ");
            if (data[0].contains("/")){
                teosed.add(new Ajakiri(data[0], data[1], data[2], Integer.parseInt(data[3])));
            }
            else{
                teosed.add(new Raamat(data[0], data[1], data[2], Integer.parseInt(data[3])));
            }
        }
        return teosed;
    }
}
