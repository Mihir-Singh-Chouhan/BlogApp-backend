package com.company.demo.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name="users")
public class UserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name",nullable = false,length = 100)
    private String name;
    private String email;
    private String password;
    private String about_user;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL,fetch = FetchType.EAGER      )
    private List<PostEntity> postEntities = new ArrayList<>();

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<CommentEntity> commentEntitySet = new HashSet<>();

   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(name = "user_role",
   joinColumns = @JoinColumn(name = "user",referencedColumnName = "id"),
           inverseJoinColumns = @JoinColumn(name="role",referencedColumnName = "id")
   )
   private Set<RoleEntity> roles = new HashSet<>();

    public UserEntity(Long id, String name, String email, String password, String about_user, List<PostEntity> postEntities) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.about_user = about_user;
        this.postEntities = postEntities;

    }

    /**
     * Getter method for property <tt>id</tt>.
     *
     * @return property value of id
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter method for property <tt>id</tt>.
     *
     * @param id value to be assigned to property id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for property <tt>email</tt>.
     *
     * @param email value to be assigned to property email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>about</tt>.
     *
     * @return property value of about
     */
    public String getAbout() {
        return about_user;
    }

    /**
     * Setter method for property <tt>about</tt>.
     *
     * @param about_user value to be assigned to property about
     */
    public void setAbout(String about_user) {
        this.about_user = about_user;
    }

    /**
     * Getter method for property <tt>postEntities</tt>.
     *
     * @return property value of postEntities
     */
    public List<PostEntity> getPostEntities() {
        return postEntities;
    }

    /**
     * Setter method for property <tt>postEntities</tt>.
     *
     * @param postEntities value to be assigned to property postEntities
     */
    public void setPostEntities(List<PostEntity> postEntities) {
        this.postEntities = postEntities;
    }

    /**
     * Getter method for property <tt>commentEntitySet</tt>.
     *
     * @return property value of commentEntitySet
     */
    public Set<CommentEntity> getCommentEntitySet() {
        return commentEntitySet;
    }

    /**
     * Setter method for property <tt>commentEntitySet</tt>.
     *
     * @param commentEntitySet value to be assigned to property commentEntitySet
     */
    public void setCommentEntitySet(Set<CommentEntity> commentEntitySet) {
        this.commentEntitySet = commentEntitySet;
    }

    /**
     * Getter method for property <tt>roles</tt>.
     *
     * @return property value of roles
     */
    public Set<RoleEntity> getRoles() {
        return roles;
    }

    /**
     * Setter method for property <tt>roles</tt>.
     *
     * @param roles value to be assigned to property roles
     */
    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }

    public UserEntity() {
    }

    /**
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of password
     */
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorities = this.roles.stream().map((role)->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

        return authorities;
    }

    public String getEmail() {
        return this.email;
    }


    @Override
    public String getUsername() {
       // return "";
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        //return UserDetails.super.isAccountNonExpired();
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       // return UserDetails.super.isAccountNonLocked();
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //return UserDetails.super.isCredentialsNonExpired();
        return true;
    }

    @Override
    public boolean isEnabled() {
        //return UserDetails.super.isEnabled();
        return true;
    }
}
