//Time Complexity: O(n)
//Space Complexity: O(n)
//it runs successfully
//didn't face any problems

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal106LeetCode {


     // Definition for a binary tree node.
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }


        Map<Integer, Integer> map;      //for storing the index of inorder elements
        int postStart;                  //for maintaining the index of postorder array

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            map = new HashMap<>();
            postStart = postorder.length-1;         //starting the index from the end

            for(int i=0; i<inorder.length; i++){

                map.put(inorder[i], i);             //storing the index of inarray elemenet into map

            }

            return valid(0, inorder.length-1, postorder);

        }

        public TreeNode valid(int inStart, int inEnd, int[] postorder){

            if(inStart>inEnd){              //check if start of the inorder array > end of inorder
                return null;                //if so then return null
            }

            int value = postorder[postStart--];     //getting the value from postorder one by one starting from the end
            int index = map.get(value);             //getiing that value's index from the inorder array


            TreeNode node = new TreeNode(value);       //makling a tree from it

            node.right = valid(index+1, inEnd, postorder);      //tree's right node will be between index+1 to the inEnd of a inorder array
            node.left = valid(inStart, index-1, postorder);     //tree's left node will be between  instart and index-1

            return node;                                    //returning the node

        }





//     public TreeNode buildTree(int[] inorder, int[] postorder) {

//         return valid(postorder.length-1, 0, inorder.length-1, postorder, inorder);

//     }

//     public TreeNode valid(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder){


//         if(inStart>inEnd){
//             return null;
//         }

//         int value = postorder[postStart];
//         TreeNode node = new TreeNode(value);

//         int index = 0;
//         for(int i=0; i<inorder.length; i++){
//             if(inorder[i] == value){
//                 index = i;
//             }
//         }


//         node.right = valid(postStart-1, index+1, inEnd, postorder, inorder );
//         node.left = valid(postStart - (inEnd - index + 1), inStart, index-1, postorder, inorder);

//         return node;

//     }

}
