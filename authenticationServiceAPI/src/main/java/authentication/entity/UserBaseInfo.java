package authentication.entity;


import lombok.Data;

import java.util.Date;

@Data
public class UserBaseInfo {
	private Integer id;
	private String userName="";// 用户名
	private String phoneNum="";// 手机号（登录名）
	private String salt="";// 登录密码加密盐
	private String password="";// 登录密码
	private String payPassword="";// 支付密码
	private String paySalt="";// 支付密码加密盐
	private Boolean sex;// 性别
	private String nickName="";// 昵称
	private Date registerTime=new Date();// 注册时间
	private Integer userOrigin;// 用户来源（1、信贷管理系统录入；2、车贷管理系统录入 3、IOS；4、Android 5.网站录入）
	private String userHeadPicUrl="";// 用户头像URL
	private String fuyouPhoneNum="";// 金账户手机号
	private Integer isEnd=-1;//是否认证完成(-1：未认证 0：认证中 1：认证成功)
	// 身份认证信息
	private String cardId="";// 身份证号
	private String cardOffice="";// 签证机关
	private String usefulLife="";// 有效期限
	private String cardPicUrl1="";// 身份证正面照片路径
	private String cardPicUrl2="";// 身份证反面照片路径
	private String cardPicUrl3="";// 手持身份证图片路径
	private Boolean cardIsEnd=false;//身份认证是否完成
	// 联系信息
	private Integer provinceId=-1;// 省份Id
	private Integer cityId=-1;// 城市Id
	private Integer nextCityId=-1;//县、区Id
	private String address="";// 详细地址
	private String liveLong="";// 现居住时长
	private Integer isMarry;// 婚姻状况??/数据库
	private String contactPerson1="";// 紧急联系人1
	private String person1Relation="";// 紧急联系人1与当事人关系
	private String person1Phone="";// 紧急联系人1联系方式
	private String contactPerson2="";// 紧急联系人2
	private String person2Relation="";// 紧急联系人2与当事人关系
	private String person2Phone="";// 紧急联系人2联系方式
	private String contactPerson3="";// 紧急联系人3
	private String person3Relation="";// 紧急联系人3与当事人关系
	private String person3Phone="";// 紧急联系人3联系方式
	private String email="";// 电子邮箱
	private Boolean contactIsEnd=false;//联系信息是否认证完成
	// 工作信息
	private Integer industryId=-1;// 所属行业名称???
	private String companyPost="";// 公司职位
	private String companyName="";// 公司名称
	private Integer companyProvinceId=-1;// 公司所在省份Id
	private Integer companyCityId=-1;// 公司所在城市Id
	private Integer companyNextCityId=-1;//县、区Id
	private String companyAddress="";// 公司地址
	private String workLong="";// 现工作时长
	private String incomeAmountPerMonth="";// 月总收入
	private Boolean workIsEnd=false;//工作信息是否认证完成
	// 银行卡实名认证
	private String bankCardNo="";// 银行卡号
	private String bankId="";// 银行Id
	private Integer bankDepositProvinceId=-1;// 开户行地址省份id
	private Integer bankDepositCityId=-1;// 开户行地址城市Id
	private Integer bankNextCityId=-1;//县、区Id
	private String bankDepositCode="";// 开户行地址编码（金账户）
	private String bankReservedPhone="";// 银行预留手机号
	private Boolean bankIsEnd=false;//银行卡信息是否认证完成
	//手机号认证
	private String phoneServerPwd;//手机服务密码
	private Boolean phoneIsEnd=false;//手机号是否认证完成

