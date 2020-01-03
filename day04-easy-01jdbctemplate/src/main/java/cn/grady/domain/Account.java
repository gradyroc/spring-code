package cn.grady.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gradyzhou
 * @version 1.0, on 22:41 2020/1/3.
 */
@Data
public class Account implements Serializable {
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }

    private Integer id;
    private String name;
    private Float money;
}
