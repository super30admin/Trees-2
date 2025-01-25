# tc O(n), sc O(n).
def get_leaf_vals_sum(node, prev_num):
    # base case
    if not node:
        return
    if not node.left and not node.right:
        curr_num = prev_num * 10 + node.val
        sumn[0] += curr_num
        return
    
    # recursive case
    curr_num = prev_num * 10 + node.val

    get_leaf_vals_sum(node.left, curr_num)
    get_leaf_vals_sum(node.right, curr_num)

sumn = [0]
get_leaf_vals_sum(root, 0)
return sumn[0]