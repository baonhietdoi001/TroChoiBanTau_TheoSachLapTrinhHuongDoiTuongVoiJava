package com.game;

import java.util.ArrayList;
import java.util.Random;

public class BattleField {
    String row[];
    int collumn[];
    Ship arrayOfShip[];
    boolean isFinish = false;


    public void init() {
        row = new String[]{"A", "B", "C", "D", "E", "F", "G"};
        collumn = new int[]{0, 1, 2, 3, 4, 5, 6};
        arrayOfShip = new Ship[3];
        initAllTheShip();

    }

    public void setLocationForAllShip(Ship shipA, Ship shipB, Ship shipC) {
        do {
            setLocationForOneShip(shipA);
            setLocationForOneShip(shipB);
            setLocationForOneShip(shipC);
        }
        while (testTrungLapForAll(shipA, shipB, shipC) == false);


    }

    public void setLocationForOneShip(Ship ship) {
        Random random = new Random();
        int position_column = random.nextInt(7);
        while (position_column > 4)
            position_column = random.nextInt(7);
        if (position_column > 4) {
            System.out.println("position column > 4");
            System.out.println("Exit");
            System.exit(0);
        }
        int position_row_sub = random.nextInt(7);
        String position_row;

        switch (position_row_sub) {
            case 0:
                position_row = "A";
                break;
            case 1:
                position_row = "B";
                break;
            case 2:
                position_row = "C";
                break;
            case 3:
                position_row = "D";
                break;
            case 4:
                position_row = "E";
                break;
            case 5:
                position_row = "F";
                break;
            case 6:
                position_row = "G";
                break;
            default:
                position_row = "Z";
        }

        ArrayList<String> position = new ArrayList<>();
        position.add(position_row + position_column);
        position.add(position_row + (position_column + 1));
        position.add(position_row + (position_column + 2));

        ship.position = position;
    }

    public boolean testTrungLapViTriTau(Ship shipA, Ship shipB) {
        for (String i : shipA.position)
            if (shipB.position.contains(i))
                return false;

        return true;
    }

    public boolean testTrungLapForAll(Ship shipA, Ship shipB, Ship shipC) {
        boolean testAB = testTrungLapViTriTau(shipA, shipB);
        boolean testBC = testTrungLapViTriTau(shipB, shipC);
        boolean testAC = testTrungLapViTriTau(shipA, shipC);

        if (testAB == false || testBC == false || testAC == false)
            return false;
        else
            return true;
    }

    void initAllTheShip() {
        for (int i = 0; i <= 2; i++) {
            arrayOfShip[i] = new Ship();
        }
    }

    void kiemTra(String userInput) {
        for (int i = 0; i <= 2; i++) {
            arrayOfShip[i].kiemTra(userInput);
        }
        if (arrayOfShip[0].isHit == false && arrayOfShip[1].isHit == false && arrayOfShip[2].isHit == false)
            System.out.println(" [[[[[     You miss    ]]]]]");
    }

    void kiemTraTongQuan() {
        int count = 3;

        for (int i = 0; i <= 2; i++) {
            if (arrayOfShip[i].position.isEmpty())
                count = count - 1;
        }

        if (count > 0)
            System.out.println("[[[[[    Thông báo. Còn " + count + " tàu     ]]]]]");
        else{
            System.out.println("[[[[[    Chúc mừng. Bạn đã bắn hạ toàn bộ tàu     ]]]]]");
            isFinish = true;
        }
    }


}
