from collections import deque

class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def display(self):
        lines, *_ = self._display_aux()
        print("\n")
        for line in lines:
            print(line)

    def _display_aux(self):
        """Returns list of strings, width, height, and horizontal coordinate of the root."""
        # No child.
        if self.right is None and self.left is None:
            line = '%s' % self.val
            width = len(line)
            height = 1
            middle = width // 2
            return [line], width, height, middle

        # Only left child.
        if self.right is None:
            lines, n, p, x = self.left._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s
            second_line = x * ' ' + '/' + (n - x - 1 + u) * ' '
            shifted_lines = [line + u * ' ' for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, n + u // 2

        # Only right child.
        if self.left is None:
            lines, n, p, x = self.right._display_aux()
            s = '%s' % self.val
            u = len(s)
            first_line = s + x * '_' + (n - x) * ' '
            second_line = (u + x) * ' ' + '\\' + (n - x - 1) * ' '
            shifted_lines = [u * ' ' + line for line in lines]
            return [first_line, second_line] + shifted_lines, n + u, p + 2, u // 2

        # Two children.
        left, n, p, x = self.left._display_aux()
        right, m, q, y = self.right._display_aux()
        s = '%s' % self.val
        u = len(s)
        first_line = (x + 1) * ' ' + (n - x - 1) * '_' + s + y * '_' + (m - y) * ' '
        second_line = x * ' ' + '/' + (n - x - 1 + u + y) * ' ' + '\\' + (m - y - 1) * ' '
        if p < q:
            left += [n * ' '] * (q - p)
        elif q < p:
            right += [m * ' '] * (p - q)
        zipped_lines = zip(left, right)
        lines = [first_line, second_line] + [a + u * ' ' + b for a, b in zipped_lines]
        return lines, n + m + u, max(p, q) + 2, n + u // 2

def build_tree_level_order(values):
    N = len(values)
    if N == 0:
        return TreeNode(None)
    q = deque()
    tree = TreeNode(values[0])
    q.append(tree)
    i=0
    while i < N and q:
        node = q.popleft()
        left_index = 2*i+1
        right_index = left_index + 1
        if left_index < N and values[left_index] is not None:
            node.left = TreeNode(values[left_index])
            q.append(node.left)
        if right_index < N and values[right_index] is not None:
            node.right = TreeNode(values[right_index])
            q.append(node.right)
        i += 1
    return tree

def search_bst(root, val):
    ''' Search for the node containing a given value in a Binary Search Tree '''
    # base
    if root is None or root.val == val:
        return root

    # logic
    if root.val < val:
        node = search_bst(root.right, val)
    else:
        node = search_bst(root.left, val)
    return node

def search_bt(root, val):
    ''' Search for the node containing a given value in a Binary Tree '''
    # base
    if root is None or root.val == val:
        return root

    # logic
    node = None
    if root.left:
        node = search_bt(root.left, val)
    if not node and root.right:
        node = search_bt(root.right, val)
    return node
