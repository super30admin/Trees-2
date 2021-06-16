
//Time complexity - O(N)
// Space complexity - O(N)


class Solution {

    int postIndex;
    HashMap<Integer, Integer> inOrderIndexMap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;
        inOrderIndexMap = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {

            inOrderIndexMap.put(inorder[i],i);

        }

        return buildTree(postorder,0,postorder.length - 1);



    }

    private TreeNode buildTree(int[] postorder, int left, int right) {

        // No elements then return
        if(left > right) return null;

        // select root which would be the last element of postorder array
        int root_val = postorder[postIndex--];
        TreeNode root = new TreeNode(root_val);

        //build right tree min changes max does not change
        root.right = buildTree(postorder, inOrderIndexMap.get(root_val) + 1, right);

        //build left tree min does not change; max changes
        root.left = buildTree(postorder,left,inOrderIndexMap.get(root_val) - 1);

        return root;




    }

}