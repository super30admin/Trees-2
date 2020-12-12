# Time: O(N)
# Space: O(N)

class Solution:
    def sumNumbers(self, root):
        sum_ = 0
        stack = []
        node = root
        num = 0
        while node or stack:
            while node:
                stack.append((node, num * 10 + node.val))
                num = num * 10 + node.val
                node = node.left
            # print([(x.val, s) for x, s in stack])
            node, num = stack.pop()
            # print(node.val)
            if not node.left and not node.right:
                sum_ += num
            node = node.right

        return sum_