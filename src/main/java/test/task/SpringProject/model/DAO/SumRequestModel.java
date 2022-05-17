package test.task.SpringProject.model.DAO;


import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class SumRequestModel {
    private String first;
    private String second;
}