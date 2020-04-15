package com.epam.rd.izh.entity;

import lombok.Data;

@Data
public class Role {

    private long id;
    private String name;

    public Role id(Long id) {
        this.setId(id);
        return this;
    }

    public Role name(String name) {
        this.setName(name);
        return this;
    }
}
