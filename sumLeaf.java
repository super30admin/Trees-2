// Time Complexity : O(n)
// Space Complexity :O(h) h-> height of the tree
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        Stack<TreeNode> s=new Stack<>();
        Stack<Integer> num=new Stack<>();
        int temp=0, result=0;
        
        while(root!=null || !s.isEmpty()){
            while(root!=null){
                s.push(root);
                temp=temp*10 + root.val;
                num.push(temp);
                root=root.left;
            }
            
            root=s.pop();
            temp=num.pop();
            if(root.left==null && root.right==null){
                result+= temp;
            }
            root=root.right;
            
            
            
        }
        
        return result;
    }
}