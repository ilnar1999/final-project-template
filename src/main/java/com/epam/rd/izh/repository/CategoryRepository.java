package com.epam.rd.izh.repository;

import com.epam.rd.izh.entity.Category;
import com.epam.rd.izh.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    CategoryMapper categoryMapper;

    public List<Category> getAllCategories() {
        return jdbcTemplate.query("SELECT * FROM t_categories", categoryMapper);
    }

    public Category getCategoryById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM t_categories WHERE id = ? LIMIT 1", categoryMapper, id);
    }
}
