/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
Algorithm : Using Inorder traversal : Most common traversal. Can be done with other traversal also.

SC: O(H)
TC: O(n)

**/

//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    class Pair{
        TreeNode node;
        int value;
        
        public Pair(TreeNode node, int value){
            this.node = node;
            this.value = value;
        }
        public TreeNode getKey(){
            return this.node;
        }
        public int getValue(){
            return this.value;
        }
    }
    public int sumNumbers(TreeNode root) {
        //Blind line
        if(root==null) return 0;
        
        Stack<Pair> st = new Stack<>();
        int result=0, curSum=0;
        
        while(root != null || !st.isEmpty()){
            
            while(root != null){
                curSum = curSum * 10 + root.val;
                st.push(new Pair(root,curSum));
                root = root.left;
            }
            
            Pair p = st.pop();
            root = p.getKey();
            curSum = p.getValue();
            
            //Check if leaf node
            if(root.left == null && root.right == null){
                result += curSum;
            }
            root = root.right;
        }
       return result; 
    }
}



/**
Recursive Solution :
class Solution {
public int sumNumbers(TreeNode root){
if(root == null) return 0;
return helper(root,0);
 }

private int helper(TreeNode root, int curSum){
//Base
if(root == null) return 0;

//Logic
if(root.left == null && root.right == null){
return curSum * 10 + root.val;
}

int left = helper(root.left, curSum * 10 + root.val);
int right = helper(root.right, curSum * 10 + root.val);

return left + right;
}

}

**/

