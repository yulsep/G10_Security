package com.misiontic.g10.securityBackend.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="permission")
public class Permission implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPermission;
    private String url;
    private String method;

    @ManyToMany(mappedBy = "permissions")
    private Set<Rol> roles;

    /**
     * Get id permission
     * @return
     */

    public Integer getId() {
        return idPermission;
    }

    /**
     *
     * @param id
     */

    public void setId(Integer id) {
        this.idPermission = id;
    }

    /**
     *
     * @return
     */

    public String getUrl() {
        return url;
    }

    /** Get url for permission
     *
     * @param url
     */

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     */

    public String getMethod() {
        return method;
    }

    /**
     *
     * @param method
     */

    public void setMethod(String method) {
        this.method = method;
    }

}
