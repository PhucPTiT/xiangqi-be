package com.xiangqi.server.repository;
import com.xiangqi.server.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Matches, Long> {
}
