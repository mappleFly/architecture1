package com.sishuok.architecture1.common.service;

import com.sishuok.architecture1.common.dao.BaseDAO;
import com.sishuok.architecture1.common.vo.BaseModel;
import com.sishuok.pageutil.Page;

import java.util.List;

public class BaseService<M,QM extends BaseModel> implements IBaseService<M,QM> {

    private BaseDAO dao = null;

    public void setDAO(BaseDAO dao){
        this.dao = dao;
    }

    @Override
    public void create(M cm) {
        dao.create(cm);
    }

    @Override
    public void update(M cm) {
        dao.update(cm);
    }

    @Override
    public void delete(int uuid) {
        dao.delete(uuid);
    }

    @Override
    public M getByUuid(int uuid) {
        return (M)dao.getByUuid(uuid);
    }

    public Page<M> getByConditionPage(QM qm) {
        List<M> list = dao.getByConditionPage(qm);
        qm.getPage().setResult(list);
        return qm.getPage();
    }
}
