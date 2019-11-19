package com.liu.filter;

import java.util.List;

public interface IBaseDao<T> {

    public int deleteList(Class c, int[] ids);

    public void delete(T o);

    public void delete(Class c, int id);

    public List<T> find(String hql, String[] param);

    public List<T> findByFields(String hql, String[] fields, String condition);

    public T findById(Class c, int id);

    public T findOne(String hql, String[] param);

    public List<T> findPage(String hql, String[] param, int page, int size);

    public int getCount(String hql, String[] param);

    public T insert(T o);

    public int insertList(List<T> list);

    public void update(T o);


}





