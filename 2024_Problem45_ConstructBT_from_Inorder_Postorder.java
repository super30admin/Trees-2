//106. https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
//Time Complexity: O(n^2)
//Space Complexity: O(n^2)

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //base case
        if(postorder.length == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int index = 0;

        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val){
                index = i;
                break;
            }
        }

        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length-1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);

        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);

        return root;
    }
}

//Time Complexity: O(n^2)
//Space Complexity: O(n)
class Solution {
    Map<Integer, Integer> map;
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        idx = postorder.length - 1;
        //store all nodes with indexes in map
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    TreeNode helper(int[] postorder, int start, int end) {
        //base case
        if (start > end) return null;

        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);

        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);

        return root;
    }
}