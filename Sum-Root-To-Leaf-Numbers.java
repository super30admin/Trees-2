## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.

Example 1:
Input: root = [1,2,3]
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.

//This is a tree question in which we can use a DFS traversal to compute an answer
//In the below approach I am using an preorder traversal and at every node I am calculating an currentSum and as I am moving down 
//I am multiplying it by 10 and adding root.value
// As it is a traversal and we are doing using an recursion we will follow a format
// base case
// processing 
// left call
// right call
// Also we are maintaining a global variable sum
// Time Complexity : O(n) n = no of nodes
// Space Complexity : O(h) h = height of the tree
class Solution {
    //global variable declaration
    int sum;
    public int sumNumbers(TreeNode root) {
        //Best case condition check
        if(root==null){
            return 0;
        }
        sum=0;
        //function call
        inorder(root,0);
        return sum;

    }
    private void inorder(TreeNode root, int currSum){
        //at the start we are calculating a currsum
        currSum=currSum*10+root.val;
        //base condition check
        if(root==null){
            return;
        }
        //Processing step
        if(root.left == null && root.right==null){
            sum=sum+currSum;
            return;
        }
        //Left subtree call
        inorder(root.left,currSum);
        //Right subtree call
        inorder(root.right,currSum);
    }
}

//The above code will not work if we move the processing step in between both the calls i.e inorder because when we will do a left call and we will hit null
//so the parameters will be null and currsum and when it will calculate the currsum it will be null.val which will be an exception
// If we want to do it with inorder or postorder then we should use below code
//In this we are not calculating current sum at the start instead when we are doing a function call and at the processing step
// Time Complexity : O(n) n = no of nodes
// Space Complexity : O(h) h = height of the tree
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        sum=0;
        inorder(root,0);
        return sum;

    }
    private void inorder(TreeNode root, int currSum){
        if(root==null){
            return;
        }
        
        inorder(root.left,currSum*10+root.val);
        if(root.left == null && root.right==null){
            sum=sum+currSum*10+root.val;
            return;
        }
        inorder(root.right,currSum*10+root.val);
    }
}
//Postorder
// Time Complexity : O(n) n = no of nodes
// Space Complexity : O(h) h = height of the tree
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        sum=0;
        inorder(root,0);
        return sum;

    }
    private void inorder(TreeNode root, int currSum){
        if(root==null){
            return;
        }
        
        inorder(root.left,currSum*10+root.val);
       
        inorder(root.right,currSum*10+root.val);
         if(root.left == null && root.right==null){
            sum=sum+currSum*10+root.val;
            return;
        }
    }
}

//IF we don't want to use a global variable sum then we can just change void to int and take output of left and right calls and add them and return
// Time Complexity : O(n) n = no of nodes
// Space Complexity : O(h) h = height of the tree
class Solution {
    
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
       
        return inorder(root,0);

    }
    private int inorder(TreeNode root, int currSum){
        if(root==null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return currSum*10+root.val;
        }
        int case1 = inorder(root.left,currSum*10+root.val);
       
        int case2 = inorder(root.right,currSum*10+root.val);
         
        return case1+case2;
    }
}

//Iterative version
// In this iterative version we will be maintaining 2 stacks one for node and other for currsum
// When the parameter increases then it becomes cumbersome to maintain  the multiple stacks so the recursive approach is better in such scenarios
// Time Complexity : O(n) n = no of nodes
// Space Complexity : O(h) h = height of the tree
class Solution {
    
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum=0;
        Stack<TreeNode> st=new Stack<>();
        Stack<Integer> currSum=new Stack<>();
        int currNum=0;

        while(root!=null || !st.isEmpty()){
            while(root!=null){
                st.push(root);
                currNum=currNum*10+root.val;
                currSum.push(currNum);
                root=root.left;
            }
            root=st.pop();
            currNum=currSum.pop();
            if(root.left==null && root.right==null){
                sum=sum+currNum;
            }
            root=root.right;
        }
        return sum;
       
        

    }
    
}