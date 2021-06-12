package com.game;

import java.util.ArrayList;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Ship shipA = new Ship();
        Ship shipB = new Ship();
        Ship shipC = new Ship();

        BattleField battleField = new BattleField();
        battleField.setLocationForAllShip(shipA,shipB,shipC);

        shipA.printPosition();
        shipB.printPosition();
        shipC.printPosition();
    }

    public void testRandom() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int number = random.nextInt(7);
            System.out.print(number + "  ");
            if (number == 7)
                break;
        }
    }


}
