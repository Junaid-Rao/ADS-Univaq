import java.util.*;
import java.lang.Math;

public class Main
{
	public static void main(String[] args) {
        AVLTree root = null; 
        
        // Constructing tree given in the above figure 
        root = insert(root, 10); 
        root = insert(root, 20); 
        root = insert(root, 30); 
        root = insert(root, 40); 
        root = insert(root, 50); 
        root = insert(root, 25); 
        
        /* The constructed AVL Tree would be 
                  30 
                /   \ 
              20     40 
             /  \      \ 
          10   25     50 
        */
        
        
        print(root);
        // root = delete(root, 30); 
        // print(root);
        // root = delete(root, 50); 
        // System.out.println();
        // print(root);
        // root = delete(root, 10); 
        // print(root);
	}
	
	static int height(AVLTree node){
        return (node == null) ? 0 : node.height;
    }
    
    static int balancingFactor(AVLTree node){
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }
	
	public static AVLTree insert(AVLTree root, int e){
	    AVLTree toInsert = new AVLTree(e);
	    
	    if(root == null){
	        return toInsert;
	    }
	    
        if(root.data == e){
            return root;
        }
        else if (root.data > e){
            root.left = insert(root.left, e);
        }
        else if (root.data < e){
            root.right = insert(root.right, e);
        }
        
        // Update height of this ancestor node 
        
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Get the balance factor of this ancestor node
        int bf = balancingFactor(root);

        // If this node becomes unbalanced,
        // then there are 4 cases 

        // Left Left Case  
        if(bf>1 && e<root.left.data){
            return rightRotate(root);
        }

        // Right Right Case 
        if(bf<-1 && e>root.right.data){
            return leftRotate(root);
        }

        // Left Right Case 
        if(bf>1 && e>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case 
        if(bf<-1 && e<root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        // Return the (unchanged) node pointer 
        return root; 
	}
	
	static AVLTree leftRotate(AVLTree avlTree){
	    AVLTree newroot = avlTree.right;
	    AVLTree leftRightPart = newroot.left;
	    
	    newroot.left = avlTree;
	    newroot.left.right = leftRightPart;
	    
	    return newroot;
	}
	
	static AVLTree rightRotate(AVLTree avlTree){
	    AVLTree newroot = avlTree.left;
	    AVLTree rightLeftPart = newroot.right;
	    
	    newroot.right = avlTree;
	    newroot.right.left = rightLeftPart;
	    
	    return newroot;
	}
	
	static AVLTree getSuccessor(AVLTree curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    
    static AVLTree getPredecessor(AVLTree curr) {
        curr = curr.left;
        while (curr != null && curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
	
	public static AVLTree delete(AVLTree root, int e){
	    // Delete Condition
	    if(root==null) {
	        return root;
	    }
	    // 3 cases, delete node having 0 child, delete node having 1 child, delete node having 2 children
	    if(root.data>e) {
            root.left = delete(root.left, e);
        }
        else if (root.data<e) {
            root.right = delete(root.right, e);
        }
        else {
            // is a leaf / having a child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // having 2 children, can be solved with predecessor as well. (rightmost element of left subtree)
            // Successor Logic
            AVLTree succ = getSuccessor(root);
            root.data = succ.data;
            root.right = delete(root.right, succ.data);
            // Predecessor Logic
            // AVLTree pre = getPredecessor(root);
            // root.data = pre.data;
            // root.left = delete(root.left, pre.data);
        }
        if(root == null){
            return root;
        }
        
        // Update height of this ancestor node 
        
        root.height = 1 + Math.max(height(root.left), height(root.right));
        
        int bf = balancingFactor(root);
        if(-1>bf && balancingFactor(root.right)>0){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        else if (-1>bf && balancingFactor(root.right)<0){
            return leftRotate(root);
        }
        else if (1<bf && balancingFactor(root.left)>0){
            return rightRotate(root);
        }
        else if (1<bf && balancingFactor(root.left)<0){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
	    
	    return root;
	}
	
	public static void print(AVLTree root){
        if(root == null) return;
    
        print(root.left);
        System.out.print(root.data + " ");
        print(root.right);
    }
	
}
