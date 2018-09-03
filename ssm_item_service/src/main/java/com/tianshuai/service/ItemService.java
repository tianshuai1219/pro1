package com.tianshuai.service;

import com.tianshuai.domain.Items;

import java.util.List;

/**
 * Created by tianshuai on 2018/9/2.
 */
public interface ItemService {
    List<Items> findAll();

    Items findById(String id);

    void update(Items items);
}
