//This problem is reverse of constructing tree from preorder and inorder. We use the inorder to populate the map with element and index. We then use postorder to get the root node starting at the end of the index
// and then we find the index of the roote node from the map and recursively call for right and left subtree. Note that we call for right subtree first as we are decrementing the index from postorder array.
////Time Complexity : O(N) where N is the number of nodes
//Space Complexity : O(N) where N is the number of nodes

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var idx = 0
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        val map = HashMap<Int, Int>()

        for(i in 0..inorder.size - 1) {
            map.put(inorder[i], i)
        }
        this.idx = postorder.size - 1
        return helper(postorder, 0, postorder.size -1, map)
    }

    fun helper(postorder: IntArray, start: Int, end: Int, map: HashMap<Int, Int>) : TreeNode? {

        //base case
        if(start > end) return null;

        //logic
        val rootVal = postorder[idx] 
        idx--

        val rootIndx : Int = map.get(rootVal)!!

        val root = TreeNode(rootVal)
        root.right = helper(postorder, rootIndx + 1, end, map)
        root.left = helper(postorder, start, rootIndx - 1, map)

        return root
    }
}