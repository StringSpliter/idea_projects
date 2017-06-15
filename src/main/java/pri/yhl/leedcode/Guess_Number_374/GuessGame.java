package pri.yhl.leedcode.Guess_Number_374;

import java.util.Random;

/**
 * Created by yhl on 2016/7/24.
 */
public class GuessGame {
    private int curNum =48;
    public void getRandom(){
        int n = (new Random()).nextInt();
        curNum = n;
    }
    public int guess(int n){
        if(curNum == n) return 0;
        else if (curNum < n) return -1;
        else return 1;

    }
    public int getCurNum(){
        return curNum;
    }
}
//2126753390
//1702766719