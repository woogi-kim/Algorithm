import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String[] commands;
    public static int adder;
    public static int pc;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            commands = new String[32];
            for (int i = 0; i < 32; i++) {
                String line = bf.readLine();
                if (line == null) return;          // EOF
                commands[i] = line;
            }

            // 테스트 케이스마다 초기화
            adder = 0;
            pc = 0;

            while (true) {
                String curCommand = commands[pc];
                pc = (pc + 1) & 31;               // 5비트 PC: 자동 증가 후 모듈로 32

                String commandType = curCommand.substring(0, 3);
                int targetAddress = convertBinaryToInt(curCommand.substring(3)); // 0~31

                if (commandType.equals("000")) {          // STA x
                    commands[targetAddress] = convertIntToBinary(adder);
                } else if (commandType.equals("001")) {   // LDA x
                    adder = convertBinaryToInt(commands[targetAddress]);
                } else if (commandType.equals("010")) {   // BEQ x
                    if (adder == 0) pc = targetAddress;   // x는 이미 0~31
                } else if (commandType.equals("011")) {   // NOP
                    // do nothing
                } else if (commandType.equals("100")) {   // DEC
                    adder = wrap8(adder - 1);
                } else if (commandType.equals("101")) {   // INC
                    adder = wrap8(adder + 1);
                } else if (commandType.equals("110")) {   // JMP x
                    pc = targetAddress;
                } else {                                  // 111 ----- HLT
                    break;
                }
            }
            System.out.println(convertIntToBinary(adder));
        }
    }

    // 8비트 2진수 문자열 -> int(0~255)
    public static int convertBinaryToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = (res << 1) | (s.charAt(i) - '0');
        }
        return res & 0xFF;
    }

    // int 어떤 값이든 8비트로 래핑 후 8비트 2진수 문자열
    public static String convertIntToBinary(int n) {
        int v = wrap8(n);
        String b = Integer.toBinaryString(v);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 - b.length(); i++) sb.append('0');
        sb.append(b);
        return sb.toString();
    }

    // 0~255로 모듈러
    private static int wrap8(int x) {
        return ((x % 256) + 256) % 256;
    }
}