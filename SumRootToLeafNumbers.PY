from collections import deque
class TreeNode:
    def __init__(self,val=0,left=None,right=None):
        self.val=val
        self.left=left
        self.right=right
def build_tree(values):
    if not values:
        return None
    
    root=TreeNode(values[0])
    queue=deque([root])
    index=1

    while queue and index<len(values):
        node=queue.popleft()

        if index<len(values)and values[index] is not None:
            node.left=TreeNode(values[index])
            queue.append(node.left)
        index +=1

        if index<len(values)and values[index] is not None:
            node.right=TreeNode(values[index])
            queue.append(node.left)
        index+=1

    return root

class Solution:
    def sumNumbers(self,root:TreeNode)->int:
        def dfs(node,current_number):
            if not node:
                return 0
            current_number=current_number * 10+ node.val
            if not node.left and not node.right:
                return current_number
            return dfs(node.left,current_number)+dfs(node.right,current_number)
        return dfs(root,0)
    
tree=[4,9,0,5,1]
root=build_tree(tree)
sol=Solution()
print(sol.sumNumbers(root))