package cc.ankin.teambiller.server.entity;

import java.util.List;

public class Payment {
    public String id;
    public List<String> billIdList;
    public String payerId;
    public String method; // 转账方式, 例如: 支付宝, 微信

    // 从未创建 -> 已支付待确认 -> 收款人手动确认已完成 || 收款人自动确认已完成 || 收款人已拒绝 || 已被付款人撤销
    public Integer status; // 0 已删除; 1 已被付款人撤销; 2 待支付; 3 收款人已拒绝; 4 已支付待确认; 5 收款人手动确认已完成; 6 收款人自动确认已完成;
    public String remark; // 备注, 付款人填写
    public String reason; // 用于拒绝或撤销
    public Integer amount; // 100 times
    public List<String> imageList;

    public Long create_time;
    public Long pay_time;
    public Long confirm_time;
    public Long decline_time;

}
