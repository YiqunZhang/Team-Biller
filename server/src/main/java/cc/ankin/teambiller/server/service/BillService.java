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

    public List<Bill> getUnpaidBillByUser(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("statusMap." + user.id).is(1));
        query.with(Sort.by(Sort.Order.desc("create_time")));

        return mongoTemplate.find(query, Bill.class);
    }

    public List<Bill> getBillListByUser(User user) {
        Query query = new Query();
        query.addCriteria(Criteria.where("statusMap." + user.id).exists(true));
        query.with(Sort.by(Sort.Order.desc("create_time")));

        return mongoTemplate.find(query, Bill.class);
    }

}
