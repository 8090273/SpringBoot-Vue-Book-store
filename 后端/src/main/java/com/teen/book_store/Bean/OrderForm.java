package com.teen.book_store.Bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.List;

import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;

/**
 * 订单pojo 一对多的 一 端
 * @author teen
 * @create 2021/11/23 10:29
 */
@TableName("order_form")
public class OrderForm {
    //订单id 使用雪花算法生成id  数据库id类型应为bigint
    @TableId(type=ASSIGN_ID)
    private Long id;
    //用户名
    private String username;
    //下单日期
    private String date;
    //送货地址
    private String address;
    //总价
    private Double totalPrice;
    //电话号码
    private String phoneNumber;

    //订单元素（一对多）不在数据库字段内
    @TableField(exist = false)
    private List<OrderFormItem> orderFormItemList;

    @Override
    public String toString() {
        return "OrderForm{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                ", totalPrice=" + totalPrice +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderFormItemList=" + orderFormItemList +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public OrderForm(Long id, String username, String date, String address, Double totalPrice, String phoneNumber, List<OrderFormItem> orderFormItemList) {
        this.id = id;
        this.username = username;
        this.date = date;
        this.address = address;
        this.totalPrice = totalPrice;
        this.phoneNumber = phoneNumber;
        this.orderFormItemList = orderFormItemList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<OrderFormItem> getOrderFormItemList() {
        return orderFormItemList;
    }

    public void setOrderFormItemList(List<OrderFormItem> orderFormItemList) {
        this.orderFormItemList = orderFormItemList;
    }

    public OrderForm() {
    }


}
