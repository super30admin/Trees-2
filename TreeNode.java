public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    TreeNode getNode(int data) {
        return new TreeNode(data);
    }

    //[1,2,3]
    public TreeNode getSample() {
        TreeNode root = getNode(1);
        TreeNode node2 = getNode(2);
        TreeNode node3 = getNode(3);
        root.left = node2;
        root.right = node3;
        return root;
    }

    //[4,9,0,5,1]
    public TreeNode getSampleTwo() {
        TreeNode root = getNode(4);
        TreeNode node9 = getNode(9);
        TreeNode node0 = getNode(0);
        TreeNode node5 = getNode(5);
        TreeNode node1 = getNode(1);
        root.left = node9;
        root.right = node0;
        node9.left = node5;
        node9.right = node1;
        return root;
    }
       //[1,0]
       public TreeNode getSampleThree() {
        TreeNode root = getNode(1);
        TreeNode node0 = getNode(0);
        root.left = node0; 
        return root;
    }
    

}
