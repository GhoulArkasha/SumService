package test.task.SpringProject;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import test.task.SpringProject.exception.ServerException;
import test.task.SpringProject.model.DAO.ResponseModel;
import test.task.SpringProject.model.DAO.SumModel;
import test.task.SpringProject.model.DAO.SumRequestModel;
import test.task.SpringProject.model.DAO.SumResponseModel;
import test.task.SpringProject.service.SumService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SumServiceTest {
    @Autowired
    private SumService sumService;

    @Test
    public void addRecord() throws ServerException {
        SumModel model = new SumModel()
                .setName("name123")
                .setValue(123L);

        ResponseModel response = sumService.addRecord(model);

        Assertions.assertEquals(0L, (long) response.getCode());
    }

    @Test
    public void removeRecord() throws ServerException {
        SumModel model = new SumModel()
                .setName("name4")
                .setValue(123L);

        sumService.addRecord(model);
        ResponseModel response = sumService.removeRecord(model);

        Assertions.assertEquals(0L, (long) response.getCode());
    }

    @Test
    public void sumRecord() throws ServerException {
        SumModel modelA = new SumModel()
                .setName("name1")
                .setValue(123L);

        SumModel modelB = new SumModel()
                .setName("name2")
                .setValue(4L);

        sumService.addRecord(modelA);
        sumService.addRecord(modelB);

        SumRequestModel model = new SumRequestModel()
                .setFirst(modelA.getName())
                .setSecond(modelB.getName());

        SumResponseModel response = (SumResponseModel) sumService.sumRecord(model);

        Assertions.assertEquals(0L, (long) response.getCode());
        Assertions.assertEquals(127L, (long) response.getSum());
    }
}
