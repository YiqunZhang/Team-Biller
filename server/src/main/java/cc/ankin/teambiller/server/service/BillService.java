package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.Bill;
import cc.ankin.teambiller.server.entity.User;
import cc.ankin.teambiller.server.utils.UuidUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

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

    public List<Bill> getUnpaidBill(User user) {
        Query query = new Query(
            Criteria.where("statusMap." + user.id).is(1)
        );

        return mongoTemplate.find(query, Bill.class);
    }

}
