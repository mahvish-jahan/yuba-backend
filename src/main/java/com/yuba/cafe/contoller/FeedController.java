package com.yuba.cafe.contoller;

import com.yuba.cafe.fakeData.CollectionType;
import com.yuba.cafe.fakeData.SnackCollection;
import com.yuba.cafe.model.Snack;
import com.yuba.cafe.reporsitory.SnackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping
public class FeedController {

    @Autowired
    private SnackRepo snackRepo;

    @GetMapping("/api/public/feed")
    public ResponseEntity<List<SnackCollection>> feed() {
        System.out.println("Feed");

        List<Snack> coldDelights = snackRepo.findAllByTagsIn(Set.of("Cold Delights"));
        SnackCollection coldDelightsColl = new SnackCollection(
                1L,
                "Cold Delights",
                coldDelights,
                CollectionType.Highlight
        );

        List<Snack> snacks = snackRepo.findAllByTagsIn(Set.of("Snacks"));
        SnackCollection snacksColl = new SnackCollection(
                1L,
                "Snacks",
                snacks,
                CollectionType.Highlight
        );

        List<Snack> beverages = snackRepo.findAllByTagsIn(Set.of("Beverages"));
        SnackCollection beveragesColl = new SnackCollection(
                1L,
                "Beverages",
                beverages,
                CollectionType.Highlight
        );

        List<Snack> maggieAndPasta = snackRepo.findAllByTagsIn(Set.of("Maggie And Pasta"));
        SnackCollection maggieAndPastaColl = new SnackCollection(
                1L,
                "Maggie And Pasta",
                maggieAndPasta,
                CollectionType.Highlight
        );

        List<SnackCollection> snackCollections = List.of(
                coldDelightsColl,
                snacksColl,
                beveragesColl,
                maggieAndPastaColl
        );

        return ResponseEntity.ok(snackCollections);
    }
}
