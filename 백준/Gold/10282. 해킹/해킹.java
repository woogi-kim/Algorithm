import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node {
	int num;
	int time;

	public Node(int num, int time) {
		this.num = num;
		this.time = time;
	}
}

public class Main {
	public static int t;
	public static int n;
	public static int d;
	public static int c;
	public static ArrayList<Node>[] adjList;
	public static int[] distance;
	public static int infectedNumber;
	public static int infectedTime;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(bf.readLine());
		while (t > 0) {
			String[] strings = bf.readLine().split(" ");
			n = Integer.parseInt(strings[0]);
			d = Integer.parseInt(strings[1]);
			c = Integer.parseInt(strings[2]);

			adjList = new ArrayList[n + 1];
			distance = new int[n + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);

			for (int i = 0; i <= n; i++) {
				adjList[i] = new ArrayList<>();
			}

			for (int i = 0; i < d; i++) {
				strings = bf.readLine().split(" ");
				int a = Integer.parseInt(strings[0]);
				int b = Integer.parseInt(strings[1]);
				int s = Integer.parseInt(strings[2]);
				adjList[b].add(new Node(a, s));
			}

			dijkstra(c);

			infectedNumber = 0;
			infectedTime = 0;
			for (int i = 0; i < distance.length; i++) {
				if (distance[i] != Integer.MAX_VALUE) {
					infectedNumber++;
					infectedTime = Math.max(infectedTime, distance[i]);
				}
			}

			sb.append(infectedNumber).append(' ').append(infectedTime).append('\n');
			t--;
		}
		System.out.println(sb);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
		pq.add(new Node(start, 0));
		distance[start] = 0;

		infectedTime = 0;
		infectedNumber = 1;

		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();

			if (distance[currentNode.num] < currentNode.time) {
				continue;
			}

			for (int i = 0; i < adjList[currentNode.num].size(); i++) {
				Node nextNode = adjList[currentNode.num].get(i);

				if (distance[nextNode.num] > currentNode.time + nextNode.time) {
					distance[nextNode.num] = currentNode.time + nextNode.time;
					pq.add(new Node(nextNode.num, distance[nextNode.num]));
				}
			}
		}

	}

}
