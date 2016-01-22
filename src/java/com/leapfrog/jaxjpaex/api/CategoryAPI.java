/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.jaxjpaex.api;

import com.leapfrog.jaxjpaex.dao.CategoryDAO;
import com.leapfrog.jaxjpaex.dao.impl.CategoryDAOImpl;
import com.leapfrog.jaxjpaex.entity.Category;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/categoryapi")
public class CategoryAPI {
    private CategoryDAO categoryDAO = new CategoryDAOImpl();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Category> index(){
       
        return categoryDAO.getAll();
    }
    
    @Path(value= "/save")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String save(@FormParam("name")String name,@FormParam("description")String desc,
                        @FormParam("status")boolean status){
        
        Category category = new Category();
        category.setId(1);
        category.setName(name);
        category.setDescription(desc);
        category.setStatus(status);
        
        categoryDAO.update(category);
        return "<h1> Successfully inserted </h1>";
        
    }
    
    
    @GET
    @Path(value = "/delete")
    public String delete(@PathParam("id") int id){
        categoryDAO.delete(id);
        return "delete success";
    }

}
