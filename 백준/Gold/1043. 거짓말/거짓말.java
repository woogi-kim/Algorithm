import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static int n;
	public static int m;
	public static int truthCount;
	public static int[] truthList;
	public static ArrayList<int[]> party;
	public static boolean[] canJoin;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] s = bf.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);

		party = new ArrayList<>();
		canJoin = new boolean[m];

		Arrays.fill(canJoin, true);

		s = bf.readLine().split(" ");
		truthCount = Integer.parseInt(s[0]);
		truthList = new int[truthCount];
		for (int i = 0; i < truthCount; i++) {
			truthList[i] = Integer.parseInt(s[i + 1]);
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

		for (int i = 0; i < truthCount; i++) {
			for (int j = 0; j < party.size(); j++) {
				for (int k = 0; k < party.get(j).length; k++) {
					if (party.get(j)[k] == truthList[i]) {
						canJoin[j] = false;
						for (int member : party.get(j)) {
							if (member != truthList[i]) {
								search(member);
							}
						}
					}
				}
			}
		}

		// for (int i = 0; i < list.size(); i++) {
		// 	for (int j = 0; j < party.size(); j++) {
		// 		for (int k = 0; k < party.get(j).length; k++) {
		// 			if (party.get(j)[k] == list.get(i)) {
		// 				canJoin[j] = false;
		// 			}
		// 		}
		// 	}
		// }

		for (int i = 0; i < party.size(); i++) {
			if (canJoin[i]) {
				ans++;
			}
		}

		System.out.println(ans);
	}

	public static void search(int member) {
		for (int i = 0; i < party.size(); i++) {
			if (!canJoin[i]) {
				continue;
			}
			for (int j = 0; j < party.get(i).length; j++) {
				if (party.get(i)[j] == member) {
					canJoin[i] = false;
					for (int searchMember : party.get(i)) {
						if (searchMember != member) {
							search(searchMember);
						}
					}
				}
			}
		}
	}
}
