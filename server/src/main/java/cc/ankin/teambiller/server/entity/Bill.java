package cc.ankin.teambiller.server.entity;


import java.util.List;
import java.util.Map;

public class Bill {
    public String id;
    public Long bill_time;
    public Long create_time;
    public String payer_id;
    public String seller;
    public List<BillDetail> billDetailList;
    public String remark;
    public Map<String, Integer> statusMap;
    public Integer status; // 0 已删除; 1 已创建; 2 已结算
}