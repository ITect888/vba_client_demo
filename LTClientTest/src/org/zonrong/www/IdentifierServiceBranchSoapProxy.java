package org.zonrong.www;

public class IdentifierServiceBranchSoapProxy implements org.zonrong.www.IdentifierServiceBranchSoap {
  private String _endpoint = null;
  private org.zonrong.www.IdentifierServiceBranchSoap identifierServiceBranchSoap = null;
  
  public IdentifierServiceBranchSoapProxy() {
    _initIdentifierServiceBranchSoapProxy();
  }
  
  public IdentifierServiceBranchSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initIdentifierServiceBranchSoapProxy();
  }
  
  private void _initIdentifierServiceBranchSoapProxy() {
    try {
      identifierServiceBranchSoap = (new org.zonrong.www.IdentifierServiceBranchLocator()).getIdentifierServiceBranchSoap();
      if (identifierServiceBranchSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)identifierServiceBranchSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)identifierServiceBranchSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (identifierServiceBranchSoap != null)
      ((javax.xml.rpc.Stub)identifierServiceBranchSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.zonrong.www.IdentifierServiceBranchSoap getIdentifierServiceBranchSoap() {
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap;
  }
  
  public org.zonrong.www.BranchResponse singleCheckBranch(org.zonrong.www.CheckRequest request, org.zonrong.www.Branch branch, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.singleCheckBranch(request, branch, userData);
  }
  
  public org.zonrong.www.CheckResponse singleCheck(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.singleCheck(request, userData);
  }
  
  public org.zonrong.www.QueryRecordCountResponse queryCizitenDataCount(org.zonrong.www.QueryCizizenRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryCizitenDataCount(request, userData);
  }
  
  public org.zonrong.www.QueryCitizenResponse queryCizitenData(org.zonrong.www.QueryCizizenRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryCizitenData(request, userData);
  }
  
  public org.zonrong.www.IsCitizenExistsResponseCode isCitizenExists(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.isCitizenExists(request, userData);
  }
  
  public org.zonrong.www.GetCitizenResponse getCitizenDataAndWriteLog(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.getCitizenDataAndWriteLog(request, userData);
  }
  
  public org.zonrong.www.GetCitizenResponse getCitizenData(org.zonrong.www.CheckRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.getCitizenData(request, userData);
  }
  
  public org.zonrong.www.QueryHistoryResponse queryHistoryData(org.zonrong.www.QueryHistoryRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryHistoryData(request, userData);
  }
  
  public org.zonrong.www.QueryRecordCountResponse queryHistoryDataCount(org.zonrong.www.QueryHistoryRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryHistoryDataCount(request, userData);
  }
  
  public org.zonrong.www.QueryFeeResponse queryFeeData(org.zonrong.www.QueryFeeRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryFeeData(request, userData);
  }
  
  public org.zonrong.www.LoginResponse login(org.zonrong.www.LoginUserData request) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.login(request);
  }
  
  public org.zonrong.www.LoginResposeCode modifyPassword(org.zonrong.www.ModifyPwdRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.modifyPassword(request, userData);
  }
  
  public org.zonrong.www.QueryAccountResponse queryAccount(org.zonrong.www.QueryAccountRequest request, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryAccount(request, userData);
  }
  
  public org.zonrong.www.ResponseCode createNewAccount(org.zonrong.www.AccountData data, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.createNewAccount(data, userData);
  }
  
  public org.zonrong.www.ResponseCode modifyAccount(org.zonrong.www.AccountData data, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.modifyAccount(data, userData);
  }
  
  public org.zonrong.www.ResponseCode allocateFunds(java.lang.String userIdAllocatee, java.math.BigDecimal money, org.zonrong.www.LoginUserData userData) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.allocateFunds(userIdAllocatee, money, userData);
  }
  
  public org.zonrong.www.ResponseCode uploadUnsureData(org.zonrong.www.UnsureData data, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.uploadUnsureData(data, user_data);
  }
  
  public org.zonrong.www.QueryUnsureDataResponse queryUnsureData(org.zonrong.www.QueryUnsureDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryUnsureData(request, user_data);
  }
  
  public org.zonrong.www.QueryRecordCountResponse queryUnsureDataCount(org.zonrong.www.QueryUnsureDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryUnsureDataCount(request, user_data);
  }
  
  public org.zonrong.www.ResponseCode uploadTransactionDataAndCompare(org.zonrong.www.UploadTransactionDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.uploadTransactionDataAndCompare(request, user_data);
  }
  
  public org.zonrong.www.QueryRecordCountResponse queryTransactionDataCount(org.zonrong.www.QueryTransactionDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryTransactionDataCount(request, user_data);
  }
  
  public org.zonrong.www.QueryTransactionDataResponse queryTransactionData(org.zonrong.www.QueryTransactionDataRequest request, org.zonrong.www.LoginUserData user_data) throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.queryTransactionData(request, user_data);
  }
  
  public java.lang.String getVersion() throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    return identifierServiceBranchSoap.getVersion();
  }
  
  public void getVersion_3_5_0202_10() throws java.rmi.RemoteException{
    if (identifierServiceBranchSoap == null)
      _initIdentifierServiceBranchSoapProxy();
    identifierServiceBranchSoap.getVersion_3_5_0202_10();
  }
  
  
}