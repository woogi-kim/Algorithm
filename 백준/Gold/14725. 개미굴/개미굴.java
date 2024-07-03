import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static int n;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        Node root = new Node();

        for (int i = 0; i < n; i++) {
            String[] s = bf.readLine().split(" ");
            int depth = Integer.parseInt(s[0]);
            Node cur = root;

            for (int j = 0; j < depth; j++) {
                if (!cur.children.containsKey(s[j + 1])) {
                    cur.children.put(s[j + 1], new Node());
                }
                cur = cur.children.get(s[j + 1]);
            }
        }

        printNodes(root, "");
        System.out.println(sb);
    }

    public static void printNodes(Node node, String bar) {
        Object[] keys = node.children.keySet().toArray();
        Arrays.sort(keys);

        for (int i = 0; i < keys.length; i++) {
            sb.append(bar).append(keys[i]).append('\n');
            printNodes(node.children.get(keys[i]), bar + "--");
        }
    }
}

class Node {
    HashMap<String, Node> children = new HashMap<>();
}