package ma.enset.hopital.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PatientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void indexPageRendersWithLayout() throws Exception {
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("patients"))
                // contenu propre a la page
                .andExpect(content().string(containsString("Liste patients")))
                // fragment fourni par le template parent : prouve que layout:decorate fonctionne
                .andExpect(content().string(containsString("navbar")));
    }
}
