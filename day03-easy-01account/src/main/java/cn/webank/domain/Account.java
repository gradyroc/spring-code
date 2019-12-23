package cn.webank.domain;

import lombok.Data;

/**
 * @author gradyzhou
 * @version 1.0, on 22:46 2019/11/5.
 */
@Data
public class Account {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    private Integer id;
    private String name;
    private Float money;

}
