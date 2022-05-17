package test.task.SpringProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import test.task.SpringProject.model.DAO.ResponseModel;
import test.task.SpringProject.model.Mappers.ResponseMapper;
import test.task.SpringProject.model.enums.Response;

@Getter
@Setter
@Accessors(chain = true)
@AllArgsConstructor
public abstract class ServerException extends Exception {
    protected Response response;

    public ResponseModel getResponse() {
        return new ResponseMapper().toModel(this.response);
    }
}