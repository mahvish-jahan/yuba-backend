package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.Category;
import com.yuba.cafe.model.Filter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilterRepo extends CrudRepository<Filter, Long> {
}
