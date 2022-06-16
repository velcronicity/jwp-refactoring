package kitchenpos.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import kitchenpos.application.TableService;
import kitchenpos.domain.OrderTable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TableRestControllerTest {
    private MockMvc mockMvc;
    @Mock
    private TableService tableService;
    @InjectMocks
    private TableRestController tableRestController;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        this.objectMapper = new ObjectMapper();
        this.mockMvc = MockMvcBuilders.standaloneSetup(tableRestController).build();
    }

    @Test
    void test_get() throws Exception {
        //given
        given(tableService.list()).willReturn(Collections.singletonList(new OrderTable()));

        //then
        mockMvc.perform(get("/api/tables"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void test_post() throws Exception {
        //given
        given(tableService.create(any())).willReturn(new OrderTable());

        //then
        mockMvc.perform(post("/api/tables").content(objectMapper.writeValueAsString(new OrderTable()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    void test_put_changeEmpty() throws Exception {
        //given
        given(tableService.changeEmpty(any(), any())).willReturn(new OrderTable());

        //then
        mockMvc.perform(put("/api/tables/{orderTableId}/empty", 0).content(objectMapper.writeValueAsString(new OrderTable()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void test_put_changeNumberOfGuests() throws Exception {
        //given
        given(tableService.changeNumberOfGuests(any(), any())).willReturn(new OrderTable());

        //then
        mockMvc.perform(put("/api/tables/{orderTableId}/number-of-guests", 0).content(objectMapper.writeValueAsString(new OrderTable()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
