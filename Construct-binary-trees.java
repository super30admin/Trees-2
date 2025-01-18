// TC: O(N
//SC: O(N) - inorder map and recursive stack
class Solution {
    HashMap<Integer,Integer> inOrderMap;
    int postOrderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIdx = postorder.length-1;
        inOrderMap = new HashMap<>();
        // System.out.println("in " + postOrderIdx);
        for(int i=0;i < inorder.length; i++){
            inOrderMap.put(inorder[i],i);
        }
        return arrayToTree(postorder,0,inorder.length-1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right){
        if(left > right)return null;
        // System.out.println("out "+ postOrderIdx);
        int rootValue = postorder[postOrderIdx--];
        TreeNode root = new TreeNode(rootValue);
        root.right = arrayToTree(postorder, inOrderMap.get(rootValue)+1, right);
        root.left = arrayToTree(postorder, left, inOrderMap.get(rootValue)-1);
        return root;
    }
}