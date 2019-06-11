package com.market.app.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @Transient //doesnt need to be persisted
    private String passwordConfirm;
    @ManyToMany
    private Set<Role> roles;
}
