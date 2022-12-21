import java.util.*;
public class ratings {
    public static void Main(String [] args){
        int [] diff = {100,-200,350,100,-600};
        int rating = 1500;
        int currsum = 1500;
        int max = Integer. MAX_VALUE;
        for(int i=0;i< diff.length;i++){
            currsum = currsum+diff[i];
            if(currsum>max){
                max = currsum;
            }

        }
        System.out.println(max + " " + currsum);
    }
    
}
