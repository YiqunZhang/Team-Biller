package cc.ankin.teambiller.server.entity;

import org.springframework.data.annotation.Id;

public class Setting {
    @Id
    public String key;
    public Object value;
}
