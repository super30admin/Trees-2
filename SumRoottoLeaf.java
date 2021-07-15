
class pair{
    TreeNode root;
    int sum;

public pair(TreeNode root, int sum){
    this.root = root;
    this.sum = sum;
}
public TreeNode getKey(){
    return this.root;
}
public int getValue(){
    return this.sum;
}
}
public class SumRoottoLeaf {
	public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        Stack<pair> stack = new Stack<>();
        int currSum = 0, result = 0;
        while(root != null && !stack.isEmpty()){
            while(root != null){
                currSum = currSum*10 + root.val;
                stack.push(new pair(root, currSum));
                root = root.left;
            }
            pair p = stack.pop();
            root = p.getKey();
            currSum = p.getValue();
            if(root.left == null && root.right == null)
                result += currSum;
            root = root.right;                        
        }
        return result;
        
        
    }

}
