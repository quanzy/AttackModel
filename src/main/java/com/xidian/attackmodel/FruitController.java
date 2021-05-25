package com.xidian.attackmodel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: quan
 * @Date: 2021/05/19/23:39
 * @Description:
 */
@Controller
public class FruitController {
    @RequestMapping("/fruit")
    public String fruit(Model model){
        return "fruit";
    }

    @RequestMapping("/fruit/detail")
    public String detail(Model model,int id) {

        List<Fruit> fruits = new ArrayList<>();

        if(id == 0) {
            String[] strings={"香蕉","苹果","凤梨","西瓜"};
            for(int i = 1; i <= strings.length; i++) {
                fruits.add(new Fruit(i,strings[i-1]));
            }
        } else if(id == 1) {
            String[] strings={"菠萝","草莓","西红柿","黑莓","百香果","葡萄"};
            for(int i = 1; i <= strings.length; i++) {
                fruits.add(new Fruit(i,strings[i-1]));
            }
        }
        model.addAttribute("fruits",fruits);
        return "fruit::fruit-list";
    }

}
