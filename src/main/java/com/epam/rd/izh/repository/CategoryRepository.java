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

    public Category getCategoryByName(String name) {
        List<Category> categories = jdbcTemplate.query("SELECT * FROM t_categories WHERE name = ? LIMIT 1", categoryMapper, name);
        if (categories.isEmpty()) {
            return null;
        }
        return categories.get(0);
    }

    public boolean saveCategoryByName(String name) {
        return jdbcTemplate.update("INSERT INTO t_categories(name) VALUES (?)", name) > 0;
    }

    public boolean deleteCategoryById(Long id) {
        return jdbcTemplate.update("DELETE FROM t_categories WHERE id = ?", id) > 0;
    }
}
