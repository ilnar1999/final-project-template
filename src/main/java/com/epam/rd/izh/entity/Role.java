package com.epam.rd.izh.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "t_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<AuthorizedUser> users;
}
