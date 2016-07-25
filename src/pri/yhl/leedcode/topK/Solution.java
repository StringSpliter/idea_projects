package pri.yhl.leedcode.topK;

import org.junit.Test;

import java.util.List;
import java.util.*;

/**
 * Created by yhl on 2016/7/24.
 */
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        quickSort(nums,0,nums.length-1);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> list = new ArrayList<Integer>();
        int[] keys = new int[k];
        int[] times = new int[k];

        int key = nums[0];
        int time = 0;

        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(key == nums[i]){
               time++;
            }else{
                if(index<k){
                    int j = index;
                    while(j>0){
                        if(times[j-1]<time){
                            times[j] = times[j-1];
                            keys[j] = keys[j-1];
                        }else{
                            break;
                        }
                        j--;
                    }
                    times[j] = time;
                    keys[j] = key;

                    index++;
                }else{
                    int j = index-1;
                    while(j>0){
                        if(times[j]<time){
                            times[j] = times[j-1];
                            keys[j] = keys[j-1];
                        }else{
                            break;
                        }
                        j--;
                    }
                    if(j!=index-1){
                        times[j] = time;
                        keys[j] = key;
                    }
                }
                key = nums[i];
                time = 0;
                time++;
            }
        }

        if(index<k){
            int j = index;
            while(j>0){
                if(times[j-1]<time){
                    times[j] = times[j-1];
                    keys[j] = keys[j-1];
                }else{
                    break;
                }
                j--;
            }
            times[j] = time;
            keys[j] = key;

            index++;
        }else{
            int j = index-1;
            while(j>0){
                if(times[j]<time){
                    times[j] = times[j-1];
                    keys[j] = keys[j-1];
                }else{
                    break;
                }
                j--;
            }
            if(j!=index-1){
                times[j] = time;
                keys[j] = key;
            }
        }

        for(int i=0;i<index;i++){
            list.add(keys[i]);
        }
        return list;
    }
    public void quickSort(int[] nums,int low,int high){
        if(low >= high)
            return;
        else {
            Random random = new Random();
            int a = random.nextInt(high - low);
            int tmp = nums[low];
            nums[low] = nums[low+a];
            nums[low+a] = tmp;

            int elePoint = partition(nums,low,high);
            quickSort(nums,low,elePoint-1);
            quickSort(nums,elePoint+1,high);

        }
    }
    private int partition(int[] nums,int low,int high){
        int index = low;
        while(low<high){
            for(;high>index;high--){
                if(nums[high]<nums[index]){
                    int tmp = nums[index];
                    nums[index] = nums[high];
                    nums[high] = tmp;
                    index = high;
                    break;
                }
            }
            for(;low<index;low++){
                if(nums[low]>nums[index]){
                    int tmp = nums[index];
                    nums[index] = nums[low];
                    nums[low] = tmp;
                    index = low;
                    break;
                }
            }
        }
        return index;
    }
    @Test
    public void topKTest(){
        int[] nums ={2,3,4,1,4,0,4,-1,-2,-1};
        topKFrequent(nums,2);

    }
    @Test
    public void partitionTest(){
        int[] nums ={5,2,3,5};
        partition(nums,0,nums.length-1);

    }
    @Test
    public void quickSortnTest(){
        int[] nums ={1,1,1,2,2,3};
        quickSort(nums,0,nums.length-1);
        System.out.print(nums);
    }
}
