package com.yuba.cafe.fakeData;

import com.yuba.cafe.model.Snack;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SnackCollection {
    private Long id;
    private String name;
    private List<Snack> snacks;
    private CollectionType type = CollectionType.Normal;
}
