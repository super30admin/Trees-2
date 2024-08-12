# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(height)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - Use the postorder tree to find root node, while inorder tree will divide subtrees into left and right
    - Store the index of inorder tree in hashmap to get in O(1). Recursively build tree.
    '''
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        def helper(inStartIdx, inEndIdx):
            if inStartIdx > inEndIdx:
                return None
            rootVal = postorder.pop()
            rootIdx = hashMap[rootVal]
            rightTree = helper(rootIdx + 1, inEndIdx)
            leftTree = helper(inStartIdx, rootIdx - 1)
            root = TreeNode(rootVal, leftTree, rightTree)
            return root

        hashMap = {val:idx for idx, val in enumerate(inorder)}
        return helper(0, len(inorder) - 1)