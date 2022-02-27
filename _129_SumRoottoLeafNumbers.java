// space complexity - o(n) - number of nodes
      //time - o(n) where n is number of nodes
      //Ran on Leetcode successfully : Yes
      // Problem faced  : No
// recursive approach : maintain a list to keep track of number encountered so far, when leaf found, add to find path sum and add to total sum and backtrack
class Solution {

    public int sum = 0;

    public int sumNumbers(TreeNode root) {
        sum = 0;
        preOrder(root, new ArrayList<Integer>());
        return sum;
    }

    public void preOrder(TreeNode root, List<Integer> list){

        if(root == null) return;

        list.add(root.val);

        if(root.left == null && root.right == null){
            int sumTemp = 0;
            int place = 1;
            for(int i = list.size() -1; i>=0 ; i-- ){
                int num = list.get(i);
                sumTemp += (num * place);
                place *= 10;
            }
            sum += sumTemp;

            /*StringBuilder sb = new StringBuilder();
            for(int x : list){
                sb.append(x);
            }
            sum += Integer.parseInt(sb.toString());*/
        }

        preOrder(root.left, list);
        preOrder(root.right, list);
        list.remove(list.size()-1);
    }
}
