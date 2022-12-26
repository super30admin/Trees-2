import java.util.Stack;

public class SumRootLeaf {
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/

    /*
    * Traverse to child node and multiply the prev node summed value by 10 and add it to current sum value
    * 4 9 5 = 4 -> 40+5-> 490+9
    *Recursively continue the process till  left and right nodes are null return result
    *
    * TC - O(n)
    * SC - O(h) height of the tree
    * */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.left.left = new TreeNode(5);
        System.out.println(sumNumbers(root));
    }
//Iterative Approach
    //TC - O(n)
    //SC - O(h)
public static int sumNumbers(TreeNode root) {
    if (root == null) return 0;
      Stack<TreeNode> st = new Stack<>();
      Stack<Integer> stackInt = new Stack<>();
      int result = 0, num =0;
      while (root!=null || (!st.isEmpty())){
          while (root!=null){
              st.push(root);
              num = num *10 +root.val;
              stackInt.push(num);
              root = root.left;
          }

          root = st.pop();
          num = stackInt.pop();
          if(root.left==null && root.right==null) result = result+num;
          root = root.right;

      }
      return result;
    }




    // Recursion another type
/*
    public static int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        int result = dfs(root,0);
        return result;
    }
    private static int dfs(TreeNode root, int num) {
        if(root == null) return 0;
        if(root.left==null && root.right==null)
            return num*10+root.val;

        int case1 = dfs(root.left,num*10+root.val);
        int case2 = dfs(root.right,num*10+root.val);
        return case1+case2;
    }
*/

    //DFS Recursion
    /*
    static int result;
    public static int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        dfs(root,0);
        return result;
    }

    private static void dfs(TreeNode root, int num) {
        if(root == null) return;
        dfs(root.left,num*10+root.val);
        if(root.left==null && root.right==null) result = result+ num*10+root.val;
        dfs(root.right,num*10+root.val);
    }
*/
}
