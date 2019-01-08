package com.sishuok.architecture1.common.service;

import com.sishuok.architecture1.common.vo.BaseModel;
import com.sishuok.pageutil.Page;
import org.apache.ibatis.annotations.Param;

public interface IBaseService<M,QM extends BaseModel> {

    public void create(M cm);

    public void update(M cm);

    public void delete(@Param("uuid")int uuid);

    public M getByUuid(@Param("uuid")int uuid);

    public Page<M> getByConditionPage(QM cqm);
}
