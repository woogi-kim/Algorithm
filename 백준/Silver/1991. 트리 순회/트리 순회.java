import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    char value;
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static Node[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new Node[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Node((char) ('A' + i));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bufferedReader.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (left != '.')
                arr[root - 'A'].left = arr[left - 'A'];
            if (right != '.')
                arr[root - 'A'].right = arr[right - 'A'];
        }

        preorder(0);
        sb.append('\n');
        inorder(0);
        sb.append('\n');
        postorder(0);
        sb.append('\n');
        
        System.out.println(sb);
    }

    public static void preorder(int n) {
        sb.append(arr[n].value);
        if (arr[n].left != null)
            preorder(arr[n].left.value - 'A');
        if (arr[n].right != null)
            preorder(arr[n].right.value - 'A');
    }

    public static void inorder(int n) {
        if (arr[n].left != null)
            inorder(arr[n].left.value - 'A');
        sb.append(arr[n].value);
        if (arr[n].right != null)
            inorder(arr[n].right.value - 'A');
    }

    public static void postorder(int n) {
        if (arr[n].left != null) {
            postorder(arr[n].left.value - 'A');
        }
        if (arr[n].right != null) {
            postorder(arr[n].right.value - 'A');
        }
        sb.append(arr[n].value);
    }

}
