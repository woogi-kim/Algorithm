import java.lang.System.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Node{" +
			"x=" + x +
			", y=" + y +
			'}';
	}
}

public class Main {
	public static int n;
	public static boolean[][] isDragonCurve;
	public static List<Node> dragonCurveNode = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());

		isDragonCurve = new boolean[101][101];
		for (int i = 0; i < n; i++) {
			String[] s = bf.readLine().split(" ");

			int startX = Integer.parseInt(s[0]);
			int startY = Integer.parseInt(s[1]);
			int direction = Integer.parseInt(s[2]);
			int generation = Integer.parseInt(s[3]);

			dragonCurveNode = new ArrayList<>();
			isDragonCurve[startY][startX] = true;
			dragonCurveNode.add(new Node(startX, startY));

			Node secondNode = null;
			switch (direction) {
				case 0:
					secondNode = new Node(startX + 1, startY);
					break;
				case 1:
					secondNode = new Node(startX, startY - 1);
					break;
				case 2:
					secondNode = new Node(startX - 1, startY);
					break;
				case 3:
					secondNode = new Node(startX, startY + 1);
			}

			isDragonCurve[secondNode.y][secondNode.x] = true;
			dragonCurveNode.add(secondNode);
			drawDragonCurve(1, generation, secondNode);
		}

		int ans = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (isDragonCurve[i][j] && isDragonCurve[i + 1][j] && isDragonCurve[i][j + 1] && isDragonCurve[i + 1][j + 1]) {
					ans++;
				}
			}
		}

		System.out.println(ans);
	}

	private static void drawDragonCurve(int startGeneration, int lastGeneration, Node lastNode) {
		if (startGeneration == lastGeneration + 1) {
			return;
		}

		for (int i = dragonCurveNode.size() - 1; i >= 0; i--) {
			int diffX = dragonCurveNode.get(i).x - lastNode.x;
			int diffY = dragonCurveNode.get(i).y - lastNode.y;

			Node newNode = new Node(lastNode.x - diffY, lastNode.y + diffX);
			isDragonCurve[newNode.y][newNode.x] = true;
			dragonCurveNode.add(newNode);
		}
		drawDragonCurve(startGeneration + 1, lastGeneration, dragonCurveNode.get(dragonCurveNode.size() - 1));
	}

}