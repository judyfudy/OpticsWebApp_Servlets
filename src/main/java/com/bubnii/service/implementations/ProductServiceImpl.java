package com.bubnii.service.implementations;

import com.bubnii.dao.implementations.ProductDaoImpl;
import com.bubnii.dao.interfaces.ProductDao;
import com.bubnii.entity.Product;
import com.bubnii.entity.ProductType;
import com.bubnii.service.interfaces.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao = new ProductDaoImpl();

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public void addProductToCart(int personId, int productId) {
        productDao.addProductToCart(personId, productId);
    }

    @Override
    public List<Product> getProductsByType(int typeId) {
        return productDao.getProductsByType(typeId);
    }

    @Override
    public List<ProductType> getAllTypesOfProducts() {
        return productDao.getAllTypesOfProducts();
    }

    @Override
    public List<Product> getAllProductsInCart(int userId) {
        return productDao.getAllProductsInCart(userId);
    }

    @Override
    public void deleteFromCart(int productId, int userId) {
        productDao.deleteFromCart(productId, userId);
    }

    public void clearCart(int userId) {
        productDao.clearCart(userId);
    }
}
