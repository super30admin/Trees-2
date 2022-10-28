package s30.trees.trees2;

import s30.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;


//Time Complexity O(n): n being the size of preOrder or inOrder array or the number of nodes
//Space Complexity O(h) height of the resultant tree, logn <= h <= n;

public class BuildTreePostInOrder {
    private int postOrderIndex;
    private int[] postOrder, inOrder;
    private Map<Integer,Integer> numToIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        this.postOrder = postorder;
        this.inOrder = inorder;
        postOrderIndex = postOrder.length-1;
        numToIndex = new HashMap();

        for(int i=0; i < inOrder.length; i++){
            numToIndex.put(inOrder[i],i);
        }

        return buildTree( 0, inOrder.length-1);

    }

    private TreeNode buildTree(int start, int end){

        //base
        if(end < start) return null;


        //process
        int inOrderIndex = getIndex(postOrder[postOrderIndex--]);

        TreeNode node = new TreeNode(inOrder[inOrderIndex]);

        //recurse
        node.right = buildTree(inOrderIndex+1, end);
        node.left =  buildTree(start, inOrderIndex-1);

        return node;

    }

    private int getIndex(int ele){
        return numToIndex.get(ele);
    }

    public static void main(String[] args) {

    }
}
