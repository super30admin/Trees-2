# Time Complexity :O(n)
# Space Complexity :O(logn)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
# Your code here along with comments explaining your approach: The code computes the sum of all numbers formed from root-to-leaf paths in a binary tree. It uses an explicit stack (mapList) to perform DFS, storing each node along with the number formed so far. When a leaf is reached, that number is added to the result, and finally the sum of all such numbers is returned.

class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        res = 0
        if root == None:
            return 0
        
        mapList = []
        mapList.append((root, root.val))

        while len(mapList) != 0:
            temp = mapList.pop()
            if temp[0].left == None and temp[0].right == None:
                res += temp[1]
            else:
                if temp[0].left != None:
                    mapList.append((temp[0].left, temp[1] * 10 + temp[0].left.val))
                if temp[0].right != None:
                    mapList.append((temp[0].right, temp[1] * 10 + temp[0].right.val))
        return res