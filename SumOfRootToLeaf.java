import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// we recursively traverse the tree from root to the child nodes
// then store the result obtained till that node, which will be a local variable
// push the result into the final resultant array when encountering a leaf node

//Time complexity: O(n)
//Space Complexity: O(h) at a given time, the auxillary stack will consist of 
// nodes from root to leaf node
// works on leetcode

public class SumOfRootToLeaf {

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

    static int result;
    public static void main(String[] args)
    {
        int[] array = {5,1,4,3,6};
        Node root = new Node(array[0]);

        for (int i = 1; i < array.length-2; i++)
        {
             insert(root, i);
        }

        sumRootLeaf(root,0);
        System.out.println(result);
    }

    public static void sumRootLeaf(Node root, int sum)
    {
        if(root == null)   return;

        sum = sum*10 + root.key;
        if(root.left == null && root.right == null)
        {
            result += sum;
        }

        sumRootLeaf(root.left, sum);
        sumRootLeaf(root.right, sum);
    }
    
}
