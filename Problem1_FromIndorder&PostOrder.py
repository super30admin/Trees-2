#Time Complexity:
#Space Complexity:
#Works On LeetCode: 

class Node:
    def __init__(self, data):
        self.val = data
        self.left = None
        self.right = None
    
class Solution:
    def buildTree(self, inorder, postorder):
        mapper = {}
        for i, v in enumerate(inorder):
            mapper[v] = i
    

        def helper(low, high):
            if low>high:
                return

            root = Node(postorder.pop())
            mid = mapper[root.val]
            root.right = helper(mid+1, high)
            root.left = helper(low, mid-1)
            return root
        
        return helper(0,len(inorder)-1)


inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]
obj = Solution()
print(obj.buildTree(inorder, postorder))