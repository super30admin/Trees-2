Executed in leet Code - No, Not working
time Complexity- o(n)
space complexity-o(n)

class Solution {
    public TreeNode buildTree(int[] inOrder, int[] postorder) {
          for(int i=0;i<inOrder.length;i++){
            treeMap.put(inOrder[i],i);
        }
        index=postorder.length-1;
        return buildTreeHelper(inOrder,postorder,0,inOrder.length-1); 
    }
     HashMap<Integer,Integer> treeMap = new HashMap<Integer,Integer>();
    int index;
    
    TreeNode buildTreeHelper(int[]inOrder, int[] preOrder, int startIndex,int endIndex){
        
        if(endIndex<startIndex || index<0) return null;
        
        TreeNode currRoot = new  TreeNode(preOrder[index]); 
        int rootIndex = treeMap.get(preOrder[index]);
        index--;
        currRoot.left = buildTreeHelper(inOrder,preOrder,startIndex,rootIndex-1);
        currRoot.right = buildTreeHelper(inOrder,preOrder,rootIndex+1,endIndex);

        return currRoot;
    }
 
}
