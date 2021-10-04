package com.dasd412.domain.twit;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReTwitRepository extends JpaRepository<ReTwit, String> {

    @Query(value = "from ReTwit where date between :startDate and :endDate")
    Optional<List<ReTwit>> findAllBetweenDates(@Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate);

}
