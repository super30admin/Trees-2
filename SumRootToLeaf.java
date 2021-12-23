//space complexity: O(H)
//time complexity:O(n)
public class SumRootToLeaf {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum=0;
        helper(root,0);
       return sum;
    }
    public void helper(TreeNode root, int currsum){
        if(root ==null){return;}
        if(root.left==null && root.right==null){
            sum=sum+currsum*10+root.val;
        }
        currsum=currsum*10+root.val;
        helper(root.left,currsum);
        helper(root.right,currsum);
    }
}
