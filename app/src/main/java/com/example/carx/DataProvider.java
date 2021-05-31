package com.example.carx;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DataProvider {

    static ArrayList<Cars> totalCars, allSuperCars, allJdms, allSuvs;

    public DataProvider() {
        Log.e("recreating DP", "error");
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
                "Extremely unique and beautifully upgraded RX7 Veilside Fast and Furious style",
                "Mazda RX Veilside",
                new ArrayList<String>(Arrays.asList("jdm5_1", "jdm5_2", "jdm5_3")),
                false,
                true
        );
        Jdm jdm6 = new Jdm(18200f,
                "182,048 kms\n" +
                        "\n" +
                        "Carbing Okuyama shift knob\n" +
                        "\n" +
                        "Momo steering wheel\n" +
                        "\n" +
                        "Recaro seats\n" +
                        "\n" +
                        "Enkei wheels\n" +
                        "\n" +
                        "Tein suspension[Front & rear strut bars\n" +
                        "\n" +
                        "Aftermarket exhaust\n" +
                        "\n" +
                        "HKS intake",
                "Mitsubishi Lancer EVO ",
                new ArrayList<String>(Arrays.asList("jdm6_1", "jdm6_2", "jdm6_3")),
                false,
                true);
        Jdm jdm7 = new Jdm(18500f,
                "Super clean, comes with maintenance records\n" +
                        "\n" +
                        "No mechanical issues\n" +
                        "\n" +
                        "No accidents\n" +
                        "\n" +
                        "Well maintained, in a great running condition\n" +
                        "\n" +
                        "Glass T bar roof\n" +
                        "\n",
                "Toyota MR2 GT",
                new ArrayList<String>(Arrays.asList("jdm7_1", "jdm7_2", "jdm7_3")),
                false,
                true);
        Jdm jdm8 = new Jdm(330000f,
                "One of the rarest JDM cars - Honda NSX NA2 Type S\n" +
                        "\n" +
                        "Clean and well maintained \n" +
                        "\n" +
                        "Stock\n" +
                        "\n" +
                        "Low mileage\n" +
                        "\n" +
                        "No accidents \n" +
                        "\n" +
                        "No mechanical issues",
                "Honda NSX type S",
                new ArrayList<String>(Arrays.asList("jdm8_1", "jdm8_2", "jdm8_3")),
                false,
                false);
        Jdm jdm9 = new Jdm(24500f,
                "Clean and well maintained Farilady Z Twin Turbo with 5 speed M/T\n" +
                        "\n" +
                        "Comes with a few very nice aftermarket upgrades",
                "Nissan Fairlady Z TT",
                new ArrayList<String>(Arrays.asList("jdm9_1", "jdm9_2", "jdm9_3")),
                false,
                true
        );
        Jdm jdm10 = new Jdm(24500f,
                "Clean and nicely modified Nissan 180SX SR20DET\n" +
                        "\n" +
                        "Accidents free\n" +
                        "\n" +
                        "Trust intercooler\n" +
                        "\n" +
                        "Trust radiator\n" +
                        "\n" +
                        "TOMEI Exhaust manifold\n" +
                        "\n" +
                        "Reinforced clutch\n" +
                        "\n" +
                        "LSD\n" +
                        "\n" +
                        "D-Max Tie rod\n" +
                        "\n" +
                        "Front/rear tower bars\n" +
                        "\n" +
                        "Body aero kit\n" +
                        "\n" +
                        "8 points roll cage",
                "Nissan 180SX",
                new ArrayList<String>(Arrays.asList("jdm10_1", "jdm10_2", "jdm10_3")),
                false,
                true);

        //SUPERCARS
        Supercar supercar1 = new Supercar(215000f,
                "Just Arrived***2015 Lamborghini Huracan LP610-4 AWD Coupe***Sportivo Bicolor Interior w/Smooth Leather Package***Navigation System***Lamborghini Infotainment System II***Front & Rear Parking Sensors***Rear Vision Camera***Sport Steering Wheel w/Paddle Shifters***Push Button Start***Remote Keyless Entry***Alcantara Door Trim***Premium Smooth Leather Seating Surfaces w/Full Electric Adjustable Heated Sport Bucket Seats***Illuminated Entry***Huracan Door Sills***Lifting System & Magnetorheological Suspension Package***Silver Painted Calipers***LED Daytime Running Lamps***HID Headlamps w/Headlamp Cleaning***LED Taillamps***Rear Window Side Vents***Power Heated Folding Door Mirrors***Security System***20\" x 8.5\" Front & 20\" x 11\" Rear Giano Silver Alloy Wheels***5.2L V10 DOHC 40V Engine***7-Speed Automatic Transmission***Blu Achelous Metallic Transmission***Clean Carfax History Report!!! Well Maintained!!! Fully Serviced!!! Only 15,800 Miles!!! Stunning Blu Achelous Metallic Paint!!! Loaded Up!!! Great Buy!!!"
                , "2015 Lamborghini Huracan LP610-4",
                new ArrayList<String>(Arrays.asList("sc1_1", "sc1_2", "sc1_3")),
                true,
                320
        );

        Supercar supercar2 = new Supercar(272700f,
                "Ferrari of Newport Beach is proud to present this 2016 Ferrari 488 Spider in Rosso Corsa with Beige Tradizione interior. Options include: Apple Carplay, Adaptive Frontlight System, Leather Upholst. Seat Backrest, Yellow Brake Calipers, Carbon Fiber Rear Air-Ducts, Carbon Fiber Fog Lamp, Carbon Fiber Driver Zone + LED's, Carbon Fiber Central Bridge, Central Tunnel in Leather, Dash Inserts Carbon Fiber, Suspension Lifter, Cavallino Stitched on Headrest, Sport Exhaust System, Colored Mats with Logo, Scuderia Ferrari Shields, Parking Camera, Front and Rear Parking Sensors, 20 Forged Dark Painted Rims, Yellow Rev. Counter, Full Electric Seats, Premium Hi-Fi System and Colored Special Stitching O.R.  "
                , "2016 Ferrari 488 Spider",
                new ArrayList<String>(Arrays.asList("sc2_1", "sc2_2", "sc2_3")),
                true,
                333
        );

        Supercar supercar3 = new Supercar(259900f,
                "Own this CARFAX 1-Owner and Buyback Guarantee Qualified 600LT today, worry free! WARRANTY A Factory Warranty is included with this vehicle. Contact seller for more information. EXTREMELY LOW MILES! Get the best value from your vehicle purchase. This 2019 boasts an extremely low 927 miles! LOADED WITH VALUE! This McLaren 600LT comes equipped with: Tachometer, Digital Info Center, Cruise Control, Privacy Glass/Tinted Windows, Tilt Steering Wheel, Steering Radio Controls, Power Locks, ABS Brakes, Fog Lights, Traction Control, Intermittent Wipers, Side Airbags, Dynamic Stability, Keyless Entry, Rear Defogger, Security System Cruise Control, Tinted Windows, Power Door Locks, Tachometer, Digital Info Center, Tilt Steering Wheel, Steering Wheel Radio Controls, Side Airbags, Keyless Entry, Security System, ABS Brakes, Traction Control, Dynamic Stability, Rear Defogger, Fog Lights, Intermittent Wipers, Alloy Wheels, Leather/Suede Interior Surface, 3.8L Twin-Turbocharged V8, Rear-Wheel Drive, Carbon Fiber Racing Seats -inc: Regular or touring fit, 2-Way Driver Seat -inc: Manual Fore/Aft Movement, Fixed Passenger Seat, Fixed Rear Windows, Sport Alcantara Simulated Suede Steering Wheel, Front Cupholder, Proximity Key For Doors And Push Button Start, Valet Function, Remote Releases -Inc: Power Cargo Access.",
                "2019 McLaren 600LT Coupe",
                new ArrayList<String>(Arrays.asList("sc3_1", "sc3_2", "sc3_3")),
                true,
                323
        );

        Supercar supercar4 = new Supercar(241900f,
                "Our very last DB11 Volante. Very unique color combination that must be seen! Please inquire with us as the availability of this exceptional automobile!",
                "2020 Aston Martin DB11 Volante",
                new ArrayList<String>(Arrays.asList("sc4_1", "sc4_2", "sc4_3")),
                true,
                339
        );
        Supercar supercar5 = new Supercar(1499000f,
                "*DESIRED FEATURES:* AWD, Rear Camera, Navigation, Leather, Bluetooth, SiriusXM, Premium Audio, Alloy Wheels.This all wheel drive 2015 Porsche 918 Spyder 2dr Roadster is one of those used cars Columbus, OH shoppers seek out for its Liquid Metal Silver exterior with a Onyx Black/acid Green Interior. With 3,643 miles this 2015 918 Spyder with a 8cyl, 4.6l, hp engine is your best buy near Columbus, OH.",
                "2015 Porsche 918 Spyder Base",
                new ArrayList<String>(Arrays.asList("sc5_1", "sc5_2", "sc5_3")),
                true,
                339
        );

        Supercar supercar6 = new Supercar(157868f,
                "Has a 3.8 litre twin turbo V6 producing 562bhp and 470lb ft with a 0-62mph of 2.7 secs.\n" +
                    "Has many features such as Apple Carplay, review camera, navigation system, GTR, multi-function display, leather interior and a Bose sound system. Also has many safety and driver assist features: vehicle dynamic control, traction control, and anti-lock braking system.",
                "2021 Nissan R35 GTR",
                new ArrayList <String>(Arrays.asList("sc6_1", "sc6_2", "sc6_3")),
                true,
                315
        );

        Supercar supercar7 = new Supercar(200000f,
                "375kW/470Nm 4.0 litre flat six engine with the option of six-speed manual or seven speed PDK dual clutch automatic transmission. 0-100km/h in 3.4 seconds.\n"
                        + "\n" + "Standard features include tinted LED headlights, rear parking sensors, auto dimming mirrors with rain sensors, reversing camera, front axle lift system, tyre sealant, onboard electric air compressor, DAB+ digital radio and metallic paint.",
                "2021 Porsche 911 GT3",
                new ArrayList <String>(Arrays.asList("sc7_1", "sc7_2", "sc7_3")),
                false,
                320
        );

        Supercar supercar8 = new Supercar(4029245f,
                "The absolute pinnacle.",
                "2021 Bugatti Chiron",
                new ArrayList <String>(Arrays.asList("sc8_1", "sc8_2", "sc8_3")),
                true,
                489
        );

        Supercar supercar9 = new Supercar(298724f,
                "**BRAND NEW**\n" + "Mid-mounted 602hp naturally aspirated 5.2 litre V-10. Seven speed dual clutch automatic and all-wheel drive. 0-60mph in 2.5 seconds.\n" + "**FEATURES**\n" + "8.4-inch touchscreen with audio system, climate settings, Apple Carplay, and Amazon Alexa integration.",
                "2021 Lamborghini Huracan",
                new ArrayList <String>(Arrays.asList("sc9_1", "sc9_2", "sc9_3")),
                true,
                325
        );

        Supercar supercar10 = new Supercar(418516f,
                "High performance vehicle achieving 0-60mph in 2.7 seconds. \n"
                + "Has a luxurious Carbon fibre tub to limit weight and ensure rigidity with two seat cabin. \n"
                + "\n"
                + "Features include:\n"
                + "Vertically oriented 7.0-inch touchscreen that includes Bluetooth, four speaker audio system and two USB ports. Front and rear parking sensors, front end lift system and backup camera.",
                "2020 Mclaren 720s",
                new ArrayList <String>(Arrays.asList("sc10_1", "sc10_2", "sc10_3")),
                true,
                342
        );

//        //SUVS
        Suv suv1 = new Suv(14000f,
                "2007 Porsche Cayenne which has been well looked after. Has many features such as Climate Air-Con, Electric Seats, Drivers with 3 memories, Heated Steering Wheel and Front seats; Remote Door Locking, 4.8 Quad Cam 32 Valve V8 Engine and 10 Airbags",
                "2007 Porsche Cayenne S",
                new ArrayList <String>(Arrays.asList("suv1_1", "suv1_2", "suv1_3")),
                false,
                218.1f
        );

        Suv suv2 = new Suv(30000f,
                "2018 Model, good condition, search MAXDA CX-5 for more information.",
                "Maxda CX-5",
                new ArrayList <String>(Arrays.asList("suv2_1", "suv2_2", "suv2_3")),
                false,
                193f
        );

        Suv suv3 = new Suv(32790f,
                "Incredibly spacious for people and cargo, has a powerful V-6 and comes with a slew of safety features. Excellent for the family.",
                "2021 Honda Passport",
                new ArrayList <String>(Arrays.asList("suv3_1", "suv3_2", "suv3_3")),
                true,
                190f
        );

        Suv suv4 = new Suv(41000f,
                "A large high quality 7-seater SUV.",
                "2021 Kia Sorento Hybrid",
                new ArrayList <String>(Arrays.asList("suv4_1", "suv4_2", "suv4_3")),
                true,
                208.3f
        );

        Suv suv5 = new Suv(7000f,
                "Beautifully looked after 2008 Hyundai Santa Fe AWD\n" +
                        "\n" +
                        "* Tires, battery and door has been replaced.\n" +
                        "\n" +
                        "* Working air cooler.\n" +
                        "\n" +
                        "* Trust radiator\n" +
                        "\n" +
                        "* Minor to little dents and scratches\n" +
                        "\n" +
                        "Drives like it is new!",
                "2008 Hyundai Santa Fe",
                new ArrayList <String>(Arrays.asList("suv5_1", "suv5_2", "suv5_3")),
                false,
                206f
        );

        Suv suv6 = new Suv(55190f,
                "The Model Y is designed to be the safest vehicle in its class, boasting multiple safety features such as the low centre of gravity\n"
                + "The Model Y also presents the user with a slew of amazing features such as autopilot, a massive range on a single charge and seating for five.",
                "Tesla Model Y 2021 Performance",
                new ArrayList <String>(Arrays.asList("suv6_1", "suv6_2", "suv6_3")),
                true,
                168f
        );

        Suv suv7 = new Suv(45000f,
                "With a focus on interior space and comfort, plus an eye toward splashy technology features on some trims, the Atlas Cross Sport is one of the best offerings in its class.",
                "2020 Volkswagen Atlas Cross Sport",
                new ArrayList <String>(Arrays.asList("suv7_1", "suv7_2", "suv7_3")),
                true,
                203f
        );

        Suv suv8 = new Suv(10000f,
                "A compact, nimble BMW that feels solid on the road. There is ample cargo space and the car is an excellent choice for day to day use!",
                "2011 BMW X1",
                new ArrayList <String>(Arrays.asList("suv8_1", "suv8_2", "suv8_3")),
                false,
                194.1f
        );

        Suv suv9 = new Suv(79900f,
                "Own the road. Share the Planet. The dynamic Scandinavian SUV that protects what's important.",
                "Volvo XC60 2021",
                new ArrayList <String>(Arrays.asList("suv9_1", "suv9_2", "suv9_3")),
                true,
                216.2f
        );

        Suv suv10 = new Suv(5000f,
                "Great usage and still going strong\n."
                        + "\n"
                        + "4WD. "
                        + "\n"
                        + "NOTE: Has had 5+ owners.",
                "2011 Great Wall X240",
                new ArrayList <String>(Arrays.asList("suv10_1", "suv10_2", "suv10_3")),
                false,
                180.6f
        );

        this.totalCars = new ArrayList<Cars>(Arrays.asList(jdm1, jdm2, jdm3, jdm4, jdm5, jdm6, jdm7, jdm8, jdm9, jdm10,
                supercar1, supercar2, supercar3, supercar4, supercar5, supercar6, supercar7, supercar8, supercar9, supercar10,
                suv1, suv2, suv3, suv4, suv5, suv6, suv7, suv8, suv9, suv10));

        this.allJdms = new ArrayList<Cars>(Arrays.asList(jdm1, jdm2, jdm3, jdm4, jdm5, jdm6, jdm7, jdm8, jdm9, jdm10));
        this.allSuvs = new ArrayList<Cars>(Arrays.asList(suv1, suv2, suv3, suv4, suv5, suv6, suv7, suv8, suv9, suv10));
        this.allSuperCars = new ArrayList<Cars>(Arrays.asList(supercar1, supercar2, supercar3, supercar4, supercar5, supercar6, supercar7, supercar8, supercar9, supercar10));
    }

    public ArrayList<Cars> getTopPicks(int num_topPicks) {
        ArrayList<Cars> realTopPicks = new ArrayList<Cars>();
        Collections.sort(this.totalCars, new Comparator<Cars>() {
            @Override
            public int compare(Cars lhs, Cars rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.views > rhs.views ? -1 : (lhs.views < rhs.views) ? 1 : 0;
            }
        });
        for(int i = 0; i < num_topPicks; i++){
            realTopPicks.add(totalCars.get(i));
        }
        return realTopPicks;
    }


    public static ArrayList<Cars> getTotalCars() {
        return totalCars;
    }

    public void setTotalCars(ArrayList<Cars> totalCars) {
        this.totalCars = totalCars;
    }

    public static ArrayList<Cars> getAllHyperCars() {
        return allSuperCars;
    }

    public void setAllHyperCars(ArrayList<Cars> allHyperCars) {
        this.allSuperCars = allHyperCars;
    }

    public static ArrayList<Cars> getAllJdms() {
        return allJdms;
    }

    public void setAllJdms(ArrayList<Cars> allJdms) {
        this.allJdms = allJdms;
    }

    public static ArrayList<Cars> getAllSuvs() {
        return allSuvs;
    }

    public void setAllSuvs(ArrayList<Cars> allSuvs) {
        this.allSuvs = allSuvs;
    }
}