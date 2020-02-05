package com.bubnii.dao.implementations;

import com.bubnii.config.DBConnection;
import com.bubnii.dao.interfaces.ProductDao;
import com.bubnii.entity.Product;
import com.bubnii.entity.ProductType;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.naming.NamingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> getAll() {

        List<Product> products = new LinkedList<>();


        String sql = "SELECT * FROM product";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setPrice(rs.getInt("price"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setPhoto(rs.getString("photo"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                products.add(product);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public boolean add(Product product) throws SQLException, NamingException {
        throw new NotImplementedException();
    }

    @Override
    public Product get(int id) throws SQLException, NamingException {
        return null;
    }

    @Override
    public boolean update(Product product) throws SQLException, NamingException {
        throw new NotImplementedException();
    }

    @Override
    public boolean delete(int id) throws SQLException, NamingException {
        throw new NotImplementedException();
    }

    @Override
    public void addProductToCart(int personId, int productId) {

        String sql = "INSERT INTO cart (user_id, product_id) VALUES(?,?)";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, personId);
            ps.setInt(2, productId);
            ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getProductsByType(int typeId) {

        List<Product> products = new LinkedList<>();


        String sql = "SELECT * FROM product WHERE product_type_id=?";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ps.setInt(1, typeId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setPrice(rs.getInt("price"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setPhoto(rs.getString("photo"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                products.add(product);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public List<ProductType> getAllTypesOfProducts() {

        List<ProductType> productTypes = new LinkedList<>();


        String sql = "SELECT * FROM product_type";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ProductType productType = new ProductType();
                productType.setId(rs.getInt("id"));
                productType.setName(rs.getString("name"));
                productTypes.add(productType);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return productTypes;
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {

        List<Product> products = new LinkedList<>();

        String sql = "select * from product inner join cart on id = product_id where user_id=?";

        try (PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setPrice(rs.getInt("price"));
                product.setName(rs.getString("name"));
                product.setQuantity(rs.getInt("quantity"));
                product.setDescription(rs.getString("description"));
                product.setPhoto(rs.getString("photo"));
                product.setBrand(rs.getString("brand"));
                product.setModel(rs.getString("model"));
                products.add(product);
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }

        return products;
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        String sql = "delete from cart where product_id=? and user_id=?";

        try(PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, productId);
            ps.setInt(2, userId);
            ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clearCart(int userId) {
        String sql = "delete from cart where user_id=?";

        try(PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
