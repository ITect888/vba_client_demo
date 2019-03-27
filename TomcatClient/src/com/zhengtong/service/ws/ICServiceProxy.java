package com.zhengtong.service.ws;

public class ICServiceProxy implements com.zhengtong.service.ws.ICService_PortType {
  private String _endpoint = null;
  private com.zhengtong.service.ws.ICService_PortType iCService_PortType = null;
  
  public ICServiceProxy() {
    _initICServiceProxy();
  }
  
  public ICServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initICServiceProxy();
  }
  
  private void _initICServiceProxy() {
    try {
      iCService_PortType = (new com.zhengtong.service.ws.ICService_ServiceLocator()).getICServicePort();
      if (iCService_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iCService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iCService_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iCService_PortType != null)
      ((javax.xml.rpc.Stub)iCService_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.zhengtong.service.ws.ICService_PortType getICService_PortType() {
    if (iCService_PortType == null)
      _initICServiceProxy();
    return iCService_PortType;
  }
  
  public com.zhengtong.service.ws.IcResp idCert(com.zhengtong.service.ws.Ic message) throws java.rmi.RemoteException{
    if (iCService_PortType == null)
      _initICServiceProxy();
    return iCService_PortType.idCert(message);
  }
  
  public com.zhengtong.service.ws.OcBizQResp orgCertBizQuery(com.zhengtong.service.ws.OcBizQ message) throws java.rmi.RemoteException{
    if (iCService_PortType == null)
      _initICServiceProxy();
    return iCService_PortType.orgCertBizQuery(message);
  }
  
  
}