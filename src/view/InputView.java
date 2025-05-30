package view;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    public int getInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    public boolean getBoolean(String message) {
        System.out.print(message);
        return sc.nextInt()==1;
    }

}
