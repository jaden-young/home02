
import java.util.ArrayList;
import java.util.Random;
import hom02.SimpleBubbleSort;
/**
 *
 * @author JadenYoung
 */
public class BubbleSortTest {
    
    public static void main(String[] arg){
        
        Random rand = new Random();
        
        final int LENGTH = 1000;
        int total = 0;
        
        for(int j = 0; j < 3; j++){
        ArrayList list = new ArrayList(LENGTH);
        
        for(int i = 0; i < LENGTH; i++){
            list.add(rand.nextInt(5));
        }
        
        int[][] sortedList = SimpleBubbleSort.bubbleSort(list);
        
        String leftAlignFormat = "| %-15s | %-4d |%n";

        System.out.format("+-----------------+------+%n");
        System.out.printf("| Length          | Time |%n");
        System.out.format("+-----------------+------+%n");
        
        
        System.out.format(leftAlignFormat, sortedList[0][0] + 1, 
				sortedList[1][0]);
      
        
        System.out.format("+-----------------+------+%n");
        total += sortedList[1][0];
        }
        
    }
}