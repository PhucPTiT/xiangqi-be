package com.xiangqi.server.repository;

import com.xiangqi.server.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Match, Long> {
}
