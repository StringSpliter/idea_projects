package pri.yhl.designPattern.javaDymProxy;

/**
 * Created by yhl on 17-9-12.
 */
public class FishingInterImpl implements FishingInter{

    public void fishing() {
        System.out.println("fishing status!");
    }

    public String getFishNum(String str) {

        return str+":"+"fishing imp!";
    }
}
