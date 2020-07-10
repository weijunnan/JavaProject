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

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号（使用沙箱环境的APPID）
	public static String app_id = "2016101800716558";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYZt9OA6XVPf9YcbDwaPADIFtCzBj3HbQjI9m/3Zu+xhMdBmq4IjvgxmqyhPDfrYFVZgAbelIjkT58hCb0wR/6+0GftcIY2bwrdKq/SiBDY9jqo9m572+HUSiEyCvnDbEKr6zeZ+sLIEX1e3Ib4zshsmzweI5qUMRkmI6/lNjh4KW7OeqvsmzNMijC0UVcQNLF06B4+b3Jky8uBhOAI334KOYE+YEe7/Y9EfDNCHNqC7o5+91obOD0HvfrbFXNF9Q7zdMMVcFzuOrhMRMy6ixsQGtcXrLMP47Pj169ow2w4paOAgszR5yW9T4Y+B/2t4mVjfaZzdMLnfdwf8s755KxAgMBAAECggEAe0MI7UJKCDTCp7gckfVt2jl7VoVY09W0co92eJY2d5AguWMNQax+nYgdmBGp+F+OsZF0GMVQVfANiAwirebdhNNe+lu5hvvkE4mi6GB9w8OoF+86FAayP9HGYc68o34RaUE5IhEOq8sIikmzuxaIJvL25W+8UATPM0Wofw9WcylGo5+rKMvOLzU5vbeeh3SPr6djsm4sYRHKhEJDkqnccOOVPwx3buIO7tzaSFZc7oCg2jc4vZLQgt0qu4CHRSGs6iyNIQ0N3aY0tamTXi8Se5i6hE0gCIqjI+AvpKpvZY0VtsXVxKMiqaXEaMN59hOIcyCJdmmgYxk57Lm65qlcAQKBgQDzWV8ehBnjjD2v0oWfn4rr3Df5qNkME8LbtDocAb0VMIkmSGlmmxJ2iZVy+i2hWr9PqnzRNO2J5PdctNVj/LR9L2Cjuyccahplje6Izm9HNfhOczrWnG9EGE/ocbGZpyFH9x9corYnbs2kaMzvtNu5KB5QmymEPVLFCBrQ/VSbIQKBgQCgUx9uwMxTEeXVgjis5i6oJ7ZGloyh/RHJ/rRomXfUTaV+3xYpljN1KwVeIDQElVK8jdqVhfruIceEh67RkDUK+QYJZY2BCy8FnteqUU3juKWujt27ahgydXivntHHuei9X1ZNCFu3fjeCR/l87NcPK8b3Kq7Sq76Ng67/mAIVkQKBgQCqQH2u4Ocn7ub9isEX80wDRdgXoEzyCSVMBuSc0Y6TM5jQotqzAY1CR3G6tlOUTuQH/ZRD3c7OqdVyE8YzpQo1hx8KjhaH56e+IzWemyb5YEXvxOiGW33w2z2Ut250vJwpODjF28SrA/d1riirEBKlkO7coCHEtg6hcNEqJAK8YQKBgClDu79h2DU5UhKWJcg6pp+ZOQ0KCsBWxpFbAUw60+DM61+wQ6AIjM4HeKY1W64iUN0/FZeOmHtaLmQqGBDQMRbV6XvZq4YfPscPjyrDKm0GRX6cPu3R7NBv89Qf6Jajfwfe1fOVxyV/UwIxTEGfI+s/tUJAtiZ7FdyOnCglE8RBAoGAL1YRvgQSB8n9kkeLXPMjZF+HS6kec4C5Xv3vecyl2VJ3/yqcY34QMTi4EURX0eGqUSFX9oP59FAL1Wf8Kvyt/tNV5gpHzqxbj7nG1GFy+IKB4emFN3f0ianWIRbbQ0XecY90k5ijdTaLfzW+w7Xsgia5h2Rp4rapFbzYOFDiTlY=";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA1t7QC0UZk4KBH3YD+AwXvFpamX9xTAsPKsXbbRVUR1gFN9syX/Mg4NpaUkIFr5Im9gIOI9Gr7WDyMZ61oSQGttS7S/qf10j8MZOqvLeKguPPEaqNqm205q4rQk2R5jKMpjDK3lwBJ7PkuaJyJ8YUHz6uS1Wvb1ZxitxLL2SBwTdPlS/HUnOpq3Z1A7DEjYc3gcvJ5dYMDGfpRQQvrkVBZCByHMcFjuB8rFJ+USeFQevtGNYj/YTiLrTVnb/Zmu2+bNWm8MfOuIn2Z+9D5HbFxxQL3XorU1Ud+YMfNJXWzGXEuzO7duk3qM1nhG13LrXQ+SSGvbGUFodzpCs25iJaOwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    // 工程公网访问地址使用内网穿透客户端提供的域名
	public static String notify_url = "http://a8it2z.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	// 工程公网访问地址使用内网穿透客户端提供的域名
	public static String return_url = "http://a8it2z.natappfree.cc/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关（正式环境）
	// public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
	
	// 支付宝网关（沙箱环境）
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 日志路径
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

