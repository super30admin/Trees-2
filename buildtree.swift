// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    var postIndex = Int()
    var hashmap = [Int:Int]()
    func buildTree(_ inorder: [Int], _ postorder: [Int]) -> TreeNode? {
        postIndex = postorder.count - 1
        if inorder == nil || postorder == nil{
            return nil
        }
        for i in 0..<inorder.count {
            hashmap[inorder[i]] = i
        }
        return buildTreeHelper(0,inorder.count-1,inorder,postorder) 
    }
        func buildTreeHelper(_ instart: Int, _ inend: Int, _ inorder: [Int], _ postorder: [Int]) -> TreeNode?{
        if instart > inend {
            return nil
        }
        var root = TreeNode(postorder[postIndex])
        guard let index = hashmap[postorder[postIndex]] else { return root }
        postIndex -= 1
        root.right = buildTreeHelper(index+1,inend,inorder,postorder)
        root.left = buildTreeHelper(instart,index-1,inorder,postorder)
        return root
    }