package com.loan.regloginservice.reglogin.entity;

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
}
