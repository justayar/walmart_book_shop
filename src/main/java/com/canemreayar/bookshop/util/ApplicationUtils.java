package com.canemreayar.bookshop.util;

import com.canemreayar.bookshop.constants.ApplicationConstants;
import com.canemreayar.bookshop.formbean.review.ItemReviewBean;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ApplicationUtils {

    public static ModelAndView getModelAndView(String viewName,String modelName,Object modelObject){

        ModelAndView modelAndView = new ModelAndView(viewName,modelName,modelObject);

        modelAndView.addObject("assetsUrl", ApplicationConstants.ASSETS_URL);

        return modelAndView;

    }

    public static void setNumberOfStars(List<ItemReviewBean> itemReviewBeanList){

        if(itemReviewBeanList != null){

            for(ItemReviewBean itemReviewBean : itemReviewBeanList){

                if(itemReviewBean != null){

                    if(itemReviewBean.getOverallRating() != null){
                        itemReviewBean.setNumberOfStars(Integer.parseInt(itemReviewBean.getOverallRating().getRating()));
                    }

                }
            }
        }
    }


}
