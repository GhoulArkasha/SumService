package test.task.SpringProject.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import test.task.SpringProject.model.DAO.SumModel;
import test.task.SpringProject.service.SumService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SumControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SumService sumService;

    @Test
    public void addRecordControllerTest() throws Exception {
        mockMvc.perform(post("/records/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"name123456789\",\"value\":\"123\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        sumService.removeRecord(new SumModel().setName("name123456789").setValue(123L));
    }

    @Test
    public void removeRecordControllerTest() throws Exception {
        sumService.addRecord(new SumModel().setName("name098").setValue(123L));

        mockMvc.perform(post("/records/remove")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\":\"name098\",\"value\":\"123\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    @Test
    public void sumRecordControllerTest() throws Exception {
        sumService.addRecord(new SumModel().setName("name0").setValue(123L));
        sumService.addRecord(new SumModel().setName("name9").setValue(123L));

        mockMvc.perform(post("/records/sum")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"first\":\"name0\",\"second\":\"name9\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        sumService.removeRecord(new SumModel().setName("name0").setValue(123L));
        sumService.removeRecord(new SumModel().setName("name9").setValue(123L));
    }
}