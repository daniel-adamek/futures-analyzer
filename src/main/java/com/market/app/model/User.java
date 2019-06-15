package com.market.app.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "app_user")
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ")
    @SequenceGenerator(name = "SEQ", sequenceName = "USER_SEQ")
    private Long id;
    private String username;
    private String password;
    @Transient //doesnt need to be persisted
    private String passwordConfirm;
    @ManyToMany
    private Set<Role> roles;
}
