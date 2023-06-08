// Time Complexity:           O(n)
// Space Complexity:          O(n+h)
// where n is number of nodes in tree, h is height of the tree
// Yes, this code ran successfully
// No, I didn't face any problem in this problem statement


import java.util.Stack;

class SumRootToLeaf {

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode node, int num) {

        if(node == null) {
            return 0;
        }

        int currNum = num * 10 + node.val;               // updating current level sum every time

        if(node.left == null && node.right == null) {    // if it is leaf node
            return currNum;                              // returning current level sum
        }

        return sumNumbers(node.left, currNum)            // adding sum from children passing current level sum
                + sumNumbers(node.right, currNum);
    }

}



// ****************************** Another Approach ******************************
//public class SumRootToLeaf {
//    private int sum;
//
//    public int sumNumbers(TreeNode root) {
//        sum = 0;
//        sumNumbers(root, 0);
//        return sum;
//    }
//
//    private void sumNumbers(TreeNode node, int num) {
//
//        if(node == null) {
//            return;
//        }
//
//        int currNum = num * 10 + node.val;                 // updating current level sum every time
//
//        if(node.left == null && node.right == null) {      // if this is leaf node
//            sum += currNum;                                // updating "sum" variable
//            return;
//        }
//
//        sumNumbers(node.left, currNum);                    // else passing current level sum to children
//        sumNumbers(node.right, currNum);
//    }
//}



// ****************************** Inorder Iterative Approach ******************************
//class Pair {
//    private TreeNode node;
//    private int num;
//
//    Pair(TreeNode node, int num) {
//        this.node = node;
//        this.num = num;
//    }
//
//    public TreeNode getNode() {return node;}
//    public int getNum() {return num;}
//}
//
//public class SumRootToLeaf {
//    public int sumNumbers(TreeNode root) {
//
//        int sum = 0;
//        int num = 0;
//        Stack<Pair> stack = new Stack<>();
//
//        while(root!=null || !stack.isEmpty()) {
//            while(root!=null) {
//                stack.push(new Pair(root, num));
//                num = num*10 + root.val;
//                root = root.left;
//            }
//
//            Pair pair = stack.pop();
//            root = pair.getNode();
//            num = pair.getNum()*10 + root.val;
//
//            // process left child
//            if(root.left == null && root.right == null) {       // if it is leaf node
//                sum += num;                                     // updating "sum" variable
//            }
//
//            root = root.right;
//        }
//        return sum;
//    }
//}