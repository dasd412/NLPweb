package com.dasd412.domain.article;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "from Article where date between :startDate and :endDate")
    List<Article> findAllBetweenDates(@Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate);
}
