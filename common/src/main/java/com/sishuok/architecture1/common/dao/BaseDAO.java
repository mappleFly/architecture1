package com.sishuok.architecture1.common.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseDAO<M,QM> {

    public void create(M cm);

    public void update(M cm);

    public void delete(@Param("uuid")int uuid);

    public M getByUuid(@Param("uuid")int uuid);

    public List<M> getByConditionPage(QM cqm);

}
