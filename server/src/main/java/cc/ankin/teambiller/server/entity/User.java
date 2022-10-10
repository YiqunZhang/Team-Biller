package cc.ankin.teambiller.server.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
public class User implements Serializable {
    @Id
    public String id;
    public String name;
    public String email;
    public String password;
    public Integer autoConfirm; // 0: 不自动确认收款; 1: 自动确认收款
}