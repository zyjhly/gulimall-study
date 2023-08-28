package com.zyj.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyj.common.utils.PageUtils;
import com.zyj.common.utils.Query;

import com.zyj.gulimall.product.dao.CategoryDao;
import com.zyj.gulimall.product.entity.CategoryEntity;
import com.zyj.gulimall.product.service.CategoryService;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //1.查出所有分类
        List<CategoryEntity> categoryAllList = baseMapper.selectList(null);
        //2.递归查出所有子分类

        QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_cid",0);
        List<CategoryEntity> parentCategoryList = baseMapper.selectList(wrapper);

        for (CategoryEntity categoryEntity : parentCategoryList) {
            buildTree(categoryEntity,categoryAllList);
        }
        //3.封装成树形结构
        return parentCategoryList;
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //查看当前菜单是否还有子级，如果有则不能删除，否则直接删除
        /*QueryWrapper<CategoryEntity> wrapper = new QueryWrapper<>();
        wrapper.in("parent_cid",asList);
        List<CategoryEntity> entities = baseMapper.selectList(wrapper);
        if(entities.isEmpty()){
            baseMapper.deleteBatchIds(asList);
        }*/
        baseMapper.deleteBatchIds(asList);
    }

    public void buildTree(CategoryEntity categoryEntity,List<CategoryEntity> categoryEntityList){
        ArrayList<CategoryEntity> list = new ArrayList<>();
        for (CategoryEntity entity : categoryEntityList) {
            if(entity.getParentCid() == categoryEntity.getCatId()){
                list.add(entity);
                buildTree(entity,categoryEntityList);
            }
        }
        categoryEntity.setChildren(list);
    }

}