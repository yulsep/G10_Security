package com.misiontic.g10.securityBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;
    private String nickname;
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name="idRol")
    @JsonIgnoreProperties("users")
    private Rol rol;

    public Integer getId() {
        return idUser;
    }

    /**
     *
     * @param id
     */

    public void setId(Integer id) {
        this.idUser = id;
    }

    /**
     *
     * @return
     */

    public String getNickname() {
        return nickname;
    }

    /**
     *
     * @param nickname
     */

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     *
     * @return
     */

    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */

    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */

    public void setPassword(String password) {
        this.password = password;
    }

}
