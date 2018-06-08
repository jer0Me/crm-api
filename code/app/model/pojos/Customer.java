/*
 * This file is generated by jOOQ.
*/
package model.pojos;


import java.io.Serializable;
import java.util.UUID;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.7"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Customer implements Serializable {

    private static final long serialVersionUID = 726173238;

    private Long    id;
    private UUID    uuid;
    private String  name;
    private String  surname;
    private String  photoUrl;
    private Boolean active;
    private Long    createdBy;
    private Long    modifiedBy;

    public Customer() {}

    public Customer(Customer value) {
        this.id = value.id;
        this.uuid = value.uuid;
        this.name = value.name;
        this.surname = value.surname;
        this.photoUrl = value.photoUrl;
        this.active = value.active;
        this.createdBy = value.createdBy;
        this.modifiedBy = value.modifiedBy;
    }

    public Customer(
        Long    id,
        UUID    uuid,
        String  name,
        String  surname,
        String  photoUrl,
        Boolean active,
        Long    createdBy,
        Long    modifiedBy
    ) {
        this.id = id;
        this.uuid = uuid;
        this.name = name;
        this.surname = surname;
        this.photoUrl = photoUrl;
        this.active = active;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    @NotNull
    @Size(max = 50)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Size(max = 50)
    public String getSurname() {
        return this.surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Size(max = 100)
    public String getPhotoUrl() {
        return this.photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Long getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Customer (");

        sb.append(id);
        sb.append(", ").append(uuid);
        sb.append(", ").append(name);
        sb.append(", ").append(surname);
        sb.append(", ").append(photoUrl);
        sb.append(", ").append(active);
        sb.append(", ").append(createdBy);
        sb.append(", ").append(modifiedBy);

        sb.append(")");
        return sb.toString();
    }
}
