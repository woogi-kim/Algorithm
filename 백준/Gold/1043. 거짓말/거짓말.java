import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static int n;
	public static int m;
	public static int truthCount;
	public static int[] knowsTruth;
	public static int[] parents;
	public static ArrayList<int[]> party;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		parents = new int[n + 1];
		party = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}

		s = bf.readLine().split(" ");
		truthCount = Integer.parseInt(s[0]);
		knowsTruth = new int[truthCount];
		for (int i = 0; i < truthCount; i++) {
			knowsTruth[i] = Integer.parseInt(s[i + 1]);
		}

		for (int i = 0; i < m; i++) {
			s = bf.readLine().split(" ");

			int partyMemberCount = Integer.parseInt(s[0]);

			int[] currentParty = new int[partyMemberCount];
			for (int j = 0; j < partyMemberCount; j++) {
				currentParty[j] = Integer.parseInt(s[j + 1]);
			}
			party.add(currentParty);
		}

		for (int i = 0; i < m; i++) {
			int firstMember = party.get(i)[0];
			for (int j = 1; j < party.get(i).length; j++) {
				union(firstMember, party.get(i)[j]);
			}
		}

		for (int i = 0; i < m; i++) {
			int leader = party.get(i)[0];
			boolean canJoin = true;
			for (int j = 0; j < truthCount; j++) {
				if (find(leader) == find(knowsTruth[j])) {
					canJoin = false;
					break;
				}
			}
			if (canJoin) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	public static void union(int a, int b) {
		int aParent = find(a);
		int bParent = find(b);
		if (a != b) {
			parents[bParent] = aParent;
		}
	}

	public static int find(int a) {
		if (parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

}
