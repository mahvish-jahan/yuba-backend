package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.Snack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface SnackRepo extends CrudRepository<Snack, Long> {
    List<Snack> findByIdIn(List<Long> snackIds);

    List<Snack> findAllByTagsIn(Set<String> tags);
}
