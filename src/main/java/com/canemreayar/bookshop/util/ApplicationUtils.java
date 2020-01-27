package com.canemreayar.bookshop.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;


@Component
public class ApplicationUtils {


    @Value("${assets.url}")
    private String ASSETS_URL;

    private ApplicationUtils(){ }

    public ModelAndView getModelAndView(String viewName,String modelName,Object modelObject){

        ModelAndView modelAndView = new ModelAndView(viewName,modelName,modelObject);

        modelAndView.addObject("assetsUrl",ASSETS_URL);

        return modelAndView;

    }

}
