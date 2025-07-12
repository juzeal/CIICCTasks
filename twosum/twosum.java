package twosum;
import java.util.ArrayList;
import java.util.Arrays;

public class twosum {
    ArrayList<Integer> nums;
    int target;

    /* 
    public twosum(ArrayList<Integer> nums, int target) {
        this.nums = nums;
        this.target = target;
    }*/

    static public ArrayList<Integer> checkSum(ArrayList<Integer> nums, int target) {
        ArrayList<Integer> output = new ArrayList<>();
        for(int x=0; x <= nums.size() - 1; x++){
            for( int i : nums) {
                if( nums.get(x) + i == target ) {
                    output.add(nums.indexOf(nums.get(x)));
                    output.add(nums.indexOf(i));
                }
            }
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1,2,3));
        int target = 5;
        twosum r = new twosum();
        ArrayList<Integer> result = twosum.checkSum(input, target);
        if ( result.isEmpty() ) {
            System.out.println("Target not found");
        } else {
            System.out.println(result);
        }
    }

}

