package pri.yhl.shell.CodeRule;

import java.util.List;

/**
 * Created by yanghaile1 on 2017/4/11.
 */
public class CodeRuleRS {

    private String errorInfo;
    private List<Integer> errLines;
    private RuleType ruleType ;

    public RuleType getRuleType() {
        return ruleType;
    }

    public void setRuleType(RuleType ruleType) {
        this.ruleType = ruleType;
    }

    public String getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(String errorInfo) {
        this.errorInfo = errorInfo;
    }

    public List<Integer> getErrLines() {
        return errLines;
    }

    public void setErrLines(List<Integer> errLines) {
        this.errLines = errLines;
    }
}
