// Time Complexity : O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english

// Your code here along with comments explaining your approach
//Approach: In this approach we add all the values of the inorder as key and their index as values. Then we keep a start and end pointer in the inorder array.
//we can get the root from the postorder. We can find the index of that root form the hashmap. Then we recurese on the right and left of that root.
public class BTfromInAndPost {
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length-1;
        this.map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return helper(postorder, 0 , inorder.length-1);
    }
    private TreeNode helper(int[] postorder,int start,int end){
        if(start>end)return null;
        int rootVal = postorder[idx];
        idx--;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        root.right= helper(postorder, rootIdx+1 , end);
        root.left = helper(postorder, start ,rootIdx-1);
        return root;
    }
}
