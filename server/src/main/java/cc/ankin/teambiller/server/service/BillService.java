package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.Bill;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BillService {

    public Bill add(Bill bill) {
        return bill;
    }

}
