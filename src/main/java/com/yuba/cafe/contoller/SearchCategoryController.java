package com.yuba.cafe.contoller;

import com.yuba.cafe.model.Category;
import com.yuba.cafe.fakeData.SearchCategoryCollection;
import com.yuba.cafe.reporsitory.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SearchCategoryController {

    @Autowired
    private CategoryRepo categoryRepo;

    @GetMapping("/api/public/categories")
    public ResponseEntity<?> category() {

        List<Category> categories = new ArrayList<>();

        Iterable<Category> all = categoryRepo.findAll();

        all.forEach(categories::add);

        List<Category> type1 = categories.subList(0, categories.size() / 2);
        List<Category> type2 = categories.subList(categories.size() / 2, categories.size());

        List<SearchCategoryCollection> resp = List.of(
                new SearchCategoryCollection(
                        0L,
                        "Categories", type1

                ),
                new SearchCategoryCollection(
                        1L,
                        "Lifestyles", type2

                )
        );

        return ResponseEntity.ok(resp);
    }

//    List<Category> type1 = List.of(
//            new Category(1L,
//                    "Chips & crackers",
//                    "https://source.unsplash.com/UsSdMZ78Q3E"
//            ),
//            new Category(2L,
//                    "Fruit snacks",
//                    "https://source.unsplash.com/SfP1PtM9Qa8"
//            ),
//            new Category(3L,
//                    "Desserts",
//                    "https://source.unsplash.com/_jk8KIyN_uA"
//            ),
//            new Category(4L,
//                    "Nuts ",
//                    "https://source.unsplash.com/UsSdMZ78Q3E"
//            )
//    );
//
//    List<Category> type2 = List.of(
//            new Category(5L,
//                    "Organic",
//                    "https://source.unsplash.com/7meCnGCJ5Ms"
//            ),
//            new Category(6L,
//                    "Gluten Free",
//                    "https://source.unsplash.com/m741tj4Cz7M"
//            ),
//            new Category(7L,
//                    "Paleo",
//                    "https://source.unsplash.com/dt5-8tThZKg"
//            ),
//            new Category(8L,
//                    "Vegan",
//                    "https://source.unsplash.com/ReXxkS1m1H0"
//            ),
//            new Category(9L,
//                    "Vegitarian",
//                    "https://source.unsplash.com/IGfIGP5ONV0"
//            ),
//            new Category(10L,
//                    "Whole30",
//                    "https://source.unsplash.com/9MzCd76xLGk"
//            )
//    );
//
//    categoryRepo.saveAll(type1);
//    categoryRepo.saveAll(type2);
}