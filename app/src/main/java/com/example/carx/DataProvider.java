package com.example.carx;

import java.util.ArrayList;
import java.util.Arrays;

public class DataProvider {

    ArrayList<Cars> totalCars, allSuperCars, allJdms, allSuvs;

    public DataProvider() {

        //JDMS
        Jdm jdm1 = new Jdm(
                215000f,
                "Factory stock bayside blue color\n" +
                        "\n" +
                        "Upgraded Oil Cooler\n" +
                        "\n" +
                        "Upgraded, larger Intercooler\n" +
                        "\n" +
                        "Exhaust silencer included\n" +
                        "\n" +
                        "NISMO 320km/h Gauge Cluster\n" +
                        "\n" +
                        "IMPUL CPU upgrade\n" +
                        "\n" +
                        "IMPUL Front Pipe\n" +
                        "\n" +
                        "Apex'i AVC-R Boost Controller\n" +
                        "\n" +
                        "Ohlins Shocks Installed\n" +
                        "\n" +
                        "NISMO Front and Rear Stabilizer Bars\n" +
                        "\n" +
                        "Enkei 18 inches wheels\n" +
                        "\n" +
                        "Accident free! Rust Free! Constantly maintained!\n" +
                        "\n" +
                        "NISMO speedometer installed in 1999 when the car was brand new.\n" +
                        "\n" +
                        "True, verified mileage\n" +
                        "\n" +
                        "Papers confirm there have been only two private owners and the fist one had owned the car for only 8 months. \n" +
                        "\n" +
                        "So it is almost one owner car with low mileage.\n" +
                        "\n" +
                        "Ownership papers are available upon the request.\n" +
                        "\n" +
                        "NEGOTIATE THE BEST PRICE",
                "Nissan Skyline GTR R34 V spec",
                new ArrayList<String>(Arrays.asList("jdm1_1", "jdm1_2", "jdm1_3")),
                true,
                true);
        Jdm jdm2 = new Jdm(985000f,
                "The cleanest Lexus LFA you have ever seen with only 417 km\n" +
                "\n" +
                "The car is in almost brand new condition\n" +
                "\n" +
                "Absolute Super Red color\n" +
                "\n" +
                "Factory stock\n" +
                "\n" +
                "Comes with the books\n" +
                "\n" +
                "NEGOTIATE THE BEST PRICE",
                "Lexus LFA",
                new ArrayList<String>(Arrays.asList("jdm2_1", "jdm2_2", "jdm2_3")),
                false,
                false);
        Jdm jdm3 = new Jdm(85000f,
                "This is a crazy JDM machine - Toyota Supra JZA80 RZ with 3.1L engine and 6 speed manual transmission",
                "Toyota Supra RZ 3.1 L",
                new ArrayList<String>(Arrays.asList("jdm3_1", "jdm3_2", "jdm3_3")),
                false,
                true
                );
        Jdm jdm4 = new Jdm(42500f,
                "Absolutely beautiful and low mileage Nissan Skyline GT-R R33 in midnight purple color!",
                "Nissan Skyline GTR R33",
                new ArrayList<String>(Arrays.asList("jdm4_1", "jdm4_2", "jdm4_3")),
                false,
                true);
        Jdm jdm5 = new Jdm(85000f,
                "Extrememly unique and beautifully upgraded RX7 Veilside Fast and Furios style",
                "Mazda RX Veilside",
                new ArrayList<String>(Arrays.asList("jdm5_1", "jdm5_2", "jdm5_3")),
                false,
                true
        );
        Jdm jdm6 = new Jdm();
        Jdm jdm7 = new Jdm();
        Jdm jdm8 = new Jdm();
        Jdm jdm9 = new Jdm();
        Jdm jdm10 = new Jdm();

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
        this.allSuperCars = new ArrayList<Cars>(Arrays.asList(supercar1, supercar2, supercar3, supercar4, supercar5, supercar6, supercar7, supercar8, supercar9, supercar10));
    }

    public ArrayList<Cars> getTopPicks(int num_topPicks) {
        ArrayList<Cars> topPicks = new ArrayList<Cars>();
        for (num_topPicks = 0; num_topPicks < totalCars.size(); num_topPicks++) {
            int index = (int) (Math.random() * num_topPicks);
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
        return allSuperCars;
    }

    public void setAllHyperCars(ArrayList<Cars> allHyperCars) {
        this.allSuperCars = allHyperCars;
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