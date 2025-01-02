// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
//Problem 1
// Time Complexity : O(n)
// Space Complexity : O(n)

// inorder: left root right - will give you sense of left and right subtree
// predorder: root left right - will give you root

// Your code here along with comments explaining your approach
// Brute force (Time/Spce is O(n^2))
// maintain 4 lists inLeft, preLeft, inRight, preRight and recurse

// optimized
// make hashmap of inorder, two pointers on inorder(get start and end of subtree) and one pointer on preorder(main reference list)

class Solution:
    Idx = 0
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hashmap = {}
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
        #rootIdx => preorder
        def helper(in_start, in_end):
            if in_start > in_end: return None
            rootVal = preorder[self.Idx]
            rootIdx = hashmap[rootVal]
            self.Idx+=1
            root = TreeNode(rootVal)
            root.left = helper(in_start, rootIdx -1)
            root.right = helper(rootIdx + 1, in_end)
            return root

        return helper(0, len(inorder)-1)        

// Problem 2
// Time Complexity : O(n)
// Space Complexity : O(1)
class Solution:
    result = 0
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        result = self.helper(root,0)
        return result
    def helper(self,root:Optional[TreeNode],currNum: int)->int:
        if root== None:
            return 0
        currNum = currNum*10 + root.val
        if(root.left==None and root.right==None):
            return currNum
        left = self.helper(root.left,currNum)
        right = self.helper(root.right,currNum)
        return left+right

