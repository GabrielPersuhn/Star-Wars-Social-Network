package br.com.letscode.java.star_wars_resistence.Negociacao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class NegociacaoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void newNegociacao() {

    }

}
