//Time: O(n)
//Space: O(2^h) //h is height of the tree
//LeetCode: https://leetcode.com/submissions/detail/578668861/

using System;
using System.Collections.Generic;

namespace SumRootToLeafNumber
{ 
    public class Solution {
    List<int> numsList;
    
    public Solution() {
        numsList = new List<int>();
    }
    public int SumNumbers(TreeNode root) {
            int sum = 0;
            if(root == null) {
                return sum;
            }
            int currNum = 0;
            Helper(root, currNum);
            foreach(int num in numsList) {
                sum +=num;
            }
            return sum;
        }
        
        void Helper(TreeNode root, int currNum) {
            if(root == null) {
                return;
            }
            currNum = (currNum*10) + root.val;
            if(root.left == null && root.right == null) {
                numsList.Add(currNum);
                return;
            }
            Helper(root.left, currNum);
            Helper(root.right, currNum);
        }
    }

  public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

}
