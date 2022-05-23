//Time Complexity: O(n)
//Space Complexity: O(1)

public class SumRootToLeaf {

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


    int sum;
    public int sumNumbers(TreeNode root) {

        if(root == null){
            return sum;
        }
        helper(root,0);
        return sum;

    }

    private void helper(TreeNode root, int currSum){

        //base
        if(root == null){
            return;
        }

        //logic

        //preorder


        if(root.left == null && root.right ==null){
            sum+=currSum*10+root.val;
        }

        helper(root.left,currSum*10+root.val);

        helper(root.right,currSum*10+root.val);



    }
}
