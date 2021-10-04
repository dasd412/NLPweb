package com.dasd412.domain.twit;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TwitRepository extends JpaRepository<Twit,String> {

    @Query(value = "from Twit where originId = :origin_id")
    Optional<List<Twit>> findAllByReTwitId(@Param("origin_id") String origin_id);
}
