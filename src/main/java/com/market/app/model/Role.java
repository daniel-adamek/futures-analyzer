package com.market.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "app_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQR")
    @SequenceGenerator(name = "SEQR", sequenceName = "ROLE_SEQ")
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "roles")//mappedBy-means roles is the side which is owner
    private Set<User> users;

    public Role() {
    }

    public Role(String name, Set<User> users) {
        this.name = name;
        this.users = users;
    }
}
