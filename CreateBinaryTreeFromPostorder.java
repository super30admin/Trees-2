import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CreateBinaryTreeFromPostorder {
    static int index; // index to iterate over postorder array to finding root
    static HashMap<Integer, Integer> map;
    public static TreeNode buildTreeHashMap(int[] inorder, int[] postorder) {
        int length = postorder.length;
        if(length == 0) return null;

        index = length-1;
        map = new HashMap<>(); //stores inorder values to enable O(1) search
        for(int i=0; i<length; i++) { //O(n) S.C
            map.put(inorder[i], i);
        }

        return buildTreeRecursion(postorder, 0, length-1);
    }

    static TreeNode buildTreeRecursion(int[] postorder, int start, int end) { //O(n) T.C
        if(start > end) return null;

        int root = postorder[index]; //last element in postorder array is the root value
        index--; //decrement the iterator to go over the postorder array

        int rootIndex = map.get(root); //find rootIndex from the inorder array with above root
        TreeNode tree = new TreeNode(root);

        //right child is calculated first from postorder which is from root-index to end
        tree.right = buildTreeRecursion(postorder, rootIndex + 1, end);
        //left child is from beginning to root-Index
        tree.left = buildTreeRecursion(postorder, start, rootIndex - 1);

        return tree;
    }

    public static TreeNode buildTreeArrays(int[] inorder, int[] postorder) { //O(n*n) T.C
        int length = postorder.length;
        if(length == 0) return null;

        int rootIndex = -1; //Initializing root index variable
        int root = postorder[length-1]; //Find the root value as last element in postorder array
        TreeNode tree = new TreeNode(root);

        for(int i=0; i<length; i++) { //O(n) T.C
            if(inorder[i] == root) {
                rootIndex = i; //Found root index
                break;
            }
        }

        //Array deep-copy of new left child inorder array range from O to root-index
        int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, rootIndex); //O(n) S.C

        //Array deep-copy of new right child inorder array range from root-index to end
        int[] inOrderRight = Arrays.copyOfRange(inorder, rootIndex+1, length);

        //Array deep-copy of new left child postorder array range from 0 to root-index value
        //which is also equal to the length of left inorder array at each recursive function
        int[] postOrderLeft = Arrays.copyOfRange(postorder, 0, inOrderLeft.length);

        //Array deep-copy of new right child postorder array range from root-index value to end
        int[] postOrderRight = Arrays.copyOfRange(postorder, inOrderLeft.length, length-1);

        tree.left = buildTreeArrays(inOrderLeft, postOrderLeft);
        tree.right = buildTreeArrays(inOrderRight, postOrderRight);

        return tree;
    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode resultHashmap = buildTreeHashMap(inorder, postorder);
        assert resultHashmap != null;
        System.out.println("The binary tree from using hashmap and pointers is: ");
        printTreeAsArray(resultHashmap);

        TreeNode resultArray = buildTreeArrays(inorder, postorder);
        System.out.println("The binary tree from using arrays deep copy is: ");
        printTreeAsArray(resultArray);
    }

    // Method to print the tree as an array representation
    static void printTreeAsArray(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        LinkedList<Integer> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }

        // Remove trailing nulls to match the array representation
        while (result.getLast() == null) {
            result.removeLast();
        }

        System.out.println(result);
    }
}