package pri.yhl.shell.CodeRule;

/**
 * Created by yanghaile1 on 2017/4/10.
 */
public enum RuleType {
    Warn(0),
    Exception(1);
    private int type;
     RuleType(int type){
        this.type = type;
    }
    public int getType(){
        return type;
    }
}
