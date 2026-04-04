import java.util.*;
import java.lang.Math;

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
        
        
        // root.left.left.left = new Node(1);
        
        // System.out.println(depth(root, 15));
        // System.out.println(height(root, 10));
        System.out.println(leaves(root));
        System.out.println(averageDegree(root));
        System.out.println(search(root, 2));
	}
	
	public static int depth(Node binaryTree, int target){
	    if(binaryTree == null){
	        return -1;
	    }
	    int dist = -1;
	    if ((target == binaryTree.data) || (dist = depth(binaryTree.left, target)) >= 0 || (dist = depth(binaryTree.right, target)) >= 0){
	        return dist + 1;
	    }
	    
	    return dist;
	}
	
	// Calculating Height of binary search tree
	
	public static int height(Node binaryTree, int target){
	    int[] height = {-1};
	    findheight(binaryTree, target, height);
	    return height[0];
	}
	
	public static int findheight(Node binaryTree, int target, int[] height){
	    if (binaryTree == null){
	        return -1;
	    }
	    
	    int leftHeight = findheight(binaryTree.left, target, height);
	    int rightHeight = findheight(binaryTree.right, target, height);
	    
	    
	    int ans = 1 + Math.max(leftHeight, rightHeight);
	    
	    if (binaryTree.data == target) {
	        height[0] = ans;
	    }
	    
	    return ans;
	}
	
	// Calculating Leaves of the Binary tree
	
	public static int leaves(Node root){
	    if(root == null){
	        return 0;
	    }
	    int left = 0, right = 0;
	    if (root.left == null && root.right == null) {
	        return 1;
	    }
	    if(root.left != null){
	        left = leaves(root.left);
	    }
	    if(root.right != null){
	        right = leaves(root.right);
	    }
	    return left+right;
	}
	
	// Caculate Average Degree of Binary Tree by taking help of numberOfNodes
    public static int numberOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int left = numberOfNodes(root.left);
        int right = numberOfNodes(root.right);
        return left + right + 1;
    }	
	
	public static double averageDegree(Node root){
	    int n = numberOfNodes(root);
	    if(n == 0) return 0;
	    return (double) (n-1)/n;
	}
	
	public static int search(Node root, int elem){
	    // Recursion Approach
	   // if(root == null){
	   //     return -1;
	   // }
	   // if (root.data == elem){
	   //     return root.data;
	   // }
	   // else if(root.data > elem){
	   //     return search(root.left, elem);
	   // }
	   // else if(root.data < elem){
	   //     return search(root.right, elem);
	   // }
	    // Looping Approach
	    while(root != null){
	        if(root.data == elem){
	            return root.data;
	        }
	        else if(root.data < elem){
	            root=root.right;
	        }
	        else{
	            root=root.left;
	        }
	    }
	    return -1;
	}
	
	public static boolean insert(Node root, int e){
	    Node toInsert = new Node(e);
	    
	    Node copyRoot = root;
	    // Find the correct position to insert
	    while(copyRoot!=null){
	        if(copyRoot.data == e){
	            return false;
	        }
	        else if (){
	            
	        }
	    }
	    // 3 cases, insert at the left subtree having childs, right subtree having childs, insert directly at leaf
	    
	    
	}
	
	public static boolean delete(Node root, int e){
	    Node copyRoot = root;
	    // Find the target element to delete
	    while(copyRoot!=null){
	    // 3 cases, delete node having 0 child, delete node having 1 child, delete node having 2 children
	        if(copyRoot.data == e){
	            // is a leaf
	            if (copyRoot.left == null && copyRoot.right == null){
	                copyRoot = null;
	            }
	            // having 2 children
	            else if(copyRoot.left != null && copyRoot.right != null){
	                
	            }
	            // having a child
	            else{
	                if (copyRoot.left == null){
	                    copyRoot = copyRoot.right;
	                }
	            }
	        }
	        else if (copyRoot.data>e){
	            copyRoot=copyRoot.left;
	        }
	        else{
	            copyRoot=copyRoot.right;
	        }
	    }
	    
	    
	}
	
}
