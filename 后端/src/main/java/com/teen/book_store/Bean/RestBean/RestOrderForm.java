package com.teen.book_store.Bean.RestBean;

import java.util.List;

/**
 * @author teen
 * @create 2021/11/28 9:53
 */
public class RestOrderForm {
    private String username;
    private List<RestOrderFormItem> books;
    //送货地址
    private String address;
    //电话号码
    private String phoneNumber;

    public RestOrderForm() {
    }

    @Override
    public String toString() {
        return "RestOrderForm{" +
                "username='" + username + '\'' +
                ", books=" + books +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public RestOrderForm(String username, List<RestOrderFormItem> books, String address, String phoneNumber) {
        this.username = username;
        this.books = books;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<RestOrderFormItem> getBooks() {
        return books;
    }

    public void setBooks(List<RestOrderFormItem> books) {
        this.books = books;
    }
}
