//time complexity: O(n)
//space complexity: O(n)
//didn't face any problems
//runs successfully


import java.util.Stack;

public class SumRootToLeafNumber129LeetCode {

     // Definition for a binary tree node.
      public class TreeNode {
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

//create the pair class to store two values in stack
    class Pair{
        TreeNode node;
        int num;

        Pair(TreeNode node, int num){
            this.node = node;
            this.num = num;
        }

        public TreeNode getNode(){
            return node;
        }

        public int getNum(){
            return num;
        }

    }

        //preorder traversal  using stack

        public int sumNumbers(TreeNode root) {

            int sum = 0;                            //total sum
            Stack<Pair> stack = new Stack<>();      //creating stack of pair class
            stack.push(new Pair(root, 0));          //pushing the element into stack with root and  sum till root which is zero

            while(!stack.isEmpty()){                //iterating till stack is empty

                Pair p = stack.pop();               //getting one by one pair class from stack

                TreeNode node = p.getNode();        //getting node from pair

                int currentSum = p.getNum()*10 + node.val;  //calculating the currentSum which is old sum * 10 + current node's value

                if(node.left == null && node.right == null){        //if left and right node is null which means it's a leaf node and adding currentSum to the global sum
                    sum += currentSum;
                }
                if(node.right!=null){           //if right node is not null then push to the stack  with currentSum
                    stack.push(new Pair(node.right, currentSum));
                }

                if(node.left !=null){           //if left is not null then push it to the stack with current sum
                    stack.push(new Pair(node.left, currentSum));
                }

            }
            return sum;                         //return the sum

        }



//         //inorder traversal  using stack

//     public int sumNumbers(TreeNode root) {

//         int sum = 0;
//         Stack<Pair> stack = new Stack<>();
//         int num = 0;

//         while(root!= null || !stack.isEmpty()){

//             //left
//             while(root!= null){
//                 stack.push(new Pair(root,num));
//                 num = num * 10 + root.val;
//                 root = root.left;
//             }

//             Pair p =  stack.pop();
//             root = p.getNode();

//             //current
//             if(root.left == null && root.right == null){
//                 sum += p.getNum()*10 + root.val;
//             }

//             num = p.getNum()*10 + root.val;

//             //right
//             root = root.right;

//         }
//         return sum;

//     }




//        //postorder traversal
//     int sum = 0;

//     public int sumNumbers(TreeNode root) {
//         sum = 0;
//         getSum(root, 0);
//         return sum;
//     }

//     public void getSum(TreeNode root, int num){

//         if(root == null){
//             return;
//         }


//         getSum(root.left, num * 10 + root.val);

//         getSum(root.right, num * 10 + root.val);

//         if(root.left == null && root.right == null){
//             sum += num * 10 + root.val;
//         }

//     }



//     //inorder traversal
//     int sum = 0;

//     public int sumNumbers(TreeNode root) {
//         sum = 0;
//         getSum(root, 0);
//         return sum;
//     }

//     public void getSum(TreeNode root, int num){

//         if(root == null){
//             return;
//         }


//         getSum(root.left, num * 10 + root.val);

//         if(root.left == null && root.right == null){
//             sum += num * 10 + root.val;
//         }


//         getSum(root.right, num * 10 + root.val);

//     }






        // preorder traversal 2

//     public int sumNumbers(TreeNode root) {
//         return getSum(root, 0);
//     }

//     public int getSum(TreeNode root, int num){

//         if(root == null){
//             return 0;
//         }

//         int currentSum = num*10 + root.val;
//         if(root.left == null && root.right == null){
//             return currentSum;
//         }

//         return getSum(root.left, currentSum) + getSum(root.right, currentSum);

//     }



//     // preorder traversal 1
//     int sum = 0;

//     public int sumNumbers(TreeNode root) {
//         sum = 0;
//         getSum(root, 0);
//         return sum;
//     }

//     public void getSum(TreeNode root, int num){

//         if(root == null){
//             return;
//         }

//         int currentSum = num * 10 + root.val;
//         if(root.left == null && root.right == null){
//             sum += currentSum;
//         }

//         getSum(root.left, currentSum );

//         getSum(root.right, currentSum);

//     }
}
