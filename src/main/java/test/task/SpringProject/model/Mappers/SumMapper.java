package test.task.SpringProject.model.Mappers;

import test.task.SpringProject.entity.SumEntity;
import test.task.SpringProject.model.DAO.SumModel;

public class SumMapper {

    public static SumEntity toEntity(SumModel model) {
        return new SumEntity()
                .setName(model.getName())
                .setValue(model.getValue());
    }
}
