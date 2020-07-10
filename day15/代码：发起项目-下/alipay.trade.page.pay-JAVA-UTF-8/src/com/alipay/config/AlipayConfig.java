package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	// 我们使用沙箱环境提供的AppId
	public static String app_id = "2016080400166558";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDQcMyQIyGy2yh7xVrDkXeobY9OHR8qXCgrbVZGlBKUhbWlKSHAFfZrpZzqAT01O7v95pLnbB5wnPVXLcAJSq/AZCaQHJR99yYCJuqe/XF/GrnDHWFAj84+q0G1yGpDZaf00jxLG+vNyYIYUHzMyijk0VDHEOGg6AjawTO0Zm01QyDTEeLvO3F5LqOVP7eTOM9p3OxV0+YoEIz9fRYHwkTORLqyuYSg6kiMxIvdUpGHQbpe4E4xy+oG0A8E3TG626DwX7zdHMVbbA+nErWq2x8Tgx500PjZab1GiBvk6fIWLTESlwvqd9HNyqai7szYqDpUS5xkqX+2ptctIeybbWffAgMBAAECggEBAJc+4hBMja08PRniUEPMD+lU5kEl/HE+QZ+RTKMV2o2OoAlh2S2KQi5GE5/wmjtARt6rKjlmSIgqPBOwDMIxQWn2wcycEFt+tEOnfWM0P+CcweIENYclUeBDYADJleGlp8OLsVhGwEmoSA/gh04J+rZd86EebLnW5GXm/t+N2vxjk4y2H3IfdNaG2yQFX9SpKOW69RWenDfNi6T4Dgfjy2sJB/f9f6OGRM5trbAOk+NsjGjqxVrVhUwnYmSQ2p7mPx7V3lcy3WgBNMcecCdRFj6CqB40bFqV6y6M0RQQEeckBbEHmJ/JQfWIo47JI6chT3IaPvQ5ug42D+mcJKHp7QECgYEA8tYCZDBhT99ThMzf94i5J5JDe9BNJWCxaa1ucmvgxdm+hRq8vVYXfJ0evA7X7Zg2KoubYhELNqAO3lG6oddXepWylIejlsxXIRJLcdB2BTS7xbOFzvo8eS6PTirwHupGf+ieuaY/Q/inbxX/UMqeCGLZkqpm/f9oALqgNhMV2MECgYEA2712niaS3HqUjpnb7GOONvANJRvEQ50UzrzKsh9rLGyETFlZfhr/ipFUKAqIycHYG85dMGbZnT7I8zjcj7I+OxBDKevufh7FXJ17auI8t64WOF/7L3nOirA8E3UrocGtXZkN0EXIYIhjpl1VBeZIsVaGZGQ4KIvYH2S8W6PFyJ8CgYEAn8YPbLwoStU1rnreIY/jwxWJMT2shJtKH63srXwtOAA8Snd9F1Y9vc/jGPjrOXicqwGQCsYMCrTlE4HSuglllVJJXVChYeawrSHMYeY2wNYhdcLYl4Yto83unA/ETZL3L9FuHdg0aBSClaRziETIFdx0KvvTJ+uUEma4YtvL1AECgYEAmBJPw/V4D6O5qdKrE7Z2VmjdAABuXEiafNTFBm6d8hmLmXcAazht/0zCTA+2SMKhN+UiMvwKwDsSQNjqM3wsex2vDZUc8SWEeqr2HatCT+/nqs4p/No0aWC7ws+FCaYKv8rLd4bDvKLHK/xNeg674ha6XUHKZ60YPemuPVFi8IsCgYEAssHWMReodRfdbtHSSVR364LAooB8zOfiB0v4huR9Yhtef5UtOew4Y1FsMcu5lWtcde6cRa3hW1yHJ1EsECDayJjAixNO5aRgd7BayUeYx8nUQvwb2z4+EaFRT6/a+uMGMlOgOHuacg1F0OJcvU17HWafOdGOCIvpXKkP5vFbfS4=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmthQwmxlCowktqwc+237Enxs7FfNoVMi9BlCA430Vor2Z1IPIDOOdarYdOQLMxl/PxZfgl/6iMRJB43kzfPVFezJ9xim8AC07ZCVi1NZop3q6qhL3s7w5o809BvkaIVnThpSfvifO3wUxBImXwnSfLaD9CMjtNbD4ri1sDQ3CV+g66nR3oIQTfEMAif7GafDkt4nnG+lcd7tOoOsM+6anP8t6M+KDzcpBZ3wsPEIlJVIQgLbBx61g5QZ/p+piDwl0h85QTnz68qHXCE3JRn8MDWOarKEQkFXbuAis2YbJ8agVDpBomrok2i71jdJn863TLsvB76kRjeq1Ygf5YhQWQIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 这里我们使用NATAPP提供的隧道地址
	public static String notify_url = "http://thc4a7.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 这里我们使用NATAPP提供的隧道地址
	public static String return_url = "http://thc4a7.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	// public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 我们使用沙箱环境的支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 保存日志文件的路径
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

