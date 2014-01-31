package com.geowarin.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Date: 31/01/2014
 * Time: 00:33
 *
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
@XmlRootElement
public class Message {
    private String author;
    private String contents;

    public Message() {
    }

    public Message(String author, String contents) {
        this.author = author;
        this.contents = contents;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}