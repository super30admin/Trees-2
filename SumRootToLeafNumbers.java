//time - O(n)
//space - O(h)
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        int sum = 0, currSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                currSum = currSum*10+root.val;
                numStack.push(currSum);
                root=root.left;
            }
            root = stack.pop();
            currSum = numStack.pop();
            if(root.left==null && root.right==null){
                sum+=currSum;
            }
            root = root.right;
        }

        return sum;
    }
}