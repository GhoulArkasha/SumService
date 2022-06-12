package test.task.SpringProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.task.SpringProject.entity.SumEntity;
import test.task.SpringProject.exception.DataIsNullException;
import test.task.SpringProject.exception.RecordAlreadyExistsException;
import test.task.SpringProject.exception.RecordNotFoundException;
import test.task.SpringProject.exception.ServerException;
import test.task.SpringProject.model.DAO.ResponseModel;
import test.task.SpringProject.model.DAO.SumModel;
import test.task.SpringProject.model.DAO.SumRequestModel;
import test.task.SpringProject.model.DAO.SumResponseModel;
import test.task.SpringProject.model.Mappers.SumMapper;
import test.task.SpringProject.model.enums.Response;
import test.task.SpringProject.repository.SumRepository;

@Service
public class SumService {

    private final SumRepository sumRepo;

    @Autowired
    public SumService(SumRepository mainRepo) {
        this.sumRepo = mainRepo;
    }

    public ResponseModel addRecord(SumModel record) throws ServerException {
        if (record.getName() != null && record.getValue() != null) {
            if (sumRepo.getById(record.getName()) != null) {
                throw new RecordAlreadyExistsException();
            }

            sumRepo.save(SumMapper.toEntity(record));
            return new ResponseModel(Response.OK);
        } else {
            throw new DataIsNullException();
        }
    }

    public ResponseModel removeRecord(SumModel record) throws ServerException {
        if (record.getName() != null) {
            if (sumRepo.getById(record.getName()) == null) {
                throw new RecordNotFoundException();
            }

            sumRepo.delete(SumMapper.toEntity(record));
            return new ResponseModel(Response.OK);
        } else {
            throw new DataIsNullException();
        }
    }


    public ResponseModel sumRecord(SumRequestModel model) throws ServerException {
        if (model.getFirst() != null && model.getSecond() != null) {
            SumEntity first = sumRepo.getById(model.getFirst());
            SumEntity second = sumRepo.getById(model.getSecond());

            if (first == null || second == null) {
                throw new RecordNotFoundException();
            }

            Long sum = first.getValue() + second.getValue();
            return new SumResponseModel(Response.OK, sum);
        } else {
            throw new DataIsNullException();
        }
    }
}
