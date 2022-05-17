package test.task.SpringProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.task.SpringProject.exception.ServerException;
import test.task.SpringProject.model.DAO.ResponseModel;
import test.task.SpringProject.model.DAO.SumModel;
import test.task.SpringProject.model.DAO.SumRequestModel;
import test.task.SpringProject.service.SumService;

@RestController
@RequestMapping("/records")
public class SumController {

    private final SumService sumService;

    @Autowired
    public SumController(SumService sumService) {
        this.sumService = sumService;
    }

    @PostMapping("/add")
    public ResponseEntity<ResponseModel> addRecord(@RequestBody SumModel record) {
        try {
            return ResponseEntity.ok(sumService.addRecord(record));
        } catch (ServerException e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }

    @PostMapping("/remove")
    public ResponseEntity<ResponseModel> removeRecord(@RequestBody SumModel record) {
        try {
            return ResponseEntity.ok(sumService.removeRecord(record));
        } catch (ServerException e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }

    @PostMapping("/sum")
    public ResponseEntity<ResponseModel> sumRecord(@RequestBody SumRequestModel model) {
        try {
            return ResponseEntity.ok(sumService.sumRecord((model)));
        } catch (ServerException e) {
            return ResponseEntity.badRequest().body(e.getResponse());
        }
    }
}