package com.tianshuai.service.impl;

import com.tianshuai.dao.ItemDao;
import com.tianshuai.domain.Items;
import com.tianshuai.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tianshuai on 2018/9/2.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;
    public List<Items> findAll() {
        return itemDao.findAll();
    }

    public Items findById(String id) {
        return itemDao.findById(id);
    }

    public void update(Items items) {
        itemDao.save(items);
    }
}
