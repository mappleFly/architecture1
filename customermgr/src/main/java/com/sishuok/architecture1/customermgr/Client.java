package com.sishuok.architecture1.customermgr;

import com.sishuok.architecture1.customermgr.dao.CustomerDAO;
import com.sishuok.architecture1.customermgr.service.ICutomerService;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;
import com.sishuok.pageutil.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Component
@Transactional
public class Client {

    //测试

    @Autowired
    private ICutomerService s=null;

    public ICutomerService getS(){
        return s;
    }

    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Client client = (Client) ctx.getBean("client");
        //CustomerDAO dao1 = (CustomerDAO)ctx.getBean("customerDAO");
        CustomerModel model = new CustomerModel();
        model.setCustomerId("c2");
        model.setPwd("c2");
        model.setRegisterTime("11");
        model.setShowName("n1");
        model.setTrueName("cc2");
        //client.dao.create(model);


        //分页
        CustomerQueryModel cqm = new CustomerQueryModel();
        cqm.getPage().setNowPage(1);
        cqm.getPage().setPageShow(1);

        Page<CustomerModel> list = client.getS().getByConditionPage(cqm);
        System.out.println("===========结果开始==============");
        System.out.println(list);
        //System.out.println(cqm.getPage());

    }



}
