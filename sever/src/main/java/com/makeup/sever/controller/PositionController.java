package com.makeup.sever.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import com.makeup.sever.entity.Position;
import com.makeup.sever.repository.PositionRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PositionController {
        private PositionRepository positionRepository;

        public PositionController (PositionRepository positionRepository){
            this.positionRepository = positionRepository;
        }
        @RequestMapping("/position")
        public Collection<Position> position() {
        return positionRepository.findAll().stream()
            .collect(Collectors.toList());
    }
}