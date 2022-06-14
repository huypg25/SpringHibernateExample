/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;

/**
 *
 * @author ADMIN
 * @param <T>
 * @param <t>
 */
public interface IService<T, t> {

    public List<Product> getData(String keyword);

    public Product getDataById(t id);

    public int insertData(T t);

    public int updateData(T t);

    public int deleteData(t id);
}
