import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.module.FindException;
import java.util.*;

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public void insertNode(Node newNode) {
        if (newNode.value > this.value) {
            if (this.right == null) {
                this.right = newNode;
            } else {
                this.right.insertNode(newNode);
            }
        } else {
            if (this.left == null) {
                this.left = newNode;
            } else {
                this.left.insertNode(newNode);
            }
        }
    }

}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(bf.readLine()));
        while (true) {
            String input = bf.readLine();
            if (input == null || input.equals("")) {
                break;
            }
            Node newNode = new Node(Integer.parseInt(input));
            root.insertNode(newNode);
        }

        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value);
    }
}

