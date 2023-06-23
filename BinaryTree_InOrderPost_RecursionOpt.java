import java.util.HashMap;

public class BinaryTree_InOrderPost_RecursionOpt {

        HashMap<Integer, Integer> mapInNumIdx;

        int PostIdx;

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            if(inorder.length == 0 || postorder.length == 0) return null;

            this.mapInNumIdx = new HashMap<>();

            PostIdx = postorder.length - 1;

            for(int i = 0; i < inorder.length; i++){

                mapInNumIdx.put(inorder[i], i);
            }

            return helper(postorder, inorder, 0, inorder.length - 1);
        }

        public TreeNode helper(int[] postorder, int[] inorder, int start, int end){

            if(PostIdx < 0 || start > end || postorder.length == 0 || inorder.length == 0) {

                return null;
            }

            int rootVal = postorder[PostIdx];

            PostIdx--;

            int rootIdxIn = mapInNumIdx.get(rootVal);

            TreeNode root = new TreeNode(inorder[rootIdxIn]);

            if(start == end){

                return root;
            }

            root.right = helper(postorder, inorder, rootIdxIn + 1, end);

            root.left = helper(postorder, inorder, start, rootIdxIn - 1);

            return root;
        }


/*
Time Complexity = O(n)
Space Complexity = O(n)
*/

}
