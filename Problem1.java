//Accepted on LT
//Time should order of nodes O(n)

class Solution {
    int idx;
    HashMap<Integer,Integer> map ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.map = new HashMap<>();
        this.idx = postorder.length-1;
       
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);

        }
        return helper(postorder,0,inorder.length-1);
        

    }
    public TreeNode helper(int[] p,int s,int e){
        //base
        if(s>e) return null;

        int r = p[idx];
        if(idx>0){
            idx--;
        }
        
        int ridx = map.get(r);
        TreeNode t = new TreeNode(r);
        t.right = helper(p,ridx+1,e);
        t.left = helper(p,s,ridx-1);
        

        return t;


    }

}