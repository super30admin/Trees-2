/*        4
          /\
         9  0
        /\
       5  1

1. For every node, we keep the node and the value till that point. So for 4, we store [4,4], for 9, we store [9,49], for 5, we store [5, 495]
2. If the node is a leaf node, we get its value from the stack, and add it to the global sum
3. If its not a leaf, and we are coming back to it again, for example, after traversing 4->9->5, 1 is added when 9 is popped from the stack.
4. At that point, we restore the currentNum to the value read from stack, which would be 49. And while exploring 1's left node, it's value will be added to the '49' to
become '491'

Time complexity: O(N)
Space complexity: O(H)
* */

public class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        inorder(root,0);
        return result;
    }

    //This currentNum is maintained at the local level in the stack. Just the way we manually stored it in our iterative solution
    public void inorder(TreeNode root, int currentNum)
    {
        //base
        if(root==null) return;
        if(root.left==null && root.right==null)
        {
            result+=currentNum*10+root.val;
            return;
        }
        //logic
        currentNum = currentNum*10+root.val;
        inorder(root.left, currentNum);
        inorder(root.right, currentNum);
    }
}