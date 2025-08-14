//Time complexity: O(n)
//space complexity: O(h)

class Solution {
    //we use idx to keep track of the current root in post array
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //to find the root index in constant time from inorder array
        HashMap<Integer,Integer> map=new HashMap<>();   

        this.idx=inorder.length-1;  //the root is at last in postorder

        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return helper(postorder,0,inorder.length-1,map);

    }
    private TreeNode helper(int postorder[],int start,int end,HashMap<Integer,Integer> map){
        if(start>end) return null;
        
        int rootVal=postorder[idx];
        idx--;

        //get the root index and create the root node
        int rootidx=map.get(rootVal);
        TreeNode root=new TreeNode(rootVal);

        root.right=helper(postorder,rootidx+1,end,map);  
        root.left=helper(postorder,start,rootidx-1,map);  
        
        return root;
    }
}