

// TC : O(n) // n = nodes in tree
// SC : O(h) // height of the tree

package S30_Codes.Trees_2;
import java.util.Stack;

class Pair{
    TreeNode node;
    int path;

    Pair(TreeNode node, int path){
        this.node = node;
        this.path = path*10+node.val;
    }
}

class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, 0));

        while(!stack.isEmpty()){
            Pair p = stack.pop();
            TreeNode node = p.node;
            int path = p.path;

            if(node.left == null && node.right == null)
                sum += path;
            if(node.left != null)
                stack.push(new Pair(node.left, path));
            if(node.right != null)
                stack.push(new Pair(node.right, path));
        }

        return sum;
    }
}