// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//1.Root to Leaf path Sum 2
//Time Complexity -> O(n)
//Space Complexity -> O(height)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
         List<Integer> li = new ArrayList();
        helper(root,currSum,targetSum,li);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum,List<Integer> path){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum,path);
        helper(root.right,currSum,targetSum,path);

        //backTrack
        path.remove(path.size() -1);

        
    }
}

class Solution {
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
        path = new ArrayList();
        helper(root,currSum,targetSum);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum);
        helper(root.right,currSum,targetSum);

        //backTrack
        path.remove(path.size() -1);

        
    }
}

class Solution {
    //Using global path list
    List<List<Integer>> result;
    List<Integer> path;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
        path = new ArrayList();
        helper(root,currSum,targetSum);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        path.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(new ArrayList(path));
            }
        }
        //recurse
        helper(root.left,currSum,targetSum);
        helper(root.right,currSum,targetSum);

        //backTrack
        path.remove(path.size() -1);

        
    }
}

class Solution {
    //Using Path list as a function variable but it will be always same as it is pass by reference
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList();
        int currSum = 0;
         List<Integer> li = new ArrayList();
        helper(root,currSum,targetSum,li);
        return result;
        
    }

    private void helper(TreeNode root,int currSum,int targetSum,List<Integer> path){
        //base
        if(root == null) return;

        //action
        currSum = currSum + root.val;
        List<Integer> li = new ArrayList(path); //Creating a deep copy
        li.add(root.val);
        if(root.left == null && root.right == null){
            if(currSum == targetSum){
                result.add(li);
            }
        }
        //recurse
        helper(root.left,currSum,targetSum,li);
        helper(root.right,currSum,targetSum,li);

        
    }
}

//Create tree From inorder and preorder
//Time Complexity -> O(n^2)
//Space Complexuty -> O(1) as there is no extra space
class Solution {
    //Brute Force
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length) return null;
        if(preorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for(int i = 0;i<inorder.length;i++){
            if(inorder[i] == rootVal){
                rootIdx = i; //get the value of rootIdx from inorder traversal
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder,0,rootIdx-1 + 1);
        //Copy of Range here will copy from 0th index exclusive and lastIndex is always +1  the index till which we desire the array to be copied
       int[]  inRight = Arrays.copyOfRange(inorder,rootIdx+1,inorder.length - 1 +1); //inRight is array elements after root
       int[] preLeft = Arrays.copyOfRange(preorder,1,1 + inLeft.length - 1 + 1); //copy elements from 1 to inleft.length + 1 but since we are dealing with indices we will do -1 and then copy of range takes +1 indice thats why 1 + inLeft.length -1 +1
       int[] preRight = Arrays.copyOfRange(preorder ,inLeft.length+1,preorder.length);
       //copy of elements from inleft.length + 1 till end of preorder array but since we are dealing with indices we will do -1 and then copy of range takes +1 indice thats why 1 + inLeft.length -1 +1
       root.left = buildTree(preLeft,inLeft); //Build left tree of root from preLeft and inLeft
       root.right = buildTree(preRight,inRight); // Buidl right tree of root from preRight and inRight

       return root;

        
    }


}

//2nd Solution
//Time Complexity - >O(n)
//Space Complexity -> O(n) //for hashMap + O(h) -> recursive stack
class Solution {
    //Using Recursion
   int preIdx;
   Map<Integer,Integer> map ; 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      this.preIdx = 0;  
      this.map = new HashMap();  
      if(preorder.length  == 0 || preorder.length!=inorder.length) return null;
      
      for(int i=0;i<inorder.length;i++){
          map.put(inorder[i],i);
      }

      return helper(preorder,inorder,0,inorder.length-1); //Calling helper function to create a tree from inorder array from the whole inorder array
        
    }

    private TreeNode helper(int[] preOrder,int[] inOrder,int startIdx,int endIdx){
        //Base Case
        if(startIdx > endIdx) return null; //When StartIdex > endIdx it means it is not valid hence there will be TreeNode Creation

        //Recursive
        int rootVal = preOrder[preIdx];
        preIdx ++;
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal); 
        root.left = helper(preOrder,inOrder,startIdx,rootIdx-1); //Recursive call to create left subtree from start to rootIdx - 1
        root.right = helper(preOrder,inOrder,rootIdx + 1,endIdx); //Recursive call to create right binary tree from rootIdx +1 to end

        return root;


    }


}

