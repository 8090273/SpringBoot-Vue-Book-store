package com.teen.book_store.Bean;

import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 订单元素pojo
 * id、username和bookId  组成主键
 * @author teen
 * @create 2021/11/23 10:13
 */
@TableName("order_form_item")
public class OrderFormItem {

    //订单的id，非唯一，用于连接订单表
    private Long id;
    private Long bookId;
    //书籍数量
    private Long bookNum;
    private Double price;

    @Override
    public String toString() {
        return "OrderFormItem{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", bookNum=" + bookNum +
                ", price=" + price +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getBookNum() {
        return bookNum;
    }

    public void setBookNum(Long bookNum) {
        this.bookNum = bookNum;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public OrderFormItem() {
    }

    public OrderFormItem(Long id, Long bookId, Long bookNum, Double price) {
        this.id = id;
        this.bookId = bookId;
        this.bookNum = bookNum;
        this.price = price;
    }
}
