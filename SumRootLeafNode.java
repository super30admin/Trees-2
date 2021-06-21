// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
class Pair{
    TreeNode node;
    int value;
    public Pair(TreeNode node, int value){
        this.node = node;
        this.value = value;
    }
    public TreeNode getKey() {
        return this.node;
    }    
    public int getValue() {
        return this.value;
    }      
}

class SumRootLeafNode {    
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Stack<Pair> st = new Stack<>();
        int result = 0 ; int currSum = 0;
        while(root!=null || !st.isEmpty()){
            while(root!=null){
                currSum = 10 * currSum + root.val;
                st.push(new Pair(root, currSum));
                root = root.left;
            }
            Pair p = st.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root.left == null && root.right == null){
                result += currSum;
            }
            root = root.right;
        }
        return result;
    }
}
