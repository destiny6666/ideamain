package returnUtil;

//返回消息的工具类
public class ReturnEntityUtils {
	
	//加密验证失败
	public static final MyReturnEntity ENCRYFAIL_RETURN=new MyReturnEntity(401,"Invalid encry","非法加密");
	//cookie验证失败
	public static final MyReturnEntity COOKIEFAIL_RETURN=new MyReturnEntity(401, "Invalid Cookie", "非法 Cookie");
	//header验证失败
	public static final MyReturnEntity HEADERFAIL_RETURN=new MyReturnEntity(401, "Invalid Header", "非法 Header");
	//成功返回,调用时需要.set() 设置返回数据
	public static final MyReturnEntity SUCCESS_RETURN=new MyReturnEntity();
	//错误返回
	public static final MyReturnErrorEntity ERROR_RETURN=new MyReturnErrorEntity();

}
