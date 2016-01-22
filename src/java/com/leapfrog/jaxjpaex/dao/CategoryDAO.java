/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxjpaex.dao;

import com.leapfrog.jaxjpaex.entity.Category;
import java.util.List;

/**
 *
 * @author sajjan
 */
public interface CategoryDAO {
    List<Category> getAll();
    int insert(Category c);
    Category getById(int id);
    void update (Category c);
    void delete (int id);
}
