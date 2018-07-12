/**
 * Copyright (C), 2017-2018, 普惠时代
 * FileName: PreFilter
 * Author:   user
 * Date:     2018/7/9 14:27
 * Description: PreFilter过滤
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.loan.apigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 〈一句话功能简述〉<br> 
 * 〈PreFilter过滤〉
 *
 * @author user
 * @create 2018/7/9
 * @since 1.0.0
 */
@Component
public class PreFilter extends ZuulFilter {
private Logger logger= Logger.getLogger(PreFilter.class);
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest req = ctx.getRequest();
        if (req.getServletPath().indexOf("v2")>=0||req.getServletPath().indexOf("swagger")>=0||req.getServletPath().indexOf("/webjars")>=0||req.getServletPath().indexOf("/errorRequest")>=0||req.getServletPath().indexOf("html")>=0||req.getServletPath().indexOf("loanArticle")>=0) {
            return false;
        }
        return false;
    }

    @Override
    public Object run(){
        logger.info("This is a preFilter");
        System.out.println("This is a preFilter");
        RequestContext ctx=RequestContext.getCurrentContext();
        HttpServletRequest request=ctx.getRequest();
        Throwable throwable = ctx. getThrowable () ;
        logger.info(new Date()+"--send:"+request.getMethod()+"-requset to:"+request.getRequestURL().toString());
        System.out.println(new Date()+"--send:"+request.getMethod()+"-requset to:"+request.getRequestURL().toString());
        Object accessToken=request.getParameter("accessToken");
        if(accessToken==null){
            logger.info("accessToken is Null");
            System.out.println("accessToken is Null");
//            ctx.set("error.status_code",HttpServletResponse.SC_GONE);
//            ctx.set("SEND_ERROR_FILTER_RAN",false);
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(HttpServletResponse.SC_GONE);
            try {
                handleEx();
            }
            catch (Exception e){
                System.out.println("异常抛出");
                ctx.setThrowable(e);
                ctx.set("sendErrorFilter.ran",false);
                ctx.set("error.exception",e);
                System.out.println(!ctx.getBoolean("sendErrorFilter.ran", false));
                System.out.println(ctx.getThrowable() != null);
                System.out.println(ctx.getThrowable() != null
                        && !ctx.getBoolean("sendErrorFilter.ran", false));
            }
        }
        else {
            if(!accessToken.toString().equals("Token")){
                logger.info("accessToken is error");
                System.out.println("accessToken is error");
            }
            else
            {
                System.out.println("accessToken is OK");
                logger.info("accessToken is OK");
            }
        }
        return null;
    }
    private void handleEx(){
        System.out.println("handleEX");
        throw  new RuntimeException("ACESS_TOKEN 不合法");
    }
}