	private Integer autoLimit=-1;// 现金贷系统计算额度？？
	private Integer checkedLimit=0;// 现金贷人工审核额度
	private Integer authenticationStatus=0;// 认证状态(0:未认证 1：认证成功 2、认证不通过）
	private Integer loanType=0;// 当前借款类型（0：未借款 1、现金贷 2、信贷 3、车贷）
	private Integer workFlowStatus=0;// 业务件当前状态（0：未借款 1：借款中 2：还款中 3：流程结束）
	private String customerManager="";// 客户经理Id
	private String failCause;//认证失败原因
	//xml中单独字段
	private String phoneReportUrl;//手机号认证报告地址 
	private Integer fileUploadStatus;//附件上传状态 0：未上传  1：已上传
	private Integer addFileStatus;//补件状态（0：不需要补件 1：需要补件）
	//停留时间
	private String cardStayTime;//身份证页面停留时间 
	private String contactStayTime;//联系人页面停留时间
	private String workStayTime;//工作信息停留时间
	private String bankStayTime;//银行卡页面停留时间
	private String phoneStayTime;//手机认证停留时间
	//公众号
	private String openid;//公众号用户唯一标识
	private Date lastlogintime;//最后登录时间
	//正在申请表单的类型
	private Integer applyingType;
	//记录页面停留时间
	
	// 更新身份证认证

	/*public UserBaseInfo(String userName, boolean sex, String cardId, String cardOffice, String usefulLife,
			String cardPicUrl) {
		super();
		this.userName = userName;
		this.sex = sex;
		this.cardId = cardId;
		this.cardOffice = cardOffice;
		this.usefulLife = usefulLife;
		this.cardPicUrl = cardPicUrl;
	}*/

