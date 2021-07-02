package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.dao.AbstractDAO;
import com.peregud.shoppingcenter.dao.DAOStore;
import com.peregud.shoppingcenter.model.Store;

import java.util.List;

public class DAOStoreImpl extends AbstractDAO<Store> implements DAOStore {

    @Override
    public Store save(Store store) {
        return super.save(store);
    }

    @Override
    public Store getById(Class<Store> clazz, int id) {
        return super.getById(clazz, id);
    }

    @Override
    public void delete(Class<Store> clazz, int id) {
        super.delete(clazz, id);
    }

    @Override
    public List<?> getAll(Class<Store> clazz) {
        return super.getAll(clazz);
    }
}
