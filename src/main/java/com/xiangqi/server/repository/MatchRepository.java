package com.xiangqi.server.repository;
import com.xiangqi.server.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchRepository extends JpaRepository<Matches, Long> {
    @Query("SELECT m FROM Matches m WHERE m.result = 'user win' AND m.user.id = :userId")
    List<Matches> findMatchWinByPlayerId(@Param("userId") Long userId);

}

