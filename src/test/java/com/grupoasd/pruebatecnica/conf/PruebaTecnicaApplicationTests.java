package com.grupoasd.pruebatecnica.conf;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaTecnicaApplicationTests {
    @Rule public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");
    private @Autowired WebApplicationContext context;
    private MockMvc mockMvc;

    @Before public void setUp(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void buscarPorIdWithProvidedContent() throws Exception{
        this.mockMvc.perform(get("/activos/activoFijo/1")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8")).andDo(document("{class-name}/{method-name}",
                responseFields(fieldWithPath("afijId").description("Id de del Activo Fijo."),
                        fieldWithPath("afijNombre").description("Nombre del Activo Fijo."),
                        fieldWithPath("afijDescripcion").description("Breve descrición Activo Fijo."),
                        fieldWithPath("afijTipo").description("El tipo de Activo Fijo."),
                        fieldWithPath("afijNumeroserie").description("Número serial del Activo Fijo."),
                        fieldWithPath("afijNumeroinventario").description("Número de inventario interno del Activo Fijo."),
                        fieldWithPath("afijAlto").description("Altura en metros del Activo Fijo."),
                        fieldWithPath("afijLargo").description("Longitud en metros del Activo Fijo."),
                        fieldWithPath("afijAncho").description("Anchura en metros del Activo Fijo."),
                        fieldWithPath("afijPeso").description("Peso en kilogramos del Activo Fijo."),
                        fieldWithPath("afijValorcompra").description("Valor de compra del Activo Fijo."),
                        fieldWithPath("afijFechacompra").description("Fecha de compra del Activo Fijo."),
                        fieldWithPath("afijFechabaja").description("Fecha de baja del Activo Fijo."),
                        fieldWithPath("afijEstadoactual").description("Estado actual del Activo Fijo."),
                        fieldWithPath("afijColor").description("Color del Activo Fijo."),
                        fieldWithPath("optionalContent").description("Greeting's optional content").type(JsonFieldType.STRING).optional())));
    }

}
