import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    // Creating test nodes
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(2);
        root.left.right = new Node(7);

        root.right.left = new Node(12);
        root.right.right = new Node(20);
        
        genericVisit(root);
        System.out.println();
        bfs(root);
        System.out.println();
        dfs(root);
	}
	
	public static void genericVisit(Node root) {
        if (root == null) return;
    
        LinkedList<Node> S = new LinkedList<>();
        S.add(root);
    
        while (!S.isEmpty()) {
            Node u = S.removeFirst(); // extraction
            System.out.print(u.data + " ");
    
            // add children (order not fixed in generic)
            if (u.left != null) S.add(u.left);
            if (u.right != null) S.add(u.right);
        }
    }
    
    public static void bfs(Node root) {
        if (root == null) return;
    
        Queue<Node> q = new LinkedList<>();
        q.add(root);
    
        while (!q.isEmpty()) {
            Node u = q.poll(); // dequeue
    
            if (u != null) {
                System.out.print(u.data + " ");
                q.add(u.left);
                q.add(u.right);
            }
        }
    }
    
    public static void dfs(Node root) {
        if (root == null) return;
    
        Stack<Node> s = new Stack<>();
        s.push(root);
    
        while (!s.isEmpty()) {
            Node u = s.pop();
    
            if (u != null) {
                System.out.print(u.data + " ");
    
                // IMPORTANT: push right first
                s.push(u.right);
                s.push(u.left);
            }
        }
    }
}
