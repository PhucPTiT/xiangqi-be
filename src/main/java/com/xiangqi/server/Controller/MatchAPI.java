package com.xiangqi.server.Controller;

import com.xiangqi.server.dto.MatchDTO;
import com.xiangqi.server.entity.Matches;
import com.xiangqi.server.service.Impl.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/match")
public class MatchAPI {
    @Autowired
    private MatchService matchService;
    @PostMapping
    public ResponseEntity<MatchDTO> createMatch(@RequestBody MatchDTO matchDTO) {
        MatchDTO createdMatchDTO = matchService.createMatch(matchDTO).getBody();
        if (createdMatchDTO != null) {
            return ResponseEntity.ok(createdMatchDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
