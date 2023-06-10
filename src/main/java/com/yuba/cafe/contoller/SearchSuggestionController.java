package com.yuba.cafe.contoller;

import com.yuba.cafe.fakeData.SearchSuggestionGroup;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchSuggestionController {

    @GetMapping("/api/public/suggestion")
    public ResponseEntity<?> suggestion() {
        List<SearchSuggestionGroup> resp = List.of(
                new SearchSuggestionGroup(
                        0L,
                        "Recent searches",
                        List.of(
                                "Cheese",
                                "Apple Sauce"
                        )
                ),
                new SearchSuggestionGroup(
                        1L,
                        "Popular searches",
                        List.of(
                                "Organic",
                                "Gluten Free",
                                "Paleo",
                                "Vegan",
                                "Vegitarian",
                                "Whole30"
                        )
                )
        );

        return ResponseEntity.ok(resp);
    }
}