//Prob-1: BuildTreeFromInAndPostArray
// Time Complexity : O(n^2) where n is the number of elmnts in the inorder array.
// Space Complexity : O(h*n) h represents height of stack and n is the number of elements in both the arrays
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
            if(postorder.length == 0) return null;

                    TreeNode root = new TreeNode(postorder[postorder.length-1]); // root will be always the last element of the postOrder array

                    int index = -1; // index of the current root in the inorder array
                    for(int i=0; i < inorder.length; i++){
                        if(inorder[i] == root.val){
                    index =i; break;
                }
            }

            int[] preLeft = Arrays.copyOfRange(postorder, 0, index); 
            int[] preRight = Arrays.copyOfRange(postorder, index, postorder.length-1); 
            int[] inLeft = Arrays.copyOfRange(inorder, 0, index); 
            int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length); 

            root.left = buildTree(inLeft, preLeft);
            root.right =  buildTree(inRight, preRight);
            return root;
    }
}

//Prob-2: sum-root-to-leaf-numbers/
// Time Complexity : O(n) where n is the number of elmnts in the tree
// Space Complexity : O(h) h represents height of stack 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Iterative solution
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        
        Stack<Pair<TreeNode, Integer>> s = new Stack();
        int curSum=0;
        int result=0;
        while(root != null || !s.isEmpty()){
            while(root != null){ // going left till the leaf node
                curSum = curSum*10 +root.val;
                s.push(new Pair(root, curSum));
                root = root.left;
            }
            
            Pair pr = s.pop();
            root =(TreeNode) pr.getKey();
             curSum = (int)pr.getValue();
            if(root.left == null && root.right == null){ // when both are null, it is a leaf node
                result+= curSum;
            }
            root = root.right; 
             
        }
        
        return result;
    }
}

