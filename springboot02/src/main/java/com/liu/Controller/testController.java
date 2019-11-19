package com.liu.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.FileNotFoundException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.pojo.*;

@Controller
@RequestMapping("/test")
public class testController {

    @RequestMapping("/{name}")
    public String index(@PathVariable(name = "name") String name, HttpServletRequest request)
            throws Exception {
        String classpath = ClassUtils.getDefaultClassLoader().getResource("").getPath();
        //String classpath = request.getServletContext().getRealPath("");

//        User user = new User();
//        LV_Collection collection = user.getCollection();

        System.out.println(URLDecoder.decode(classpath, "UTF-8"));
        return "" + name;

    }


//    @RequestMapping("test")
//    public String test(HttpServletResponse resp) throws Exception {
//        //转到支付页面
//        //初始化客户端 只需要实例化一次（线程安全）
//        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipaydev.com/gateway.do"
//                ,"2019101868421921", APP_PRIVATE_KEY, "json", "UTF-8", ALIPAY_PUBLIC_KEY, "RSA2");
//
//        AlipayTradeWapPayRequest alipayRequest = new AlipayTradeWapPayRequest();//创建API对应的request
//
//        //在公共参数中设置回跳和通知地址
//        alipayRequest.setReturnUrl("回跳地址");
//        //异步回调一定是要在外网 不然支付宝服务器无法访问
//        alipayRequest.setNotifyUrl("异步回调地址");
//        alipayRequest.setBizContent("{" +
//                "  \"out_trade_no\":\"" + 2019101868439922 + "\"," +
//                "  \"total_amount\":\"" + fetchParcel.getMoney() + "\"," +
//                "  \"subject\":\"代领快递\"," +
//                "  \"seller_id\":\"2088102169684935\"," +
//                "  \"product_code\":\"QUICK_WAP_PAY\"" +
//                " }");//填充业务参数
//        String form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
//        resp.setContentType("text/html;charset=utf-8");
//        resp.getWriter().write(form);//直接将完整的表单html输出到页面
//        resp..getWriter().flush();
//        return "";
//    }


}
