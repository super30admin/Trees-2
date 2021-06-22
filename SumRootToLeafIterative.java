package Trees2;

import java.util.Stack;

/* Time complexity : o(n) - n is the number of elements in tree
        space complexity: o(h) - Height of the tree. At any given time,there will H nodes inside my recursive stack.
        Did this code run successfully in leetcode : yes
        problems faces : no
        */

public class SumRootToLeafIterative {
    static SumRootToLeafIterative outerClass = new SumRootToLeafIterative();


    public static void main(String[] args) {

        TreeNode tl1 = outerClass.new TreeNode();
        tl1.val = 5;
        TreeNode tl2 = outerClass.new TreeNode();
        tl2.val = 1;
        TreeNode tl3 = outerClass.new TreeNode();
        tl3.val = 9;
        tl3.left = tl1;
        tl3.right = tl2;
        TreeNode tl4 = outerClass.new TreeNode();
        tl4.val = 0;
        TreeNode tl5 = outerClass.new TreeNode();
        tl5.val = 4;
        tl5.left = tl3;
        tl5.right= tl4;
        System.out.println("calling sumNumber");

        int sumOfLeafNodeValues = sumNumbers(tl5);
        System.out.println("sumOfLeafNodeValues : "+sumOfLeafNodeValues);

    }

        public static int sumNumbers(TreeNode root) {
            System.out.println("inside calling sumNumber");
            Stack<Pair> st = new Stack<Pair>();
            int result = 0;
            int currentSum =0;
           while(root != null || !st.empty())
           {
             //  System.out.println("inside while1");
               while(root != null)
               {
                  // System.out.println("inside while2");
                   currentSum = currentSum*10+root.val;
                   Pair p = outerClass.new Pair(root,currentSum);
                   st.push(p);
                   root = root.left;
               }
               Pair p = st.pop();
               root = p.getKey();
               currentSum = p.getValue();

               if(root.left == null && root.right == null)
               {
                   System.out.println("");
                   System.out.print("result: "+result+"currentSum: "+currentSum);
                   result += currentSum;
                   System.out.print("total result: "+result);
                   System.out.println("");
               }
               root = root.right;
           }
           return result;
        }



    public class Pair {
        TreeNode node;
        int value;

       Pair() {
       }

       Pair(TreeNode node,int value) {
           this.node = node;
           this.value = value;
       }

       public TreeNode getKey() {
           return node;
       }

       public int getValue() {
           return value;
       }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
