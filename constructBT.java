// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class constructBT {
        //Global scope so other functions can access it
        HashMap<Integer, Integer> map;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            map = new HashMap();
            int[] postArr = new int[] {postorder.length - 1};
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return arrayToTree(postorder, 0, postorder.length - 1, postArr);
        }
        private TreeNode arrayToTree(int[] postorder, int left, int right, int[] postArr) {
            if (left > right) return null;
            int value = postorder[postArr[0]];
            postArr[0] = postArr[0] - 1;
            TreeNode root = new TreeNode(value);
            int index = map.get(value);
            root.right = arrayToTree(postorder, index + 1, right, postArr);
            root.left = arrayToTree(postorder, left, index - 1, postArr);
            return root;
        }
}
