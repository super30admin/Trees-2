import java.io.Console;

import javax.swing.tree.TreeNode;

//Idea is to calculate the running sum starting from root to the leaf and return sum of all such paths

//Time Complexity:O(n)
//Space Complexity:O(n)
public class Sumtillleaf {
     public int sumNumbers(TreeNode root) {
        return calc(root,0);
    }
    public int calc(TreeNode root , int sum)
    {
        int left = 0, right = 0;
        if(root.left==null && root.right==null)
        {
            return sum*10+root.val;
        }
        if(root.left!=null)
        {
             left =  calc(root.left,sum*10+root.val);
             
        }
        if(root.right!=null)
        {
             right =  calc(root.right,sum*10+root.val);
            
        }
        return left+right;
       
    }
}
