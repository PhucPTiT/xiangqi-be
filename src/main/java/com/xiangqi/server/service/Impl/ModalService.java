package com.xiangqi.server.service.Impl;

import com.xiangqi.server.entity.Modal;
import com.xiangqi.server.repository.ModalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModalService {
    @Autowired
    ModalRepository modalRepository;

    public Modal saveModal(Modal modal) {
        return modalRepository.save(modal);
    }

    public void deleteModal(Long modalId) {
        modalRepository.deleteById(modalId);
    }

    public Modal findModalById(Long modalId) {
        Optional<Modal> modal = modalRepository.findById(modalId);
        return modal.get();
    }

    public List<Modal> getAllModal() {
        List<Modal> modals = modalRepository.findAll();
        return modals;
    }

    public Modal findModalByName(String name) {
        Modal modal = modalRepository.findByName(name);
        return modal;
    }


}
