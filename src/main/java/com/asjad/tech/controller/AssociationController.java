package com.asjad.tech.controller;

import com.asjad.tech.entity.AssociationModel;
import com.asjad.tech.service.AssociationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/assoc")
public class AssociationController {
	
	@Autowired
    AssociationService associationService;

    public static final Logger LOGGER = LoggerFactory.getLogger(AssociationController.class);

	@GetMapping(path = "getAll")
    public ResponseEntity<?> getAllAssoc() {
        LOGGER.info("getting all associations");
        AssociationModel resource = associationService.getAll();
        return ResponseEntity.ok(resource);
    }

}
