/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Product;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class ProductDao implements IService<Product, String> {

    Session session;

    @Override
    public List<Product> getData(String keyword) {
        session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT p FROM Product p WHERE p.productName like :productName");
        query.setString("productName", "%" + keyword + "%");
        List<Product> products = query.list();
        session.clear();
        session.close();
        return products;
    }

    @Override
    public Product getDataById(String id) {
        session = HibernateUtil.getSessionFactory().openSession();
        Product product = (Product) session.get(Product.class, id);
        session.clear();
        session.close();
        return product;
    }

    @Override
    public int insertData(Product t) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.clear();
            session.close();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateData(Product t) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            session.clear();
            session.close();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int deleteData(String id) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Product p = (Product) session.get(Product.class, id);
            session.delete(p);
            session.getTransaction().commit();
            session.clear();
            session.close();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

}
