package com.yuba.cafe.service;

import com.yuba.cafe.model.Snack;
import com.yuba.cafe.reporsitory.SnackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SnackService {

    @Autowired
    private SnackRepo snackRepo;

    public Snack save(Snack snack) {
        return snackRepo.save(snack);
    }

    public Optional<Snack> findById(Long id) {
        return snackRepo.findById(id);
    }

    public List<Snack> list() {
        List<Snack> list = new ArrayList<>();

        for (Snack snack : snackRepo.findAll()) {
            list.add(snack);
        }

        return list;
    }

    public List<Snack> findAllById(List<Long> snackIds) {
        return snackRepo.findByIdIn(snackIds);
    }

    public Snack update(Snack snack) {
        return snackRepo.save(snack);
    }
}
