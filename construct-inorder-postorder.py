"""
Runtime Complexity:
O(n) - We pop the postorder list to get the root and we check the index of it in hashmap.Then we iterate and build left tree from start to index of the root found in hashmap and we go from index+1 to end to build the right tree.
Space Complexity:
O(n)- hashmap to store the values and index of the inorder list.
Yes, the code worked on leetcode.
"""
class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        idx_map = {}
        for i,num in enumerate(inorder):
            idx_map[num] = i
        
       
    
        def helper(left,right):
            if left>right:
                return None
            val = postorder.pop()
            root = TreeNode(val)
            idx = idx_map[val]
            root.right = helper(idx+1,right)
            root.left = helper(left,idx-1)
            return root
            
            
        return helper(0,len(inorder)-1)

        
            
        