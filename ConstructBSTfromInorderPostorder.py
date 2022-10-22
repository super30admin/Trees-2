# Brute Force DFS solution

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        if len(inorder) == 0 or len(postorder) == 0 or postorder == None:
            return
        
        root_val = postorder.pop()
        root = TreeNode(root_val)
        
        root_index = inorder.index(root.val) #O(n) time
        
    
        
        root.right = self.buildTree(inorder[root_index + 1:], postorder) # O(n) time and space
        root.left = self.buildTree(inorder[:root_index], postorder) # O(n) time and space
        
        return root
    
    # Time Complexity: O(n^2)
    # Space Complexity: O(n^2)

# Time and space efficient solution using Hashmap

class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        
        hashmap = {}
        for i in range(len(inorder)):
            hashmap[inorder[i]] = i
        def helper(left, right):
            
            if left > right:
                return
            root = TreeNode(postorder.pop())
            index = hashmap[root.val]
            root.right = helper(index + 1, right)
            root.left = helper(left, index-1)
            return root
        
        return helper(0, len(inorder)-1)
    
     # Time Complexity: O(n)
     # Space Complexity: O(n)