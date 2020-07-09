package me.aborozdykh.amazonreview.repository;

import me.aborozdykh.amazonreview.entity.Word;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WordRepository extends JpaRepository<Word, String> {
    @Query("SELECT new me.aborozdykh.amazonreview.entity.Word("
            + "w.id, w.count) "
            + "FROM Word w "
            + "ORDER BY w.count DESC")
    Page<Word> findMostPopularWords(Pageable pageable);
}
