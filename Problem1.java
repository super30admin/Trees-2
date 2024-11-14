// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Problem1 {
    Map<Integer,Integer> inOrderMap ;
    int indx = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        this.indx = postorder.length-1;
        //return buildTreeHelper(inorder,postorder);
        return buildTreeOptimized(postorder,0,postorder.length-1);
    }
    // SC : O(2N^2) = O(N^2) making 2n copies of array n times
    // TC : O(N^2)
    public TreeNode buildTreeHelper(int[] inorder,int[] postorder ) {
        // base condition
        if(postorder.length==0){
            return null;
        }

        int rootVal = postorder[postorder.length-1];
        int rootIndex = -1;
        //finding index of root in inorder array
        //O(N) to find the root
        for(int i=0;i<inorder.length;i++){
            if( inorder[i] == rootVal){
                rootIndex= i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        //left of root in inorder is left child
        // 0 to rootIndex-1

        // each of getting copy of this array takes O(2N) time complexity
        // SC : O(2N^2) = O(N^2) making 2n copies of array n times
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        //right of root in inorder is right child
        //rootIndex +1 to inorder.length-1

        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder, 0, inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder, inorderLeft.length, postorder.length-1);

        root.left = buildTreeHelper(inorderLeft,postorderLeft);
        root.right = buildTreeHelper(inorderRight,postorderRight);

        return root;

    }

    //TC: O(N)
    //SC : O(N)
    public TreeNode buildTreeOptimized(int[] postorder,int st,int end) {
        // base condition
        if(end<st ){
            return null;
        }

        int rootVal = postorder[this.indx];

        int rootIndex = inOrderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        this.indx --;
        root.right = buildTreeOptimized(postorder,rootIndex+1,end);
        root.left = buildTreeOptimized(postorder,st,rootIndex-1);


        return root;

    }