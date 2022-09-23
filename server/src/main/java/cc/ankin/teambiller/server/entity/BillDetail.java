package cc.ankin.teambiller.server.entity;

import java.util.Map;

public class BillDetail {
    public String name;
    public String sub_name;
    public String remark;
    public Integer amount;
    public Integer total_price;
    public Map<String, Integer> share; // au cent
}
