package com.game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // write your code here

        System.out.println(" =========== Game start ==============");

        BattleField battleField = new BattleField();
        battleField.init();
        System.out.println(" ============== >>>>> Battle Field is initialize");

        System.out.println(" ============== >>>>> Naming for all the ship");
        battleField.arrayOfShip[0].setName("SHIP A");
        battleField.arrayOfShip[1].setName("SHIP B");
        battleField.arrayOfShip[2].setName("SHIP C");

        battleField.setLocationForAllShip(battleField.arrayOfShip[0],battleField.arrayOfShip[1],battleField.arrayOfShip[2]);
        System.out.println(" ============== >>>>> Set position for all the ship");

        /*Hiển thị vị trí tàu*/
       /* battleField.arrayOfShip[0].printPosition();
        battleField.arrayOfShip[1].printPosition();
        battleField.arrayOfShip[2].printPosition();*/



        System.out.println(" ============== >>>>> Start to play");

        Scanner input = new Scanner(System.in);
        String userInput = "";
        boolean finish = false;

        while (finish == false){
            System.out.println(" ============== >>>>> Choose a position");
            System.out.print("Your choose is ");
            userInput = input.next();

            battleField.kiemTra(userInput);
            battleField.kiemTraTongQuan();
            if (battleField.isFinish==true)
                finish = true;
        }

    }
}
