// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach



  public class sumroottoleaf {
      int val;
      sumroottoleaf left;
      sumroottoleaf right;
      sumroottoleaf() {}
      sumroottoleaf(int val) { this.val = val; }
      sumroottoleaf(int val, sumroottoleaf left, sumroottoleaf right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    int roottoleaf=0;
    private void calculate(sumroottoleaf r, int currnum){
        
        if(r!=null){
            currnum= currnum*10+ r.val;
            if(r.left==null && r.right==null){
                roottoleaf= roottoleaf+ currnum;
            }
            calculate(r.left, currnum);
            calculate(r.right, currnum);
        }
        
    }
    
    public int sumNumbers(sumroottoleaf root) {
        calculate(root, 0);
        return roottoleaf;
    }
}