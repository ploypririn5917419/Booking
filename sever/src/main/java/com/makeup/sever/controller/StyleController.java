package com.makeup.sever.controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

import com.makeup.sever.entity.Style;
import com.makeup.sever.repository.StyleRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StyleController {
        private StyleRepository styleRepository;

        public StyleController (StyleRepository styleRepository){
            this.styleRepository = styleRepository;
        }
        @RequestMapping("/style")
        public Collection<Style> style() {
        return styleRepository.findAll().stream()
                 .collect(Collectors.toList());
    }
}
