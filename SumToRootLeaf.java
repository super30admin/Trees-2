/*
Time COmplexity - O(N)
Space COmplexity - O(N)
*/
class Solution {
    class Pair{
        TreeNode node;
        int val;
        public Pair(TreeNode node, int val){
            this.node = node;
            this.val = val;
        }
        
        public TreeNode getKey(){
            return node;
        }
        
        public int getValue(){
            return val;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        Stack<Pair> stack = new Stack<>();
        int sum = 0;
        int curr = 0;
        while(root!= null || !stack.isEmpty()){
            while(root!=null){
               curr = curr*10 + root.val;
               Pair pair = new Pair(root,curr);
               stack.push(pair); 
               root = root.left;
            }
            Pair p = stack.pop();
            TreeNode node = p.getKey();
            curr = p.getValue();
            if(node.left == null && node.right == null) {
                sum += curr;
            }
            if(node.right != null){
                root = node.right;
            }
        }
        return sum;
    }
}