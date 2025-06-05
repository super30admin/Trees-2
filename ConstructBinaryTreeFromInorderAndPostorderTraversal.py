class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right

class Solution:
    def buildTree(self,inorder,postorder):
        if not inorder or not postorder:
            return None
        
        inorder_index_map={val: idx for idx, val in enumerate(inorder)}

        def helper(left,right):
            if left>right:
                return None
            
            root_val=postorder.pop()
            root=TreeNode(root_val)

            index=inorder_index_map[root_val]
            root.right=helper(index+1,right)
            root.left=helper(left,index-1)

            return root
        
        return helper(0,len(inorder)-1)
from collections import deque

def serializeLevelOrder(root):
    if not root:
        return[]
    
    result=[]
    queue=deque([root])

    while queue:
        node=queue.popleft()
        if node:
            result.append(node.val)
            queue.append(node.left)
            queue.append(node.right)
        else:
            result.append(None)
    
    while result and result[-1] is None:
        result.pop()

    return result
    
inorder = [9,3,15,20,7] 
postorder = [9,15,7,20,3]
sol=Solution()
root=sol.buildTree(inorder, postorder)
print(serializeLevelOrder(root))