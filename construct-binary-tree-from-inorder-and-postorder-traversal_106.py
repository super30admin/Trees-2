
#Approach1: using hash map, and first taking all the rights
#Time Complexity: O(N) 
#Space Complexity O(N) for hashmap
#It successfully runs on the leetcode


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        d = {v:i for i,v in enumerate(inorder)}
        def helper(pst, pend):
                if not postorder or pst>pend: return None
                root = TreeNode(postorder.pop())
                idx= d[root.val]
                root.right=helper(idx+1, pend)
                root.left= helper(pst, idx-1)
                return root
        return helper(0,len(postorder)-1)   




#Approach1: Take root from postorder and pop it, 
#find the popped one root in inorder and take all left of it to left recursion and right of it to right recursion
#also till the count of inorder take all initial elements from postorder(LeRiRoot) & after that take all elements till right
#so every time we will have smaller inorder postorder for left and right
#Time Complexity O(N^2) as index traversing all lists are O(N) also pop is O(N)
#Space Complexity O(N) callstack in recursion 
#It successfully runs on the leetcode


class Solution:
    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
        while postorder:
                root = TreeNode(postorder.pop())
                idx = inorder.index(root.val)
                if idx!=0: 
                    di = len(inorder[:idx-1])
                else:
                    di = -1
                root.left = self.buildTree(inorder[:idx],postorder[:di+1])
                root.right = self.buildTree(inorder[idx+1:],postorder[di+1:])
                return root
        