package view;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);

    /**
     * 사용자로부터 정수 입력을 받는 메소드
     *
     * @param message 사용자에게 보여줄 메시지
     * @return 입력된 문자열
     */
    public int getInt(String message) {
        System.out.print(message);
        return sc.nextInt();
    }

    /**
     * 사용자로부터 예/아니오의 입력을 받는 메소드
     *
     * @param message 사용자에게 보여줄 메시지
     * @return boolean 값 (예: 1은 true, 2은 false)
     */
    public boolean getBoolean(String message) {
        System.out.print(message);
        return sc.nextInt() == 1;
    }

}
