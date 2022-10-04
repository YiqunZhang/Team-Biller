package cc.ankin.teambiller.server.service;

import cc.ankin.teambiller.server.entity.Bill;
import cc.ankin.teambiller.server.entity.Setting;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SettingService {
    @Resource
    private MongoTemplate mongoTemplate;

    public void add(Setting setting) {
        mongoTemplate.save(setting);
    }

    public void add(String key, Object value) {
        Setting setting = new Setting();
        setting.key = key;
        setting.value = value;
        add(setting);
    }

    public Setting get(String key) {
        return mongoTemplate.findById(key, Setting.class);
    }

    public String getString(String key) {
        Setting setting = get(key);
        return (String) setting.value;
    }
}
