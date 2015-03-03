
package hom02;

import java.util.ArrayList;

/**
 *
 * @author Jaden Young
 */
public class SimpleBubbleSort {
    
    public static int[][] bubbleSort(ArrayList array){
        int length = array.size();
        int temp;
        int count = 0;
        long start = System.currentTimeMillis();
        
        for(int i = 0; i < length - 1; i++){
            count++;
            for(int j = 1+i; j < length; j++){
                
                if((int)array.get(i) > (int)array.get(j)){
                    temp = (int)array.get(i);
                    array.set(i, array.get(j));
                    array.set(i, temp);
                }
            }
        }
        long end = System.currentTimeMillis();
        int time =(int)( end - start);
        int[][] sorted = {{count},{time}};
        return sorted;
    }
}