package com.game;

import java.util.ArrayList;

public class Ship {
    String name;
    ArrayList<String> position;
    boolean isHit = false;

    public Ship(String position1, String position2, String position3) {
        position = new ArrayList<>();
        position.add(position1);
        position.add(position2);
        position.add(position3);
    }

    void printPosition() {
        System.out.println(position.toString());
    }

    Ship() {

    }

    void setName(String name) {
        this.name = name;
    }

    void kiemTra(String userInput) {
        if (position.contains(userInput) == false) {      // Nếu bắn không trúng
            //  System.out.println(" [[[[[     You miss    ]]]]]");
            isHit = false;
        } else {      // Nếu bắn trúng
            position.remove(userInput);
            isHit = true;
            if (position.isEmpty() == false)   // Tàu vẫn còn
                System.out.println(" [[[[[     Good job. Trúng một phần  " + name + "  ]]]]]");
            else        // Tàu đã bị bắn hạ
                System.out.println(" [[[[[     Good job. Tàu " + name + " đã bị bắn hạ hoàn toàn    ]]]]]");
        }
    }
}
