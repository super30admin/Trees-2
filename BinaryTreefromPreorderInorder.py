# TC: O(N) where N is the number of elements in the input array or the no. of elements in the tree
# SC: O(N), precisely O(N + H) where N is the size of the hashmap and H is the height of the tree.

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        
        self.preidx = 0
        def builder(inStart, inEnd):
            if inStart > inEnd:
                return
            elif inStart == inEnd:
                root1 = TreeNode(preorder[self.preidx])
                self.preidx += 1
                return root1
            
            rootval = preorder[self.preidx]
            rootidx = hmap.get(rootval)
            root = TreeNode(rootval)
            self.preidx += 1
            
            root.left = builder(inStart, rootidx - 1)
            root.right = builder(rootidx + 1, inEnd)
            
            return root
        
        hmap = {}
        for idx, val in enumerate(inorder):
            hmap[val] = idx
    
        return builder(0, len(inorder) - 1)
