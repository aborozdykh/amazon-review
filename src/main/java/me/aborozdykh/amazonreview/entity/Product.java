package me.aborozdykh.amazonreview.entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Andrii Borozdykh
 */
@Entity
@Table(name = "product")
public class Product {
    @Id
    private Long id;

    @OneToMany
    private List<Review> reviews;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Product{"
                + "id=" + id
                + ", reviews=" + reviews
                + '}';
    }
}
