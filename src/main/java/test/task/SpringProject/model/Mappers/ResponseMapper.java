package test.task.SpringProject.model.Mappers;

import test.task.SpringProject.model.DAO.ResponseModel;
import test.task.SpringProject.model.enums.Response;

public class ResponseMapper {
    public ResponseModel toModel(Response response) {
        return new ResponseModel()
                .setCode(response.getCode())
                .setDescription(response.getDescription());
    }
}
