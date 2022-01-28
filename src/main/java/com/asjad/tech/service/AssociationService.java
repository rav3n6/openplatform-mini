package com.asjad.tech.service;

import com.asjad.tech.entity.AssociationModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Paths;

@Component
public class AssociationService {

    AssociationModel associationModel;

    public static final Logger LOGGER = LoggerFactory.getLogger(AssociationService.class);
    public AssociationModel getAll() {

        {
            try {
                LOGGER.info("creating object mapper instance");
                ObjectMapper mapper = new ObjectMapper();

                // convert JSON file to class
                LOGGER.info("Retrieving JSON file");
                associationModel = mapper.readValue(Paths.get("src/main/resources/associations.json").toFile(), AssociationModel.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return associationModel;
    }
}
