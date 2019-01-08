package com.sishuok.architecture1.customermgr.web;


import com.sishuok.architecture1.customermgr.service.ICutomerService;
import com.sishuok.architecture1.customermgr.vo.CustomerModel;
import com.sishuok.architecture1.customermgr.vo.CustomerQueryModel;
import com.sishuok.pageutil.Page;
import com.sishuok.util.format.DateFormatHelper;
import com.sishuok.util.json.JsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    private ICutomerService ics = null;

    @RequestMapping(value = "toAdd",method = RequestMethod.GET)
    public String toAdd(){
        return "customer/add";
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public String add(@ModelAttribute("cm") CustomerModel cm){
        cm.setRegisterTime(DateFormatHelper.long2str(new Date().getTime()));
        ics.create(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{customerUuid}",method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") int customerUuid){
        CustomerModel cm = ics.getByUuid(customerUuid);
        model.addAttribute("cm",cm);
        return "customer/update";
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public String update(@ModelAttribute("cm") CustomerModel cm){
        ics.update(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toDelete/{customerUuid}",method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("customerUuid") int customerUuid){
        CustomerModel cm = ics.getByUuid(customerUuid);
        model.addAttribute("cm",cm);
        return "customer/delete";
    }

    @RequestMapping(value = "delete",method = RequestMethod.GET)
    public String delete(@RequestParam("uuid") int customerUuid){
        ics.delete(customerUuid);
        return "customer/delete";
    }

    @RequestMapping(value = "toList",method = RequestMethod.GET)
    public String list(@ModelAttribute("wm") CustomerWebModel wm,Model model){
        CustomerQueryModel cqm = null;
        if(wm.getQueryJsonStr()==null || wm.getQueryJsonStr().trim().length()==0){
            cqm = new CustomerQueryModel();
        }else {
            cqm = (CustomerQueryModel)JsonHelper.str2Object(wm.getQueryJsonStr(),CustomerQueryModel.class);
        }
        cqm.getPage().setNowPage(wm.getNowPage());

        if(wm.getPageShow()>0){
            cqm.getPage().setPageShow(wm.getPageShow());
        }

        Page dbPage = ics.getByConditionPage(cqm);

        model.addAttribute("wm",wm);
        model.addAttribute("page",dbPage);
        System.out.println("测试333:"+wm);
        return "customer/list";
    }

    @RequestMapping(value = "toQuery",method = RequestMethod.GET)
    public String toQuery(){
        return "customer/query";
    }

}
