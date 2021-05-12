//Time : O(n) : n=length of array
//space : O(h) : h = height of tree created
// did it run successfully on leetcode: yes
class ConstructBinaryTreeWithPosIn {
    //global index for postorder array
    int posInd;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode  root;
        posInd = inorder.length-1;
        //helper method to create the BT
        root = helper(postorder,inorder, 0, inorder.length-1);
        //returning the root of tree
        return root;
    }
    public TreeNode helper(int[] pos, int[] in, int l, int r){
        //left and right boundary crosses
        if(l>r){
            //decreement posInd since it is not a valid node in posorder array
            posInd++;

            return null;
        }
        //create a node with value at posInd as root
        TreeNode root = new TreeNode(pos[posInd]);

        //one element in sub-array
        if(l==r) return root;
        //get index of root in inorder array
        int inInd = getIndex(in, pos[posInd]);
        //set value at next posorder array as next root
        posInd--;
        //right child of root
        root.right =  helper( pos,  in, inInd+1, r);

        //set value at next posorder array as next root
        posInd--;
        //left child of root
        root.left =  helper(pos, in, l, inInd-1);


        return root;
    }

    //return index of a value in array
    public int getIndex(int[] in, int val){
        for(int i=0; i<in.length; i++){
            if(in[i] ==val) return i;
        }
        return -1;
    }
}