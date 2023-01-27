package org.senai.prjquiz.controller;

import org.senai.prjquiz.entity.Placar;
import org.senai.prjquiz.repository.PlacarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/placar")
@CrossOrigin("*")
public class PlacarController {

    @Autowired
    PlacarRepository pRepository;

    @PostMapping("/")
    public @ResponseBody Integer addPlacar(@RequestBody Placar placar) {
        pRepository.save(placar);
        return placar.getId();
    }

    @GetMapping("/")
    public @ResponseBody Iterable<Placar> buscar() {
        return pRepository.findAll();
    }

}