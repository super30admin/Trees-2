class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        Stack<TreeNode>s = new Stack<>();
        Stack<Integer>currsum = new Stack<>();
        int Currsum = 0;
        while(root != null || !(s.isEmpty())){
            while(root!=null){
                s.push(root);  
                Currsum = (Currsum * 10)+root.val;
                currsum.push(Currsum);
                root=root.left;
            }
            root = s.pop();
            Currsum = currsum.pop();
            if(root.left==null && root.right==null){
                sum = sum+Currsum;
            }
        root=root.right;
        }return sum;
    }
}
