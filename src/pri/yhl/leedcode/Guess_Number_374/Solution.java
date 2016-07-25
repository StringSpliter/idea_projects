package pri.yhl.leedcode.Guess_Number_374;

import org.junit.Test;

/**
 * Created by yhl on 2016/7/24.
 */
public class Solution extends GuessGame{
    public int guessNumber(int n) {
        int lower = 1;
        int higher = n;
        int target = 0;
        while(lower<=higher){
            long a = lower+higher;
            int middle = (int) ((long)lower+(long)higher)/2;
            int reslut = guess(middle);
            if(reslut == 1){
                lower = middle+1;
            }else if(reslut==-1){
                higher = middle-1;
            }else{
                target = middle;
                break;
            }
            System.out.println(lower+"----"+higher+"----"+middle);
        }
        return target;
    }
    public int getMoneyAmount(int n) {
        int lower = 1;
        int higher = n;
        int target = 0;
        while(lower<=higher){
            int middle = (int) ((long)lower+(long)higher)/2;
            System.out.println(lower+"----"+higher+"----"+middle);
            int reslut = guess(middle);
            if(reslut == 1){
                lower = middle+1;
                target = target + middle;
            }else if(reslut==-1){
                higher = middle-1;
                target = target + middle;
            }else{
                break;
            }
        }
        System.out.println(target);
        return target;
    }
    @Test
    public void guessNumberTest(){

            guessNumber(10);

    }
    @Test
    public void getMoneyAmountTest(){
        getMoneyAmount(50);
    }
}
