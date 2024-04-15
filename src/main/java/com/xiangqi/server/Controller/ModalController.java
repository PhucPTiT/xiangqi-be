package com.xiangqi.server.Controller;


import com.xiangqi.server.Service.Impl.ModalService;
import com.xiangqi.server.entity.Modal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ModalController {

    @Autowired
    ModalService modalService;


    @PostMapping("/addNewModal")
    public ResponseEntity addNewModal(@RequestBody Modal modal) {
        Modal newModal = modalService.saveModal(modal);
        return new ResponseEntity(newModal, HttpStatus.CREATED);
    }

    @PutMapping("/editModal")
    public ResponseEntity editModal(@RequestBody Modal modal) {
        Modal savedModal = modalService.saveModal(modal);
        return new ResponseEntity(savedModal, HttpStatus.OK);
    }

    @DeleteMapping("/deleteModal/{modalId}")
    public ResponseEntity deleteModal(@PathVariable(value = "modalId") Long modalId) {
        modalService.deleteModal(modalId);
        return new ResponseEntity("Deleted Modal", HttpStatus.OK);
    }

    @GetMapping("/Modal/{modalId}")
    public ResponseEntity getModal(@PathVariable(value = "modalId") Long modalId) {
        Modal modal = modalService.findModalById(modalId);
        return new ResponseEntity(modal, HttpStatus.OK);
    }

    @GetMapping("/Modals")
    public ResponseEntity getModal() {
        List<Modal> modals = modalService.getAllModal();
        return new ResponseEntity(modals, HttpStatus.OK);
    }
}
