public class AVLTree{
    int data;
    AVLTree left;
    AVLTree right;
    int height;
    public AVLTree(){
        data = 0;
        left = null;
        right = null;
        height = 1;
    }
    public AVLTree(int d){
        data = d;
        left = null;
        right = null;
        height = 1;
    }
}
