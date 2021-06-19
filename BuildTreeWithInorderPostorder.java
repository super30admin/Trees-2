// Time  - O(n)
// Space  - O(n)
class BuildTreeWithInorderPostorder{
        HashMap<Integer, Integer> map;
        int indexPost;
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if(inorder == null || postorder == null || inorder.length ==0 || postorder.length ==0) return null;
            map = new HashMap<>();
            indexPost = postorder.length-1;

            for(int i=0; i<inorder.length; i++){
                map.put(inorder[i], i);
            }

            return helper(postorder, 0, postorder.length-1);

        }

        private TreeNode helper( int[] postorder, int start, int end){
            //base
            if(start > end) return null;
            //logic
            int rootVal = postorder[indexPost];
            indexPost--;
            TreeNode root = new TreeNode(rootVal);

            int indexIn = map.get(rootVal);
            root.right = helper(postorder, indexIn+1, end);
            root.left = helper(postorder, start, indexIn-1);
            return root;
        }
}