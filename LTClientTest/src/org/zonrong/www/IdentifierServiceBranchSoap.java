/**
 * IdentifierServiceBranchSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public interface IdentifierServiceBranchSoap extends java.rmi.Remote {

    /**
     * 单笔查询带机构信息
     */
    public org.zonrong.www.BranchResponse singleCheckBranch(org.zonrong.www.CheckRequest request, org.zonrong.www.Branch branch, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 单笔查询
     */
    public org.zonrong.www.CheckResponse singleCheck(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 取得缓存数据的记录条数
     */
    public org.zonrong.www.QueryRecordCountResponse queryCizitenDataCount(org.zonrong.www.QueryCizizenRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 取得缓存中的数据
     */
    public org.zonrong.www.QueryCitizenResponse queryCizitenData(org.zonrong.www.QueryCizizenRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 是否查询过该用户的资料
     */
    public org.zonrong.www.IsCitizenExistsResponseCode isCitizenExists(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 取得最近的一次历史记录
     */
    public org.zonrong.www.GetCitizenResponse getCitizenDataAndWriteLog(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;
    public org.zonrong.www.GetCitizenResponse getCitizenData(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 查询消费历史
     */
    public org.zonrong.www.QueryHistoryResponse queryHistoryData(org.zonrong.www.QueryHistoryRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 查询消费历史(记录条数)
     */
    public org.zonrong.www.QueryRecordCountResponse queryHistoryDataCount(org.zonrong.www.QueryHistoryRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 查询余额
     */
    public org.zonrong.www.QueryFeeResponse queryFeeData(org.zonrong.www.QueryFeeRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 用户登录
     */
    public org.zonrong.www.LoginResponse login(org.zonrong.www.LoginUserData request) throws java.rmi.RemoteException;

    /**
     * 修改密码
     */
    public org.zonrong.www.LoginResposeCode modifyPassword(org.zonrong.www.ModifyPwdRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 查询账号
     */
    public org.zonrong.www.QueryAccountResponse queryAccount(org.zonrong.www.QueryAccountRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 创建一个新的账号
     */
    public org.zonrong.www.ResponseCode createNewAccount(org.zonrong.www.AccountData data, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 修改账号资料
     */
    public org.zonrong.www.ResponseCode modifyAccount(org.zonrong.www.AccountData data, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 拨款
     */
    public org.zonrong.www.ResponseCode allocateFunds(java.lang.String userIdAllocatee, java.math.BigDecimal money, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException;

    /**
     * 上传疑义数据到服务器
     */
    public org.zonrong.www.ResponseCode uploadUnsureData(org.zonrong.www.UnsureData data, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException;

    /**
     * 查询疑义数据
     */
    public org.zonrong.www.QueryUnsureDataResponse queryUnsureData(org.zonrong.www.QueryUnsureDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException;

    /**
     * 查询疑义数据(记录条数)
     */
    public org.zonrong.www.QueryRecordCountResponse queryUnsureDataCount(org.zonrong.www.QueryUnsureDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException;

    /**
     * 业务数据核查比对
     */
    public org.zonrong.www.ResponseCode uploadTransactionDataAndCompare(org.zonrong.www.UploadTransactionDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException;

    /**
     * 查询业务数据数据(记录条数)
     */
    public org.zonrong.www.QueryRecordCountResponse queryTransactionDataCount(org.zonrong.www.QueryTransactionDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException;

    /**
     * 查询业务数据数据
     */
    public org.zonrong.www.QueryTransactionDataResponse queryTransactionData(org.zonrong.www.QueryTransactionDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException;

    /**
     * 版本号
     */
    public java.lang.String getVersion() throws java.rmi.RemoteException;

    /**
     * 版本号
     */
    public void getVersion_3_5_0202_10() throws java.rmi.RemoteException;
}
