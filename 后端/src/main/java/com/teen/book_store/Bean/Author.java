package com.teen.book_store.Bean;

import static com.baomidou.mybatisplus.annotation.IdType.AUTO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author teen
 * @create 2021/11/18 16:10
 */
@TableName("author")
public class Author {
    @TableId(type = AUTO)
    private Long id;
    private String name;
    private Long age;
    private Long bookNumber;
    private String pseudonym;
//    经典作品是 Book类
    private Book representative;
//    对应数据库字段writing_time，java中必须变为大写
    private Long writingTime;
    private Long writingWordNumber;
    private String birthday;
    private String motto;

    public Author() {
    }

    public Author(Long id, String name, Long age, Long bookNumber, String pseudonym, Book representative, Long writingTime, Long writingWordNumber, String birthday, String motto) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bookNumber = bookNumber;
        this.pseudonym = pseudonym;
        this.representative = representative;
        this.writingTime = writingTime;
        this.writingWordNumber = writingWordNumber;
        this.birthday = birthday;
        this.motto = motto;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", bookNumber=" + bookNumber +
                ", pseudonym='" + pseudonym + '\'' +
                ", representative=" + representative +
                ", writingTime=" + writingTime +
                ", writingWordNumber=" + writingWordNumber +
                ", birthday='" + birthday + '\'' +
                ", motto='" + motto + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Long getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(Long bookNumber) {
        this.bookNumber = bookNumber;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public Book getRepresentative() {
        return representative;
    }

    public void setRepresentative(Book representative) {
        this.representative = representative;
    }

    public Long getWritingTime() {
        return writingTime;
    }

    public void setWritingTime(Long writingTime) {
        this.writingTime = writingTime;
    }

    public Long getWritingWordNumber() {
        return writingWordNumber;
    }

    public void setWritingWordNumber(Long writingWordNumber) {
        this.writingWordNumber = writingWordNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}
