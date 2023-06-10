package com.yuba.cafe.reporsitory;

import com.yuba.cafe.model.Address;
import com.yuba.cafe.model.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {
}
