// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    var sum = 0 
    func sumNumbers(_ root: TreeNode?) -> Int {
        if root == nil {
            return sum
        }
        sumNumbersHelper(root,0)
        return sum
    }
    func sumNumbersHelper(_ root: TreeNode?,_ current: Int) {
        var current = current
        guard let root = root else {
            return  
        } 
        current = current*10 + root.val
        if root.left == nil && root.right == nil {
            sum += current
        }
        sumNumbersHelper(root.left,current)
        sumNumbersHelper(root.right,current)
    }