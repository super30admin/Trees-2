/*
Time Complexity: O(N) — You visit every node exactly once.
Space Complexity: O(H) — Due to recursion stack, where H is the height of the tree. In worst case (skewed tree), it becomes O(N).
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class SumRootToLeafNumbers_LC_129 {

//void conditional recursion
    int result;
    public int sumNumbers(TreeNode root) {
       //void based recursion
        /*
        this.result = 0;
        helperVoid(root, 0);
        return result; */
        //Int based recursion
        return helperInt(root, 0);
    }

    private void helperVoid(TreeNode root,int curr){
        //base case
        if (root == null) return;

        curr = curr * 10 + root.val;
        if(root.left ==null && root.right ==null) { //this is leaf node
            result += curr;
        }

        //logic
        helperVoid(root.left, curr);
        helperVoid(root.right, curr);
    }


    //int conditional recursion
    private int helperInt(TreeNode root,int curr){
        //base case
        if (root == null) return 0;

        curr = curr * 10 + root.val;
        if(root.left ==null && root.right ==null) { //this is leaf node
            return curr;
        }

        //logic
    /* int left = helperInt(root.left, curr);
     int right = helperInt(root.right, curr);
     return left+ right;
      - below is more elegant way but this is okay too as a beginner */

        return helperInt(root.left,curr) + helperInt(root.right,curr);
    }
}

