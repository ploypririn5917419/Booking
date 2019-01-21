package com.makeup.sever.repository;

import com.makeup.sever.entity.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface StyleRepository extends JpaRepository<Style, Long> {
    Style findBystyleID(Long styleID);
    Style findByStyleIDs(String styleIDs);
    Style findByStyleName(String styleName);
    Style findByStylePrice(int stylePrice);
}
