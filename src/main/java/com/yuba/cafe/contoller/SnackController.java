package com.yuba.cafe.contoller;

import com.yuba.cafe.model.Snack;
import com.yuba.cafe.service.SnackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class SnackController {

    @Autowired
    private SnackService snackService;

    @PutMapping("secure/snack")
    public ResponseEntity<?> add(@RequestBody Snack snack) {
        Snack createdSnack = snackService.save(snack);
        if (createdSnack == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(createdSnack);
    }

    @PostMapping("secure/snack")
    public ResponseEntity<?> update(@RequestBody Snack snack) {
        Snack updatedSnack = snackService.update(snack);

        return ResponseEntity.ok(updatedSnack);
    }

    @GetMapping("public/snack/{snackId}")
    public ResponseEntity<?> getSnackById(@PathVariable Long snackId) {
        Optional<Snack> byId = snackService.findById(snackId);
        if (byId.isPresent()) return ResponseEntity.ok(byId.get());
        return ResponseEntity.notFound().build();
    }

    @GetMapping("secure/snack")
    public ResponseEntity<?> list() {
        List<Snack> list = snackService.list();
        return ResponseEntity.ok(list);
    }
}
