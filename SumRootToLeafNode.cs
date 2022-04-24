// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

//iterative way of using stack
public int SumNumbers(TreeNode root) {
        
    if(root == null)
        return 0;
    
    Stack<TreeNode> s = new Stack<TreeNode>();
    Stack<int> numStack = new Stack<int>();
    int sum = 0;
    int num = 0;
    
    while(root != null || s.Count == 0)
    {
        while(root != null)
        {
            s.Push(root);
            num = num*10 + root.val;
            numStack.Push(num);
            root = root.left;
        }
        root = s.Pop();
        num = numStack.Pop();
        if(root.left == null && root.right == null)
            sum = sum + num;
        
        root = root.right;
    }
    return sum;
}


//recursion way
// 1) We traverser inorder
// 2) On traversing left path, we calculate sum and keep in curr sum
// 3) Same thing we will do for right path
// 4) Then in end sum both and return it.

 public int SumNumbers(TreeNode root) {
    
    if(root == null)
        return 0;
    
    return helper(root, 0);
 }

 private int  helper(TreeNode root, int currSum)
{
    if(root == null)
        return 0;
    
    if(root.left == null && root.right == null)
    {
        return currSum * 10 + root.val;
    }
    
    int case1 = helper(root.left, currSum * 10 + root.val);
    int case2 = helper(root.right, currSum * 10 + root.val);
    
    return case1+case2;
}