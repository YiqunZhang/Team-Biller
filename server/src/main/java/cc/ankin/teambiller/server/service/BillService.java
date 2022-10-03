package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.Bill;
import cc.ankin.teambiller.server.utils.UuidUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

}
