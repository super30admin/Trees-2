//Time Complexity: O(n), populating hashmap: O(n), recursive function calld on left and right side, its called n times. so n+n=2n. O(n)
//Space Complexity: O(n), not creating separate arrays, only hashmap O(n) and recursive stack space O(h), [in worst case h=n]. so it becomes 2n
//Running on leetcode: yes
class Solution {
    //class variable hashmap containing the inorder array for index lookup. K,V:element,index
    HashMap<Integer,Integer> map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder==null || inorder.length==0)
        {
            return null;
        }
        map = new HashMap<>();
        //idx need not be initialized if its 0, coz its default value in java
        //root is the last element in postorder
        idx = postorder.length-1;
        //populate hashmap of inorder
        for (int i=0; i<inorder.length; i++)
        {
            //add the element and its index to hashmap
            map.put(inorder[i],i);
        }
        return helper(postorder, 0, postorder.length-1);//array, starting index and ending index
    }
    //return root of tree
    //inorder not required because inorder info is present in map
    private TreeNode helper(int[] postorder, int start, int end)
    {
        //base
        if (start > end)
        {
            return null;
        }
        
        //logic
        //get the root value
        int rootVal = postorder[idx];
        //index is decreased, coz after every root is processed, last element of postorder becomes the root
        idx--;
        //create new node with this rootVal
        TreeNode root = new TreeNode(rootVal);
        //search index of rootVal in preorder vis the hashmap
        int rootIdx=map.get(rootVal);
        //building RST first because postorder has root of RST after root is processed
        //ex: when 3 is processes , next item is 20 which is root of RST. if LST is built before RST, 20 will be put in LST
        //build RST, starting is root index+1 from inorder and ending id old ending
        root.right= helper(postorder, rootIdx+1, end);
        //build LST, start is the old starting point and ending point is index of root from inorder-1
        root.left=helper(postorder, start, rootIdx-1);

        return root;
    }
}
