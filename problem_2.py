# TC: O(n)
# SC: O(1)
def sumNumbers(root):
        sum = 0
        def helper(root, intersum):
            if not root: return None

            if not root.left and not root.right:
                nonlocal sum
                intersum = intersum * 10 + root.val
                sum += intersum
                return

            intersum = intersum * 10 + root.val
            
            helper(root.left, intersum)
            helper(root.right, intersum)
        
        helper(root, 0)

        return sum