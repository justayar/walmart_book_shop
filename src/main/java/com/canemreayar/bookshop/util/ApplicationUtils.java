package com.canemreayar.bookshop.util;

import com.canemreayar.bookshop.constants.BookShopConstants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;


@Component
public class ApplicationUtils {

    private ApplicationUtils(){ }

    public ModelAndView getModelAndView(String viewName,String modelName,Object modelObject){

        ModelAndView modelAndView = new ModelAndView(viewName,modelName,modelObject);

        modelAndView.addObject("assetsUrl", BookShopConstants.ASSETS_URL);

        return modelAndView;

    }

}
