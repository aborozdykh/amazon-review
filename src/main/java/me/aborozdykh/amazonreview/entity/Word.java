package me.aborozdykh.amazonreview.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Andrii Borozdykh
 */
@Getter
@Setter
@Entity
@Table(name = "words")
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @Id
    String id;
    Integer count;
}
