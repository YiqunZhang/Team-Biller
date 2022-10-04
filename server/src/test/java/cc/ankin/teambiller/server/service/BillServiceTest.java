package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.Bill;
import cc.ankin.teambiller.server.entity.BillDetail;
import cc.ankin.teambiller.server.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class BillServiceTest {
    @Resource
    private BillService billService;


    @Test
    public void create() {
        Bill bill = new Bill();
        bill.bill_time = System.currentTimeMillis() - 1000 * 60 * 60 * 24 * 3;
        bill.remark = "20L";
        bill.seller = "Costco加油站";

        bill.statusMap = new HashMap<String, Integer>();
        bill.statusMap.put("63288b369c961c4b48f0ab7c", 1);
        bill.statusMap.put("633b21edd32805073de00eb8", 1);
        bill.statusMap.put("633b220fadf63843bb40ca21", 1);

        bill.billDetailList = new ArrayList<BillDetail>();
        BillDetail billDetail = new BillDetail();
        billDetail.name = "Petrol";
        billDetail.subName = "汽油";
        billDetail.share = new HashMap<String, Integer>();
        billDetail.share.put("63288b369c961c4b48f0ab7c", 1);
        billDetail.share.put("633b21edd32805073de00eb8", 1);
        billDetail.share.put("633b220fadf63843bb40ca21", 1);
        billDetail.totalPrice = 6500;
        billDetail.currency = "AUD";

        bill.billDetailList.add(billDetail);

        billService.create(bill);
    }


}

