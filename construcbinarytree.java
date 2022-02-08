//Time Complexity: O(n^2)
//Space Complexity : O(n^2)

//For this solution, we make use of the postorder traversal to find the root and then find the position of the root in the inorder
//traversal. The position of the root gives us the size of the left and the right subtrees and then we recurse on the left and the right subtrees.
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //null
        if(preorder == null || preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        //find index of root inorder
        for(int i = 0; i<inorder.length; i++){
            if(rootVal == inorder[i]){
                rootIdx = i;
                break;
            }    
        }
          
        int [] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int [] preLeft = Arrays.copyOfRange(preorder, 1, rootIdx +1);
        int [] inRight = Arrays.copyOfRange(inorder, rootIdx +1, inorder.length);
        int [] preRight = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}

//Time Complexity: O(n)
//Space Complexity: O(n)

class Solution {
    HashMap<Integer, Integer> map;
    int idx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i],i);
        }
        return helper (preorder, inorder, 0, inorder.length -1);
        
    }
    private TreeNode helper (int[] preorder, int[] inorder, int start,int end){
        //base
        if(start > end) return null;
        
        //logic
        int rootval = preorder[idx];
        idx++;
        TreeNode root = new TreeNode(rootval);
        
        int rootidx = map.get(rootval);
        root.left = helper(preorder, inorder, start, rootidx -1);
        root.right = helper(preorder, inorder, rootidx+1, end);
        return root;
    }
}