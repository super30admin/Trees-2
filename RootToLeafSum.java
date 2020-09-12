//Iterative implementation of root to leaf sum:
//TC: O(N) N - number of nodes in the tree
//SC: O(H) H - height of the tree at a time. If it is skewed, then it is O(N).

//Stack is used to store curSum and the node. At every point, curSum * 10 is added to node value. 
//Check for leaf node, if yes, add the curSum to total. If not, go ahead with right subtree until a leaf node. 

import java.util.*;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x){
        this.val = x;
    }
}

class Pair{
    TreeNode node;
    int sum;
    public Pair(TreeNode node, int sum){
        this.node = node;
        this.sum = sum;
    }

    public TreeNode getNode(){
        return this.node;
    }

    public int getSum(){
        return this.sum;
    }
}

public class RootToLeafSum {
   

    public static int sumIterative(TreeNode root){
        if(root == null) return 0;
        Stack<Pair> stk = new Stack<>();
        int curSum = 0, total = 0;

        while(!stk.isEmpty() || root != null){
            while(root != null){
                curSum = curSum * 10 + root.val;
                stk.push(new Pair(root, curSum));
                root = root.left;
            }
            Pair p = stk.pop();
            root = p.getNode();
            curSum = p.getSum();
            if(root.left == null && root.right == null){
                total += curSum;
            }
            root = root.right;
        }
        return total;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumIterative(root));

    }
}
