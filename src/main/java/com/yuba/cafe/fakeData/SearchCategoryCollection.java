package com.yuba.cafe.fakeData;

import com.yuba.cafe.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class SearchCategoryCollection {
    private Long id;
    private String name;
    private List<Category> categories;
}
