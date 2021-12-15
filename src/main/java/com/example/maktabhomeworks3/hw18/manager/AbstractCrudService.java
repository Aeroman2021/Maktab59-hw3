package com.example.maktabhomeworks3.hw18.manager;

import com.example.maktabhomeworks3.hw18.dao.core.AbstractJPADao;
import com.example.maktabhomeworks3.hw18.entity.BaseEntity;

import java.util.List;

public class AbstractCrudService <T extends BaseEntity<ID>,ID extends Number> {

    private AbstractJPADao<T,ID> abstractJPADao;

    public AbstractJPADao<T, ID> getAbstractJPADao() {
        return abstractJPADao;
    }

    public void setAbstractJPADao(AbstractJPADao<T, ID> abstractJPADao) {
        this.abstractJPADao = abstractJPADao;
    }

    public void saveOrUpdate(T t){
        if(t.getID() == null){
            abstractJPADao.save(t);
        }else
            abstractJPADao.update(t);
    }

    public void delete(ID id){
        abstractJPADao.delete(id);
    }

    public T loadById(ID id){
        return abstractJPADao.loadById(id);
    }

    public List<T> loadAll(){
        return abstractJPADao.loadAll();
    }
}
