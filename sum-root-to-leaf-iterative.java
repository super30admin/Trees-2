//TC => O(n)
//SC => O(h) => O(logn)
class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        int num = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                num = num*10 + root.val;
                numStack.push(num);
                root = root.left;
            }

            root = stack.pop();
            num = numStack.pop();
            
            if(root.left == null && root.right == null){
                res = res + num;
            }

            root = root.right;
        }

        return res;
    }
}
Console
