package cc.ankin.teambiller.server.entity;

import java.util.Map;

public class BillDetail {
    public String name;
    public String subName;
    public String remark;
    public Integer unitPrice; // 100 times, can be zero
    public Integer amount; // 100 times, can be zero
    public Integer totalPrice; // 100 times
    public Map<String, Integer> share; // au cent
    public String currency;
}
