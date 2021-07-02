package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Store;

import java.util.List;

public class ServletStoreService extends ServletService<Store> {

    public Store save(Store store) {
        return super.save(store);
    }

    public Store getById(int id) {
        return super.getById(Store.class, id);
    }

    public List<?> getList() {
        return super.getAll(Store.class);
    }

    public void delete(int id) {
        super.delete(Store.class, id);
    }

    public void deleteList(String[] idList) {
        super.deleteList(Store.class, idList);
    }
}
