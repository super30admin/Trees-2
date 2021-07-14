//Time Complexity : O(N)
//Space Complexity : O(H)

class pair
{
    TreeNode root;
    int sum;
    
    public pair(TreeNode root,int sum){
        this.root = root;
        this.sum = sum;
    }
        
    public TreeNode getKey(){
        return this.root;
    }
        public int getValue(){
            return this.sum;
        }
    
}
class Solution {
    public int sumNumbers(TreeNode root) {
        int currsum=0,result = 0;
        if(root == null)
            return 0;
       Stack<pair> tree = new Stack<>(); 
        while(root!=null || !tree.isEmpty())
        {
          while(root!=null){
              currsum = currsum*10 + root.val;
              tree.push(new pair(root,currsum));
              root = root.left;
          }  
            pair p = tree.pop();
            root = p.getKey();
            currsum =p.getValue();
            if(root.right == null && root.left==null)
                result =result + currsum;
            root = root.right;
        }
        return result;
    }
}