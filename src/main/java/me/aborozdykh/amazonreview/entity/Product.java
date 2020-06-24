package me.aborozdykh.amazonreview.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    private String id;
    @OneToMany(fetch = FetchType.EAGER) //, mappedBy = "product", cascade = CascadeType.ALL
    private List<Review> reviews;
}
