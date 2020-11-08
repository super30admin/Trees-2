# Time complexity:O(n)
# Space complexity: 0(2^n)
# Did code run successfully on leetcode: yes
# Any problem you faced: No






class Solution {
    int answer = 0;
    public int sumNumbers(TreeNode root) {
        if(root != null){

        if(root.left == null && root.right == null){

        return root.val;
        }

        makeTree(root.left, root.val);
        makeTree(root.right, root.val);
        }
        return answer;

}


    public void makeTree(TreeNode root, int curNum){

        if(root == null){
           return;
        }

        curNum = curNum*10 + root.val;
         if(root.left == null && root.right == null){
            answer+=curNum;
            return;
        }
        makeTree(root.left, curNum);
        makeTree(root.right, curNum);

    }

}