package test.task.SpringProject.model.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import test.task.SpringProject.model.enums.Response;

@Getter
@Setter
@Accessors(chain = true)
public class SumResponseModel extends ResponseModel {
    private Long sum;

    public SumResponseModel(Response response, Long sum) {
        super(response);
        this.sum = sum;
    }
}
