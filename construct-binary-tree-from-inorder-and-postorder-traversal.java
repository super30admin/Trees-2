// Time Complexity : O(n) n: number of node
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// traverse on postorder list, find the node in inorder list. it will divide list in two parts.
//keep doing till possible

public TreeNode buildTree(int[] inorder, int[] postorder) {
    int len = postorder.length;
    if(len == 0) return null;
    Map<Integer,Integer> in = new HashMap<>();
    for(int i = 0; i< len;i++) in.put(inorder[i],i);
    return construct(inorder,postorder,in,0,len-1,len-1);
}
private TreeNode construct(int[] inorder, int[] postorder, Map<Integer,Integer> in, int l, int h, int p){
    if(l>h) return null;
    TreeNode root = new TreeNode(postorder[p]);
    int pos = in.get(root.val);
    //System.out.println("pos:" + pos + " l:" + l + " h:" + h + " p:" + p);
    root.left = construct(inorder,postorder,in,l,pos-1,p-(h-pos+1));
    root.right = construct(inorder,postorder,in,pos+1,h,p-1);
    return root;
}


// p as global variable, easier calculation
int p;
public TreeNode buildTree(int[] inorder, int[] postorder) {
    int len = postorder.length;
    if(len == 0) return null;
    Map<Integer,Integer> in = new HashMap<>();
    for(int i = 0; i< len;i++) in.put(inorder[i],i);
    p = len-1;
    return construct(inorder,postorder,in,0,len-1);
}
private TreeNode construct(int[] inorder, int[] postorder, Map<Integer,Integer> in, int l, int h){
    if(l>h) return null;
    TreeNode root = new TreeNode(postorder[p--]);
    int pos = in.get(root.val);
    //System.out.println("pos:" + pos + " l:" + l + " h:" + h + " p:" + p);
    
    root.right = construct(inorder,postorder,in,pos+1,h);
    root.left = construct(inorder,postorder,in,l,pos-1);
    return root;
}