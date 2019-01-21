package com.makeup.sever.repository;


import com.makeup.sever.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findBypositionId(Long id);
    Position findByPositionIds(String positionIDs);
    Position findByPositionName(String positionName);
}
