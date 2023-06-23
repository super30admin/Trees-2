import java.util.Arrays;

public class BinaryTreeInPostRecursion {


        public TreeNode buildTree(int[] inorder, int[] postorder) {

            int il = inorder.length;
            int pl = postorder.length;

            if(pl == 0 || il == 0) return null;

            int rootVal = postorder[pl - 1];

            TreeNode root = new TreeNode(rootVal);

            if(pl == 1) {

                return root;
            }

            int rI = -1;

            for(int i = 0; i < il; i++) { // O(n)

                if(inorder[i] == rootVal) {

                    rI = i;
                    break;
                }
            }

            int[] inLeft = Arrays.copyOfRange(inorder, 0, rI); // O(n)

            int[] inRight = Arrays.copyOfRange(inorder, rI+1, il);

            int[] postLeft = Arrays.copyOfRange(postorder, 0, rI);

            int[] postRight = Arrays.copyOfRange(postorder, rI, pl-1);

            // n recursive calls get called
            root.left = buildTree(inLeft, postLeft);

            root.right = buildTree(inRight, postRight);


            return root;

        }


/*
Time Complexity = O(n^2) - for loop to find root Index and subarray buildup for every recursive call. -> 2n^2
Space Complexity = O(n^2) - creating deep copies at each node
*/

/*
There are two optimizations to be done.
each time {root Index search for loop , subarray construction}
*/

}
