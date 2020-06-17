// Time Complexity : O(n) Number of nodes
// Space Complexity : O(h) h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
//recursive appoach using tree traversal. Calculate sum of left leaf node and right leaf node then add it. Base case is to return zero when root is nil and return sum when left and right child is empty

class Solution {
    func sumNumbers(_ root: TreeNode?) -> Int {
        return helper(root, 0)
    }
    
    func helper(_ root: TreeNode?, _ sum: Int) -> Int{
        if root == nil {
            return 0
        }
        if root?.left == nil && root?.right == nil {
            return  root!.val + (sum * 10)
        }
        return helper(root?.left, root!.val + (sum * 10)) + helper(root?.right, root!.val + (sum * 10))

    }
}