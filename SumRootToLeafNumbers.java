//Time Complexity: O(h)
//Space Complexity: O(1)
public class SumRootToLeafNumbers {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int currNum){
        if(root==null){
            return;
        }
        currNum = currNum*10+root.val;
        if(root.left==null && root.right==null){
            result += currNum;
        }

        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}
