//Time Complexity: O(n)
//Space Complexity: O(n)
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : No

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) return null;
        idx = postorder.length -1;
        map = new HashMap<>();
        for(int i = 0; i < postorder.length; i++){
            map.put(inorder[i],i);
        }
        
        return helper(postorder,0,inorder.length-1);
    }
    private TreeNode helper(int [] postorder, int start, int end){
        //
        if(start > end) return null;
        //logic
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        idx--;
        root.right = helper(postorder,rootIdx+1,end);
        root.left = helper(postorder,start, rootIdx -1);
        //root.right = helper(postorder,rootIdx+1,end);
        return root;
    }
}
