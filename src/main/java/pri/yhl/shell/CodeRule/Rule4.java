package pri.yhl.shell.CodeRule;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by yanghaile1 on 2017/4/12.
 */
public class Rule4 extends CodeRule{
    public Rule4() {
        super(RuleType.Warn, "warning 4");
    }

    @Override
    public CodeRuleRS applyRule(String script) {
//上线时打开
//        if(StringUtils.isEmpty(script)) return null;
        String[] scriptLines = script.split("(\\n|\\r|\\r\\n)");

        List<Integer> list = new ArrayList<Integer>();
        Stack<Boolean> selectFlag = new Stack<Boolean>();
        Stack<Boolean> fromFlag = new Stack<Boolean>();
        for(int i=0;i<scriptLines.length;i++){
            String curLine = scriptLines[i].trim().toLowerCase();
            if(curLine.startsWith("#")||curLine.startsWith("--")){
                continue;
            }
            if(curLine.matches(".*select\\s+.*")){
                selectFlag.add(true);
            }

        }
//        CodeRuleRS rs = new CodeRuleRS();
//        rs.setErrLines(list);
//        rs.setRuleType(this.type);
//        return rs;
        return null;
    }
    public static void main(String args[]){
        String script = "#!/bin/bash\n" +
                "#################################################################################\n" +
                "# Target Table : \n" +
                "# Source Table : \n" +
                "# Interface Name: \n" +
                "# Refresh Frequency: per day 每日处理\n" +
                "# Version Info : \n" +
                "# 修改人   修改时间       修改原因 \n" +
                "# ------   -----------    --------------------\n" +
                "#\n" +
                "#################################################################################\n" +
                "echo \"任务说明...\"\n" +
                "# User Variable Section\n" +
                "echo \"date_ymd:\"\n" +
                "#################################################################################\n" +
                "for((d=20151001;d<=20151228;d++))\n" +
                "do\n" +
                "\n" +
                " if [ ${d} -eq 20151032 ]\n" +
                " then\n" +
                "  d=20151101\n" +
                " elif [ ${d} -eq 20151131 ]\n" +
                " then\n" +
                "  d=20151201\n" +
                " fi\n" +
                "\n" +
                "hive -v -e \"\n" +
                "set hive.default.fileformat=rcfile;\n" +
                "set hive.exec.compress.output=true;\n" +
                "set hive.map.aggr=true;\n" +
                "set hive.groupby.skewindata=true;\n" +
                "set hive.exec.dynamic.partition=true;\n" +
                "set hive.exec.dynamic.partition.mode=nonstrict;\n" +
                "set hive.warehouse.subdir.inherit.perms=false;\n" +
                "use temp;\n" +
                "create table if not exists temp.temp_agnes_action_hour_20170505 like data_agnes.agnes_action_hour;\n" +
                "\n" +
                "INSERT OVERWRITE TABLE temp.temp_agnes_action_hour_20170505 partition (dt,hour,product,source)\n" +
                "select \n" +
                "start_id                     as start_id    \n" +
                ",concat(unix_timestamp(current_time,'yyyyMMdd HH:mm:ss'),'000')           as current_time\n" +
                ",app_run_id              as app_run_id  \n" +
                ",concat(unix_timestamp(act_time,'yyyyMMdd HH:mm:ss'),'000')                   as act_time\n" +
                ",act_name                 as act_name\n" +
                ",act_des                    as act_des     \n" +
                ",map('imei',imei)      as props       \n" +
                ",ip                             as ip\n" +
                ",unix_timestamp(server_time,'yyyyMMdd HH:mm:ss')            as server_time\n" +
                ",'letv'                         as device      \n" +
                ",dt                             as dt          \n" +
                ",substr(current_time,10,2)   as  hour        \n" +
                ",'phone'                          as product     \n" +
                ",'app'                               as source\n" +
                "            \n" +
                "from dwd.dwd_flow_sdk_phone_app_day where dt =${d}\n" +
                "group by\n" +
                "start_id                   \n" +
                ",concat(unix_timestamp(current_time,'yyyyMMdd HH:mm:ss'),'000')           \n" +
                ",app_run_id             \n" +
                ",concat(unix_timestamp(act_time,'yyyyMMdd HH:mm:ss'),'000')              \n" +
                ",act_name                 \n" +
                ",act_des                    \n" +
                ",map('imei',imei)                                  \n" +
                ",ip                             \n" +
                ",unix_timestamp(server_time,'yyyyMMdd HH:mm:ss')             \n" +
                ",'letv'                        \n" +
                ",dt                              \n" +
                ",substr(current_time,10,2)    \n" +
                ",'phone'                           \n" +
                ",'app'                               \n" +
                "\n" +
                ";\n" +
                "\n" +
                "\"\n" +
                " \n" +
                " if [ $? -ne 0 ]\n" +
                " then\n" +
                "  echo 'error ${d}'\n" +
                "  exit 1\n" +
                " fi\n" +
                "\n" +
                "done\n";
    }
}
