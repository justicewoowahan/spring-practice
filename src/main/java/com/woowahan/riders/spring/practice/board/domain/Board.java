package com.woowahan.riders.spring.practice.board.domain;

import java.util.Date;

/**
 * Created by justicehoop on 2016. 3. 18..
 */
public class Board {

    private Long id;
    private String name;
    private Date createdDate;

    private Board() {

    }

    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public static Board of(String name) {
        Board board = new Board();
        board.setName(name);
        board.setCreatedDate(new Date());
        return board;
    }

}
