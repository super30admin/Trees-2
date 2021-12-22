//Construct BST from postorder and inorder
//Space complexity : o(n)
//Time complexity : o(n)
public class Problem2 {
    public HashMap<Integer,Integer> map = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder == null || postorder.length==0){
            return null;
        }
        //root will be at the end
        idx=postorder.length-1;
        for(int i=0; i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        
        return helper(postorder,0,postorder.length-1);
    }
    
    private TreeNode helper(int[] postorder, int start, int end){
        if(start>end){
            return null;
        }
        int rootVal = postorder[idx];
        //decrement to get the next root
        idx--;
        //creat root
        TreeNode root = new TreeNode(rootVal);
        //find rootIndex from inorder map
        int rootIndex = map.get(rootVal);
        //recursively create right & left subtree. 
        root.right = helper(postorder,rootIndex+1,end);
        root.left = helper(postorder,start,rootIndex-1);
        return root;
    }
}
