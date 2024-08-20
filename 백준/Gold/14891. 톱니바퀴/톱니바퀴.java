import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static int[][] cogwheel;
	public static int rotateCount;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		cogwheel = new int[4][8];

		for (int i = 0; i < 4; i++) {
			String[] s = bf.readLine().split("");
			for (int j = 0; j < 8; j++) {
				cogwheel[i][j] = Integer.parseInt(s[j]);
			}
		}

		rotateCount = Integer.parseInt(bf.readLine());

		for (int i = 0; i < rotateCount; i++) {
			String[] s = bf.readLine().split(" ");
			int targetWheel = Integer.parseInt(s[0]) - 1;
			boolean isClockWise = Integer.parseInt(s[1]) == 1;

			Set<Integer> rotateWheels = new HashSet<>();
			rotateWheels.add(targetWheel);
			for (int j = targetWheel; j < 3; j++) {
				if (cogwheel[j][2] != cogwheel[j + 1][6]) {
					rotateWheels.add(j + 1);
				} else {
					break;
				}
			}

			for (int j = targetWheel; j > 0; j--) {
				if (cogwheel[j][6] != cogwheel[j - 1][2]) {
					rotateWheels.add(j - 1);
				} else {
					break;
				}
			}

			for (Integer wheel : rotateWheels) {
				if ((Math.abs(targetWheel - wheel) % 2) == 1) {
					rotateCogWheel(!isClockWise, wheel);
				} else {
					rotateCogWheel(isClockWise, wheel);
				}
			}
		}

		int ans = 0;
		ans += cogwheel[0][0] == 0 ? 0 : 1;
		ans += cogwheel[1][0] == 0 ? 0 : 2;
		ans += cogwheel[2][0] == 0 ? 0 : 4;
		ans += cogwheel[3][0] == 0 ? 0 : 8;

		System.out.println(ans);
	}

	private static void rotateCogWheel(boolean isClockWise, int cogWheelNumber) {
		int[] copy = new int[8];

		for (int i = 0; i < 8; i++) {
			copy[i] = cogwheel[cogWheelNumber][i];
		}

		if (isClockWise) {
			int last = cogwheel[cogWheelNumber][7];

			for (int i = 1; i < 8; i++) {
				cogwheel[cogWheelNumber][i] = copy[i - 1];
			}
			cogwheel[cogWheelNumber][0] = last;
		} else {
			int first = cogwheel[cogWheelNumber][0];

			for (int i = 0; i < 7; i++) {
				cogwheel[cogWheelNumber][i] = copy[i + 1];
			}
			cogwheel[cogWheelNumber][7] = first;
		}
	}

}
