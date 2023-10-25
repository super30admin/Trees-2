//Similar to preorder, only traversing the list from behind
// and changing the call to helper function

//TC: O(n)
//SC: O(n)

//Runs successfully on leetcode

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


public class ConstructTree {

    static class Node {
        int key;
        Node left, right;
 
        // constructor
        Node(int key)
        {
            this.key = key;
            left = null;
            right = null;
        }
    }
    static Node root;
    static Node temp = root;
    static Node prev;

    static void insert(Node temp, int key)
    {
 
        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(temp);
 
        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();
 
            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {

        int[] inorder = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};
        Node temp = buildTree(inorder, postorder);
    }

    public static Node buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        map.put(inorder[i],i);
        return splitTree(postorder,map,postorder.length-1,0,inorder.length-1);
    }

    public static Node splitTree(int [] postorder,Map<Integer,Integer> map,int pix,int ileft,int iright)
    {
        if(pix < 0) return null;
        int rval = postorder[pix];
        int mid = map.get(rval);
        Node root = new Node(rval);
        if(ileft < mid)
            root.left = splitTree(postorder,map,pix-(iright-mid+1),ileft,mid-1);
        if(iright > mid)
            root.right = splitTree(postorder,map,pix-1,mid+1,iright);
            return root;
    }




}