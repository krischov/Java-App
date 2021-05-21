package com.example.carx;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider {

    ArrayList<Cars> totalCars, allHyperCars, allJdms, allSuvs;

    public DataProvider(){

        //JDMS
        Jdm jdm1 =  new Jdm();
        Jdm jdm2 =  new Jdm();
        Jdm jdm3 =  new Jdm();
        Jdm jdm4 =  new Jdm();
        Jdm jdm5 =  new Jdm();
        Jdm jdm6 =  new Jdm();
        Jdm jdm7 =  new Jdm();
        Jdm jdm8 =  new Jdm();
        Jdm jdm9 =  new Jdm();
        Jdm jdm10 =  new Jdm();

        //SUPERCARS
        Supercar supercar1 = new Supercar();
        Supercar supercar2 = new Supercar();
        Supercar supercar3 = new Supercar();
        Supercar supercar4 = new Supercar();
        Supercar supercar5 = new Supercar();
        Supercar supercar6 = new Supercar();
        Supercar supercar7 = new Supercar();
        Supercar supercar8 = new Supercar();
        Supercar supercar9 = new Supercar();
        Supercar supercar10 = new Supercar();

        //SUVS
        Suv suv1 = new Suv();
        Suv suv2 = new Suv();
        Suv suv3 = new Suv();
        Suv suv4 = new Suv();
        Suv suv5 = new Suv();
        Suv suv6 = new Suv();
        Suv suv7 = new Suv();
        Suv suv8 = new Suv();
        Suv suv9 = new Suv();
        Suv suv10 = new Suv();

        this.totalCars = new ArrayList<Cars>(Arrays.asList(jdm1, jdm2, jdm3, jdm4, jdm5, jdm6, jdm7, jdm8, jdm9, jdm10,
            supercar1, supercar2, supercar3, supercar4, supercar5, supercar6, supercar7, supercar8, supercar9, supercar10,
                suv1, suv2, suv3, suv4, suv5, suv6, suv7, suv8, suv9, suv10));

        this.allJdms = new ArrayList<Cars>(Arrays.asList(jdm1, jdm2, jdm3, jdm4, jdm5, jdm6, jdm7, jdm8, jdm9, jdm10));
        this.allSuvs = new ArrayList<Cars>(Arrays.asList(suv1, suv2, suv3, suv4, suv5, suv6, suv7, suv8, suv9, suv10));
    }

    public ArrayList<Cars> getTopPicks(int num_topPicks){
        ArrayList<Cars> topPicks = new ArrayList<Cars>();
        for(num_topPicks = 0; num_topPicks < totalCars.size(); num_topPicks++){
            int index = (int)(Math.random() * num_topPicks);
            topPicks.add(totalCars.get(index));
        }
        return topPicks;
    }


    public ArrayList<Cars> getTotalCars() {
        return totalCars;
    }

    public void setTotalCars(ArrayList<Cars> totalCars) {
        this.totalCars = totalCars;
    }

    public ArrayList<Cars> getAllHyperCars() {
        return allHyperCars;
    }

    public void setAllHyperCars(ArrayList<Cars> allHyperCars) {
        this.allHyperCars = allHyperCars;
    }

    public ArrayList<Cars> getAllJdms() {
        return allJdms;
    }

    public void setAllJdms(ArrayList<Cars> allJdms) {
        this.allJdms = allJdms;
    }

    public ArrayList<Cars> getAllSuvs() {
        return allSuvs;
    }

    public void setAllSuvs(ArrayList<Cars> allSuvs) {
        this.allSuvs = allSuvs;
    }
}