//Time Complexity: O(n)
//Space Complexity: O(n)
public class TreePostOrder {
    static int index = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        index=inorder.length-1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<postorder.length;i++)
            map.put(inorder[i],i);
        return helper(postorder, inorder, 0, postorder.length-1,map);
    }

    public static TreeNode helper(int postorder[], int inorder[], int start, int end, HashMap<Integer, Integer> map){
        if(start>end || index >= inorder.length)
            return null;
        TreeNode tree = null;
        int i=map.get(postorder[index]);
        tree = new TreeNode(inorder[i]);
        index--;
        tree.right = helper(postorder, inorder, i+1, end, map);
        tree.left = helper(postorder, inorder, start, i-1, map);

        return tree;
    }

}
