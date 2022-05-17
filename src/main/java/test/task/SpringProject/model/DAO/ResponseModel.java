package test.task.SpringProject.model.DAO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import test.task.SpringProject.model.enums.Response;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class ResponseModel {
    private Long code;
    private String description;

    public ResponseModel(Response response) {
        this.code = response.getCode();
        this.description = response.getDescription();
    }
}
