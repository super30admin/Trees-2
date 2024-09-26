Time Complexity: O(n)
Space Complexity: O(n) 


class Solution {

   public TreeNode buildTree(int[] inorder, int[] postorder) {

       if(inorder.length==0) return null;
        int x= postorder.length-1;
       TreeNode root= new TreeNode(postorder[x]);

       int index=-1;

       for(int i=0;i<inorder.length;i++)

       {

           if(inorder[i]==root.val)

           {

               index=i;

               break;

           }    

       }

       int[] postleft=Arrays.copyOfRange(postorder,0,index);

       int[] inleft=Arrays.copyOfRange(inorder,0,index);

       int[] postright=Arrays.copyOfRange(postorder,index,postorder.length-1);

       int[] inright=Arrays.copyOfRange(inorder,index+1,inorder.length);

       root.left=buildTree(inleft,postleft);

       root.right=buildTree(inright,postright);

       return root;

   }

}


   //                                \
  //                                  \
 //   direction-->                     \
//postorder is left right root   ------->
 // [9,3,15,20,7]
//[9,15,7,20,3]

//root is last so 3is root
//in inorder divide into two parts based on the root
//9 -> left 15,20,7 --> right
//search for the root ie 20 in preorder and separate intwo two halves
