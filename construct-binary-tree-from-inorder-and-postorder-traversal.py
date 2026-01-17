''' Time Complexity : O(n)
    Space Complexity : O(h)

'''
class Solution:

    def buildTree(self, inorder: List[int], postorder: List[int]) -> Optional[TreeNode]:
            self.hashmap={}
            self.idx = len(inorder)-1

            for i in range(len(inorder)):
                self.hashmap[inorder[i]] = i
            print(self.hashmap)

            return self.helper(postorder,0,len(inorder)-1)

    def helper(self,postorder,start,end):
        if start > end:
            return None
        rootval = postorder[self.idx]
        print(rootval)
        root_idx = self.hashmap[rootval]
        self.idx -= 1

        root = TreeNode(rootval)
        root.right = self.helper(postorder,root_idx+1,end)
        root.left = self.helper(postorder,start,root_idx-1)
        return root