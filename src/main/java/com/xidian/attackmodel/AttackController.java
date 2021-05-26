package com.xidian.attackmodel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @Author: quan
 * @Date: 2021/05/21/0:07
 * @Description:
 */
@Controller
public class AttackController {

    @RequestMapping("index")
    public ModelAndView getBasic() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        List<AttackType> attackTypeList = AttackDB.getInstance().getAllType();
        modelAndView.addObject("attackTypeList",attackTypeList);
        List<AttackPhase> attackPhaseList = AttackDB.getInstance().getAllPhase();
        modelAndView.addObject("attackPhaseList",attackPhaseList);
        return modelAndView;
    }
    @RequestMapping("/attack/get")
    public String getAttack(Model model, String attackType, String attackMethod) {
        List<AttackVO> attacks = AttackDB.getInstance().getAttackByTypeAndAttack(attackType,attackMethod);
        model.addAttribute("attacks", attacks);
        return "index::attacks";
    }

    @RequestMapping("/attack/detail")
    public String detail(Model model,int id){
        List<AttackVO> attackVOS = AttackDB.getInstance().getData(id);
        model.addAttribute("details",attackVOS);
        return "index::gather";
    }

    @RequestMapping("/attack/getKeyWord")
    public String getKeyWord(Model model, String keyword) {
        System.out.println(keyword);
        List<KeyWordVO> keyWords = AttackDB.getInstance().getKeyWord(keyword);
        model.addAttribute("keywords",keyWords);
        return "index::keyword";
    }

    @RequestMapping("/attack/getAttack")
    public String getAttack(Model model, String keyword, int type) {
        List<AttackVO> attacks = AttackDB.getInstance().getAttackByKeyword(keyword, type);
        model.addAttribute("attacks", attacks);
        return "index::attacks";
    }

    //获得弹窗 中datamethod 信息
    @RequestMapping("/attack/datamethod")
    public String getDatamethod(Model model, String method) {
        List<DataMethod> dataMethods = AttackDB.getInstance().getDataMethodByMethod(method);
        model.addAttribute("datamethods", dataMethods);
        return "index::popup";
    }

    @RequestMapping("/attack")
    public String test() {
        return "index";
    }
}
