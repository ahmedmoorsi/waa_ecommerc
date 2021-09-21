package com.waa.ecommerc.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String username;
    String password;
    boolean isEnabled;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES", joinColumns = {
            @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
            @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    String shipping_address;
    String billing_address;

    String payment;

    @ManyToMany
    @JoinTable(name="follow",
            joinColumns=@JoinColumn(name="buyer_id"),
            inverseJoinColumns=@JoinColumn(name="seller_id")
    )
    private List<User> followers;

    @ManyToMany
    @JoinTable(name="follow",
            joinColumns=@JoinColumn(name="seller_id"),
            inverseJoinColumns=@JoinColumn(name="buyer_id")
    )
    private List<User> following;

}
