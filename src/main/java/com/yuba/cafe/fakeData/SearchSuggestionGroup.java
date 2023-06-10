package com.yuba.cafe.fakeData;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SearchSuggestionGroup {
    private Long id;
    private String name;
    private List<String> suggestions;
}
