package com.yuba.cafe.contoller;

import com.yuba.cafe.model.Filter;
import com.yuba.cafe.reporsitory.FilterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/public")
public class FilterController {

    @Autowired
    private FilterRepo filterRepo;

    @GetMapping("/filters")
    public ResponseEntity<List<Filter>> filters() {

        Iterable<Filter> filters = filterRepo.findAll();
        List<Filter> filterList = new ArrayList<>();
        filters.forEach(filterList::add);

        return ResponseEntity.ok(filterList);
    }
}
