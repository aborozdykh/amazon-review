package me.aborozdykh.amazonreview.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 *
 */
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;
    private String profileName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Review> reviews;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
}
