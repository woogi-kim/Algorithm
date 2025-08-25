import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Main {
	public static String[] commands;

	public static int adder;
	public static int pc;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			commands = new String[32];
			for (int i = 0; i < 32; i++) {
				if ((commands[i] = bf.readLine()) == null) {
					return;
				}
			}
			pc = 0;
			adder = 0;

			while (true) {
				String curCommand = commands[pc];
				// System.out.println("현재 명령어 " + commands[pc]);
				pc = (pc + 1) % 32;

				String commandType = curCommand.substring(0, 3);

				int targetAddress = convertBinaryToInt(curCommand.substring(3));
				// System.out.println("타켓 주소 " + convertBinaryToInt(curCommand.substring(3)));

				if (commandType.equals("000")) {
					commands[targetAddress] = convertIntToBinary(adder);
				} else if (commandType.equals("001")) {
					adder = convertBinaryToInt(commands[targetAddress]);
				} else if (commandType.equals("010")) {
					if (adder == 0) {
						pc = targetAddress;
					}
				} else if (commandType.equals("011")) {
					continue;
				} else if (commandType.equals("100")) {
					adder = (adder - 1) & 0xFF;
				} else if (commandType.equals("101")) {
					adder = (adder + 1) & 0xFF;
				} else if (commandType.equals("110")) {
					pc = targetAddress;
				} else {
					break;
				}
				// System.out.println("가산기 값 : " + adder);
			}
			System.out.println(convertIntToBinary(adder));

		}

	}

	public static int convertBinaryToInt(String s) {
		// System.out.println(s);
		int res = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '1') {
				res += (int)Math.pow(2, s.length() - i - 1);
				// System.out.println("i: " + i);
				// System.out.println(res);
			}
		}

		return res;
	}

	public static String convertIntToBinary(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			sb.append(n % 2);

			n /= 2;
		}

		sb = sb.reverse();

		if (sb.length() > 8) {
			return sb.substring(sb.length() - 8);
		} else {
			sb = sb.reverse();
			while (sb.length() < 8) {
				sb.append(0);
			}

			return sb.reverse().toString();
		}
	}

}