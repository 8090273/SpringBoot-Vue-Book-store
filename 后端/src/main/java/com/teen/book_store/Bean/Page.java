package com.teen.book_store.Bean;

/**
 * @author teen
 * @create 2021/11/20 11:22
 */
public class Page {
    //页码
    private int page;
    //每页条数
    private int size;
    //数据库中的总条数
    private int count;

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                ", count=" + count +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Page() {
    }

    public Page(int page, int size, int count) {
        this.page = page;
        this.size = size;
        this.count = count;
    }
}