	public UserBaseInfo() {
		super();
	}
	public  static UserBaseInfo merge(UserBaseInfo userBaseInfo, UserBaseInfo ubi) {
		if (ubi.getUserName() != null && ubi.getUserName() != "") {
			userBaseInfo.setUserName(ubi.getUserName());
		}
		if (ubi.getPhoneNum() != null && ubi.getPhoneNum() != "") {
			userBaseInfo.setPhoneNum(ubi.getPhoneNum());
		}
		if (ubi.getSalt() != null && ubi.getSalt() != "") {
			userBaseInfo.setSalt(ubi.getSalt());
		}
		if (ubi.getPassword() != null && ubi.getPassword() != "") {
			userBaseInfo.setPassword(ubi.getPassword());
		}
		if (ubi.getPayPassword() != null && ubi.getPayPassword()!= "") {
			userBaseInfo.setPayPassword(ubi.getPayPassword());
		}
		if (ubi.getPaySalt() != null && ubi.getPaySalt() != "") {
			userBaseInfo.setPaySalt(ubi.getPaySalt());
		}
		if (ubi.getSex()!=null) {
			userBaseInfo.setSex(ubi.getSex());
		}
		if (ubi.getNickName() != null && ubi.getNickName() != "") {
			userBaseInfo.setNickName(ubi.getNickName());
		}
		if (ubi.getRegisterTime() != null) {
			userBaseInfo.setRegisterTime(ubi.getRegisterTime());
		}
		if (ubi.getUserOrigin() != null) {
			userBaseInfo.setUserOrigin(ubi.getUserOrigin());
		}
		if (ubi.getUserHeadPicUrl() != null && ubi.getUserHeadPicUrl() != "") {
			userBaseInfo.setUserHeadPicUrl(ubi.getUserHeadPicUrl());
		}
		if (ubi.getFuyouPhoneNum() != null && ubi.getFuyouPhoneNum() != "") {
			userBaseInfo.setFuyouPhoneNum(ubi.getFuyouPhoneNum());
		}
		// 身份认证信息
		if (ubi.getCardId() != null && ubi.getCardId() != "") {
			userBaseInfo.setCardId(ubi.getCardId());
		}
		if (ubi.getCardOffice() != null && ubi.getCardOffice() != "") {
			userBaseInfo.setCardOffice(ubi.getCardOffice());
		}
		if (ubi.getUsefulLife() != null && ubi.getUsefulLife() != "") {
			userBaseInfo.setUsefulLife(ubi.getUsefulLife());
		}
		if (ubi.getCardPicUrl1() != null && ubi.getCardPicUrl1() != "") {
			userBaseInfo.setCardPicUrl1(ubi.getCardPicUrl1());
		}
		if (ubi.getCardPicUrl2() != null && ubi.getCardPicUrl2() != "") {
			userBaseInfo.setCardPicUrl2(ubi.getCardPicUrl2());
		}
		if (ubi.getCardPicUrl3() != null && ubi.getCardPicUrl3() != "") {
			userBaseInfo.setCardPicUrl3(ubi.getCardPicUrl3());
		}
		if (ubi.getCardIsEnd()) {
			userBaseInfo.setCardIsEnd(ubi.getCardIsEnd());
		}
		// 联系信息
		if (ubi.getProvinceId() != null &&ubi.getProvinceId() != -1) {
			userBaseInfo.setProvinceId(ubi.getProvinceId());
		}
		if (ubi.getCityId() != null &&ubi.getCityId() != -1) {
			userBaseInfo.setCityId(ubi.getCityId());
		}
		if (ubi.getNextCityId() != null&&ubi.getNextCityId() != -1) {
			userBaseInfo.setNextCityId(ubi.getNextCityId());
		}
		if (ubi.getAddress() != null && ubi.getAddress() != "") {
			userBaseInfo.setAddress(ubi.getAddress());
		}
		if (ubi.getLiveLong() != null && ubi.getLiveLong() != "") {
			userBaseInfo.setLiveLong(ubi.getLiveLong());
		}
		if (ubi.getIsMarry() != null) {
			userBaseInfo.setIsMarry(ubi.getIsMarry());
		}
		if (ubi.getContactPerson1() != null && ubi.getContactPerson1() != "") {
			userBaseInfo.setContactPerson1(ubi.getContactPerson1());
		}
		if (ubi.getPerson1Relation() != null&&ubi.getPerson1Relation() !="") {
			userBaseInfo.setPerson1Relation(ubi.getPerson1Relation());
		}
		if (ubi.getPerson1Phone() != null && ubi.getPerson1Phone() != "") {
			userBaseInfo.setPerson1Phone(ubi.getPerson1Phone());
		}
		if (ubi.getContactPerson2() != null && ubi.getContactPerson2() != "") {
			userBaseInfo.setContactPerson2(ubi.getContactPerson2());
		}
		if (ubi.getPerson2Relation() != null&&ubi.getPerson2Relation() !="") {
			userBaseInfo.setPerson2Relation(ubi.getPerson2Relation());
		}
		if (ubi.getPerson2Phone() != null && ubi.getPerson2Phone() != "") {
			userBaseInfo.setPerson2Phone(ubi.getPerson2Phone());
		}
		if (ubi.getContactPerson3() != null && ubi.getContactPerson3() != "") {
			userBaseInfo.setContactPerson3(ubi.getContactPerson3());
		}
		if (ubi.getPerson3Relation() != null&&ubi.getPerson3Relation() !="") {
			userBaseInfo.setPerson3Relation(ubi.getPerson3Relation());
		}
		if (ubi.getPerson3Phone() != null && ubi.getPerson3Phone() != "") {
			userBaseInfo.setPerson3Phone(ubi.getPerson3Phone());
		}
		if (ubi.getEmail() != null && ubi.getEmail() != "") {
			userBaseInfo.setEmail(ubi.getEmail());
		}
		if (ubi.getContactIsEnd()) {
			userBaseInfo.setContactIsEnd(ubi.getContactIsEnd());
		}
		// 工作信息
		if (ubi.getIndustryId() != null&&ubi.getIndustryId() != -1) {
			userBaseInfo.setIndustryId(ubi.getIndustryId());
		}
		if (ubi.getCompanyPost() != null && ubi.getCompanyPost() != "") {
			userBaseInfo.setCompanyPost(ubi.getCompanyPost());
		}
		if (ubi.getCompanyName() != null && ubi.getCompanyName() != "") {
			userBaseInfo.setCompanyName(ubi.getCompanyName());
		}
		if (ubi.getCompanyProvinceId() != null&&ubi.getCompanyProvinceId() != -1) {
			userBaseInfo.setCompanyProvinceId(ubi.getCompanyProvinceId());
		}
		if (ubi.getCompanyCityId() != null&&ubi.getCompanyCityId() != -1) {
			userBaseInfo.setCompanyCityId(ubi.getCompanyCityId());
		}
		if (ubi.getCompanyNextCityId() != null&&ubi.getCompanyNextCityId() != -1) {
			userBaseInfo.setCompanyNextCityId(ubi.getCompanyNextCityId());
		}
		if (ubi.getCompanyAddress() != null && ubi.getCompanyAddress() != "") {
			userBaseInfo.setCompanyAddress(ubi.getCompanyAddress());
		}
		if (ubi.getWorkLong() != null && ubi.getWorkLong() != "") {
			userBaseInfo.setWorkLong(ubi.getWorkLong());
		}
		if (ubi.getIncomeAmountPerMonth() != null&& ubi.getIncomeAmountPerMonth() != "") {
			userBaseInfo.setIncomeAmountPerMonth(ubi.getIncomeAmountPerMonth());
		}
		if (ubi.getWorkIsEnd()) {
			userBaseInfo.setWorkIsEnd(ubi.getWorkIsEnd());
		}
		// 银行卡实名认证
		if (ubi.getBankCardNo() != null && ubi.getBankCardNo() != "") {
			userBaseInfo.setBankCardNo(ubi.getBankCardNo());
		}
		if (ubi.getBankId() != null && ubi.getBankId() != "") {
			userBaseInfo.setBankId(ubi.getBankId());
		}
		if (ubi.getBankDepositProvinceId() != null&&ubi.getBankDepositProvinceId() != -1) {
			userBaseInfo.setBankDepositProvinceId(ubi.getBankDepositProvinceId());
		}
		if (ubi.getBankDepositCityId() != null&&ubi.getBankDepositCityId() != -1) {
			userBaseInfo.setBankDepositCityId(ubi.getBankDepositCityId());
		}
		if (ubi.getBankNextCityId() != null&&ubi.getBankNextCityId() != -1) {
			userBaseInfo.setBankNextCityId(ubi.getBankNextCityId());
		}
		if (ubi.getBankDepositCode() != null && ubi.getBankDepositCode() != "") {
			userBaseInfo.setBankDepositCode(ubi.getBankDepositCode());
		}
		if (ubi.getBankReservedPhone() != null && ubi.getBankReservedPhone() != "") {
			userBaseInfo.setBankReservedPhone(ubi.getBankReservedPhone());
		}
		if (ubi.getBankIsEnd()) {
			userBaseInfo.setBankIsEnd(ubi.getBankIsEnd());
		}
		//手机号认证
		if (ubi.getPhoneServerPwd() != null && ubi.getPhoneServerPwd() != "") {
			userBaseInfo.setPhoneServerPwd(ubi.getPhoneServerPwd());
		}
		if (ubi.getPhoneIsEnd()) {
			userBaseInfo.setPhoneIsEnd(ubi.getPhoneIsEnd());
		}
		//页面停留时间
		if (ubi.getCardStayTime() != null && !("".equals(ubi.getCardStayTime()))) {
			userBaseInfo.setCardStayTime(ubi.getCardStayTime());
		}
		if (ubi.getContactStayTime() != null && !("".equals(ubi.getContactStayTime()))) {
			userBaseInfo.setContactStayTime(ubi.getContactStayTime());
		}
		if (ubi.getWorkStayTime() != null && !("".equals(ubi.getWorkStayTime()))) {
			userBaseInfo.setWorkStayTime(ubi.getPassword());
		}
		if (ubi.getBankStayTime() != null && !("".equals(ubi.getBankStayTime()))) {
			userBaseInfo.setBankStayTime(ubi.getBankStayTime());
		}
		if (ubi.getPhoneStayTime() != null && !("".equals(ubi.getPhoneStayTime()))) {
			userBaseInfo.setPhoneStayTime(ubi.getPhoneStayTime());
		}
		if (ubi.getOpenid() != null && ubi.getOpenid() != "") {
			userBaseInfo.setOpenid(ubi.getOpenid());
		}
		/*if (ubi.getLastlogintime() != null) {
			userBaseInfo.setLastlogintime(ubi.getLastlogintime());
		}*/
		return userBaseInfo;
	}
	public UserBaseInfo(Integer id, Integer applyingType) {
		super();
		this.id = id;
		this.applyingType = applyingType;
	}

}
