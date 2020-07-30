//Time complexity: O(n)
//Space Complexity: O(n)
/*Approach
- root will always be at the end of postorder traversal
-taking root from postorder and searching it in inorder,left of that index will be left subtree
and right of that index will be right subtree.
- but we also need to find the beginning and end in postorder array
-for left in postorder, postStart will be same but postEnd will be poststart + length of leftsubtree from inorder
-for right in postorder, postStart will be postend of left +1 and end will be postend - 1 which is excluding root

 */
import java.util.HashMap;

public class ConstructTreeInPost{
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inStart = 0;
        int inEnd = inorder.length-1;
        int postStart = 0;
        int postEnd = postorder.length-1;
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(inorder,inStart, inEnd, postorder,postStart, postEnd);
    }
    
    private TreeNode build(int[] inorder,int inStart, int inEnd, int[] postorder, int postStart, int postEnd){
        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        root.left=build(inorder,inStart, index-1, postorder,postStart, postStart+index-(inStart+1));
        root.right=build(inorder,index+1,inEnd,postorder,postStart+index-(inStart+1)+1,postEnd-1);
        return root;
        
    }

    public static void main(String args[]) {
        ConstructTreeInPost obj = new ConstructTreeInPost();
        int[] inorder= new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        System.out.println(obj.buildTree(inorder, postorder).val);
        
    }
}