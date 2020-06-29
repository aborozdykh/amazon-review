package me.aborozdykh.amazonreview.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */
@Getter
@Setter
@Entity
@Table(name = "reviews")
public class Review {
    @Id
    private Long id;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private short score;
    private LocalDateTime dateTime;
    private String summary;
    @Lob
    @Column(name = "text", columnDefinition = "BLOB")
    private String text;
}
