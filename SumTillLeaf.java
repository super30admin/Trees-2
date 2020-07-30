//Time complexity: O(number of nodes)
//Space Complexity: O(height of tree)
/*Approach
-traversing through each node
-storing the sum till that node into the stack with the node itself in the form of pair
-checking if the node which is popped is leaf we will add its value to the result
-everytime we are storing the node we are calculating the sum at that point
 */
import java.util.Stack;

public class SumTillLeaf {
    public static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }
    class Pair{
        TreeNode node;
        int value;
        public Pair(TreeNode node, int value){
            this.value = value;
            this.node = node;
        }
        public TreeNode getNode(){
            return this.node;
        }
        public int getValue(){
            return this.value;
        }
    }
//1
    public int sumNumbers(TreeNode root) {
        Stack<Pair> stk = new Stack<>();
        int currSum=0;
        int result = 0;
        while(root!= null || !stk.isEmpty()){
            while(root != null){
                currSum = currSum*10+root.val;
                stk.push(new Pair(root,currSum));
                root = root.left;
            }
            Pair p = stk.pop();
            root = p.getNode();
            currSum = p.getValue();
            if(root.left == null && root.right == null){result+= currSum;}
            root = root.right;
        }
        return result;
    }
//2
/*No need of pair for this, passing parameters that needs to be updated to the helper function
*/
public int sumNumbersRecursive(TreeNode root) {
    return helper(root,0);
}
private int helper(TreeNode root, int currSum){
    if(root == null) return 0; //base
    if(root.left == null && root.right == null){return currSum *10 + root.val;}
    int left = helper(root.left,currSum * 10 + root.val);
    int right = helper(root.right,currSum * 10 + root.val);
    return left + right;
}


    public static void main(String args[]) {
        SumTillLeaf obj = new SumTillLeaf();
        TreeNode root = new TreeNode(5);
        root.left=new TreeNode(4);
        root.left.left= new TreeNode(2);
        root.left.right= new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left=new TreeNode(7);
        root.right.right=new TreeNode(1);
 
        System.out.println(obj.sumNumbers(root));
        System.out.println(obj.sumNumbersRecursive(root));

    }
}