//Time Complexity O(N) and Space Complexity O(N)
class Solution {
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null && postorder == null) return null;
        if(inorder.length != postorder.length) return null;
        postIdx=postorder.length-1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return helper(map,0,inorder.length-1,postorder);
        
    }

    public TreeNode helper(HashMap<Integer,Integer> map, int start,int end, int[] postorder){

        if(start>end) return null;

        int rootVal = postorder[postIdx];
        postIdx--;
        System.out.println(postIdx);
        TreeNode root = new TreeNode(rootVal);

        int rootIdx = map.get(rootVal);

        root.right = helper(map,rootIdx+1,end,postorder);
        root.left = helper(map,start,rootIdx-1,postorder);
        

        return root;

    }
}




//Sum-to root Time Complexity O(N) and space complexity O(H)
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {

        return helper(root,0,0);
        
    }


    public int helper(TreeNode root, int curr, int sum){
        if(root==null) return 0;

        curr = curr*10+root.val;
        int left = helper(root.left,curr,sum);
        int right = helper(root.right,curr,sum);
        if(root.left==null && root.right==null){
            sum+=curr;
            return sum;
        }
        
        

        return left+right;
    }
}
