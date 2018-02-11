package com.qsy.ssm.sms;

import com.google.gson.Gson;
import com.qsy.ssm.code.SMSCode;
import com.qsy.ssm.sms.common.Config;
import com.qsy.ssm.sms.common.HttpUtil;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";

	private static String accountSid = Config.ACCOUNT_SID;
	//private static String to = "1361305****";
	//private static String smsContent = "【秒嘀科技】您的验证码是345678，30分钟输入有效。";

	/**
	 * 验证码通知短信
	 * @return 
	 */
/*	public static void execute()
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
	*/
	public static SMSCode sendSMS(String to,String code){
		
		String smsContent = "【大白兔】登录验证码："+code+"，如非本人操作，请忽略此短信。";
		
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
				+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		Gson gson = new Gson();
		return gson.fromJson(result, SMSCode.class);
		
	}
}
