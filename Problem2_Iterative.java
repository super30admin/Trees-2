//Time Complexity: O(n)
//Space Complexity: O(h), where h is the height of the tree.
//Code run successfully on LeetCode.

public class Problem2_Iterative {

    int num = 0;
    int sum = 0;
    
    public int sumNumbers(TreeNode root) {
        
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        
        while(root!= null || !s.isEmpty()){
            
            while(root != null){
                
                s.push(root);
                num = num *10 + root.val;
                nums.push(num);
                root = root.left;
            }
            
            root = s.pop();
            num = nums.pop();
            
            if(root.left == null && root.right == null){
                sum += num;
            }
            
            root = root.right;
        }
        
        return sum;
    }
}
