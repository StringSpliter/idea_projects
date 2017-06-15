package pri.yhl.shell.CodeRule;

/**
 * Created by yanghaile1 on 2017/4/10.
 */
public abstract class CodeRule {
    protected RuleType type;
    protected String errInfo;
    public  CodeRule(RuleType type,String errInfo){
        this.type = type;
        this.errInfo = errInfo;
    }
    public  abstract CodeRuleRS applyRule(String script);
    public  String getErrorInfo(){
        return errInfo;
    };
}
