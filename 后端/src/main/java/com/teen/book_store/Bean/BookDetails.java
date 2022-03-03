package com.teen.book_store.Bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @author teen
 * @create 2021/11/22 9:16
 */

@TableName("book_details")
public class BookDetails {
    private Long id;
    private String synopsis;
    private String publish;
    private String preview;
    private Long wordLength;
    private String bookType;


    @Override
    public String toString() {
        return "BookDetails{" +
                "id=" + id +
                ", synopsis='" + synopsis + '\'' +
                ", publish='" + publish + '\'' +
                ", preview='" + preview + '\'' +
                ", wordLength=" + wordLength +
                ", bookType='" + bookType + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public Long getWordLength() {
        return wordLength;
    }

    public void setWordLength(Long wordLength) {
        this.wordLength = wordLength;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public BookDetails() {
    }

    public BookDetails(Long id, String synopsis, String publish, String preview, Long wordLength, String bookType) {
        this.id = id;
        this.synopsis = synopsis;
        this.publish = publish;
        this.preview = preview;
        this.wordLength = wordLength;
        this.bookType = bookType;
    }
}
