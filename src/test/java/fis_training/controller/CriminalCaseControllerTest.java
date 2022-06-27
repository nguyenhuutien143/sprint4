package fis_training.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fis_training.core.CaseStatus;
import fis_training.core.CaseType;
import fis_training.dto.CriminalCaseDTO;
import fis_training.model.CriminalCase;
import fis_training.service.CriminalCaseService;
import fis_training.service.DetectiveService;
import fis_training.service.EvidenceService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.modelmapper.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CriminalCaseController.class)
class CriminalCaseControllerTest {
    @MockBean
    private CriminalCaseService criminalCaseService;
    @MockBean
    private DetectiveService detectiveService;
    @MockBean
    private EvidenceService evidenceService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;
    @Test
    void save() {
        CriminalCaseDTO criminalCaseDTO = CriminalCaseDTO.builder()
                .type(CaseType.INFRACTION)
                .status(CaseStatus.SUBMITTED)
                .number("case001")
                .build();
        CriminalCase criminalCase = modelMapper.map(criminalCaseDTO, CriminalCase.class);
        Mockito.when(criminalCaseService.save(criminalCase)).thenReturn(criminalCase);

        ResultActions response = mockMvc.perform(post("/criminalCases")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(criminalCaseDTO)));

        response.andDo(print()).
                andExpect(status().isCreated())
                .andExpect(jsonPath("$.caseNumber",
                        is(criminalCaseDTO.getNumber())))
                .andExpect(jsonPath("$.caseStatus",
                        is(criminalCaseDTO.getStatus())))
                .andExpect(jsonPath("$.caseType",
                        is(criminalCaseDTO.getType())));
    }

    @Test
    void updateCriminalCase() {
    }

    @Test
    void deleteCriminalCase() {
    }

    @Test
    void getAllCriminalCases() {
    }

    @Test
    void findByStatus() {
    }

    @Test
    void findByType() {
    }
}