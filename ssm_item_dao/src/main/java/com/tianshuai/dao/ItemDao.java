package com.tianshuai.dao;

import com.tianshuai.domain.Items;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tianshuai on 2018/9/2.
 */
@Repository
public interface ItemDao {

    @Select("select * from items")
    List<Items> findAll();

    @Select("select * from items where id = #{id}")
    Items findById(String id);

    @Insert("update items set name=#{name},price=#{price},pic=#{pic},createtime=#{createtime},detail=#{detail} where id = #{id}")
    void save(Items items);
}
