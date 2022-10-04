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
    public Map<String, Integer> statusMap; // 0 已删除; 1 已取消无需支付; 2 待支付; 3 收款人已拒绝; 4 已支付待确认; 5 收款人确认已完成;
    public Integer status; // 0 已删除; 1 未完成; 2 已完成
}