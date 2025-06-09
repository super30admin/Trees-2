class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def sumNumbers(self, root) -> int:
        '''
        TC: O(n)
        AS: O(h)
        '''

        result = 0
        curr = 0

        def helper(root, curr):

            nonlocal result

            # base condition
            if root is None:
                return 
            
            curr = curr * 10 + root.val
            if root.left is None and root.right is None:
                result += curr

            # logic
            helper(root.left, curr)
            helper(root.right, curr)

        helper(root, curr)
        return result


if __name__ == "__main__":

    # root = TreeNode(1)
    # root.left = TreeNode(2)
    # root.right = TreeNode(3)   

    root = TreeNode(4)
    root.left = TreeNode(9)
    root.right = TreeNode(0)
    root.left.left = TreeNode(5) 
    root.left.right = TreeNode(1)

    s = Solution()
    print(s.sumNumbers(root))
