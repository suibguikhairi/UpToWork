package tn.tekup.spring.uptowork;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import tn.tekup.spring.uptowork.dto.DepartementDTO;

import java.util.ArrayList;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
class DepartementRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testRetrieveAllDepartements() throws Exception {
        mockMvc.perform(get("/departement/retrieve-all-departements"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testRetrieveDepartement() throws Exception {
        int departementId = 1; // replace with a valid departement ID
        mockMvc.perform(get("/departement/retrieve-departement/{departement-id}", departementId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testAddDepartement() throws Exception {
        DepartementDTO departementDTO = new DepartementDTO();
        departementDTO.setNomDepart("TestDepartement");
        departementDTO.setEtudiants(Collections.emptyList());

        mockMvc.perform(post("/departement/add-departement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(departementDTO)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    void testRetrieveDepartementsByUniversite() throws Exception {
        int idUniversite = 1; // replace with a valid university ID
        mockMvc.perform(get("/departement/retrieveDepartementsByUniversite/{idUniversite}", idUniversite))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void addDepartement() throws Exception {
        DepartementDTO departementDTO = new DepartementDTO();
        departementDTO.setNomDepart("Test Departement");
        departementDTO.setEtudiants(new ArrayList<>());

        mockMvc.perform(post("/departement/add-departement")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(departementDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nomDepart", is("Test Departement"))); // Update with the expected department name
    }



    @Test
    void retrieveDepartementsByUniversite() throws Exception {
        mockMvc.perform(get("/departement/retrieveDepartementsByUniversite/{idUniversite}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0))); // Update with the expected size of the list
    }

}
