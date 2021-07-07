// 106.

//time - O(n) - number of nodes in tree
//space with recursion stack - O(n) for hashmap and O(h) for recursive stack
//space without recursion stack and hashmap - constant
class Solution {
    
    int current_root;
    HashMap<Integer, Integer> indexMap;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        current_root = postorder.length - 1;
        indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            indexMap.put(inorder[i], i);
        }
        
        return treeBuilder(inorder, postorder, 0, inorder.length - 1);
    }
    
    private TreeNode treeBuilder(int[] inorder, int[] postorder, int start, int end) {
        //base
        if(start > end || current_root < 0)
        {
            return null;
        }
        
        //build tree
        TreeNode root = new TreeNode(postorder[current_root]);
        current_root--;
        
        //find root in inorder
        int index = indexMap.get(root.val);
        
        //recurse
        root.right = treeBuilder(inorder, postorder, index + 1, end);
        root.left = treeBuilder(inorder, postorder, start, index - 1);
        
        return root;
    }
}

//the previous approach with extra arrays
public TreeNode buildTree(int[] inorder, int[] postorder) {
        //base
        if(postorder.length <= 0)
        {
            return null;
        }
        
        //build root 
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        //find root index in inorder
        int index = 0;
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == root.val)
            {
                index = i;
                break;
            }
        }
        
        //recompute inorder postoder for recursive calls
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        
        //recurse
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
