package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.Bill;
import cc.ankin.teambiller.server.entity.User;
import cc.ankin.teambiller.server.utils.UuidUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BillService {
    @Resource
    private MongoTemplate mongoTemplate;

    public Bill add(Bill bill) {
        return bill;
    }

    public Bill create(Bill bill) {
        bill.id = UuidUtils.getUuid();
        bill.create_time = System.currentTimeMillis();
        bill.status = 1;
        mongoTemplate.save(bill);
        return bill;
    }
    // 0 已删除; 1 已取消无需支付; 2 待支付; 3 收款人已拒绝; 4 已支付待确认; 5 收款人确认已完成;
    public List<Bill> getBillListByUser(User user, List<Integer> statusList) {
        Query query = new Query();

        if (statusList != null && statusList.size() > 0) {
            query.addCriteria(Criteria.where("status").in(statusList));
        }else {
            query.addCriteria(Criteria.where("status").ne(0));
        }

        query.with(Sort.by(Sort.Order.desc("create_time")));

        return mongoTemplate.find(query, Bill.class);
    }




}
