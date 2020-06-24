package me.aborozdykh.amazonreview.entity;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Andrii Borozdykh
 *
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    private String id;
    private String profileName;

    @OneToMany(fetch = FetchType.EAGER)
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;


}
