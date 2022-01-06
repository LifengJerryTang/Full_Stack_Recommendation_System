package com.jerry.recommendation_system.controller;

import com.jerry.recommendation_system.DTO.MovieDTO;
import com.jerry.recommendation_system.DTO.RaterDTO;
import com.jerry.recommendation_system.model.Movie;
import com.jerry.recommendation_system.model.Rater;
import com.jerry.recommendation_system.service.RaterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rater")
public class RaterController {

    @Autowired
    RaterService raterService;

    @GetMapping
    public List<RaterDTO> getAllRaters() {
        return raterService.findAllRaters().stream().map(this::convertRaterToRaterDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RaterDTO getRaterById(@PathVariable Long id){
        return convertRaterToRaterDTO(raterService.findRaterById(id));
    }

    @GetMapping("/{username}")
    public RaterDTO getRaterByUsername(@PathVariable String username) {
        return convertRaterToRaterDTO(raterService.findRaterByUsername(username));
    }

    @PostMapping
    public RaterDTO saveRater(@RequestBody RaterDTO raterDTO) {

    }

    public RaterDTO convertRaterToRaterDTO(Rater rater) {
        RaterDTO raterDTO = new RaterDTO();
        BeanUtils.copyProperties(rater, raterDTO);

        return raterDTO;
    }

    public Rater convertRaterDTOToRater(RaterDTO raterDTO) {
        Rater rater = new Rater();
        BeanUtils.copyProperties(raterDTO, rater);

        return rater;
    }
}
