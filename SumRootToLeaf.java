class Solution {
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int sumNumbers(TreeNode root) {
        
        ArrayList<Integer> res = new ArrayList<>();
        dfs (root,0,res);
        int sum = 0;
        for (int i : res){
            sum = sum+i;
        } 
        return sum;
    }

    public void dfs(TreeNode node, int cur, ArrayList<Integer> res){
        if (node == null){
            return;
        }
        // leaf nodes are always checked on the parent node
        // by doing node.left == null && node.right == null
        cur = (cur*10)+ node.val;
        if (node.left == null && node.right == null){
            res.add (cur);
            return;
        }
        dfs(node.left,cur, res);
        dfs(node.right,cur, res);
    }
