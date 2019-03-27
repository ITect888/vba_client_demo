/**
 * ICService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zhengtong.service.ws;

public interface ICService_PortType extends java.rmi.Remote {
    public com.zhengtong.service.ws.IcResp idCert(com.zhengtong.service.ws.Ic message) throws java.rmi.RemoteException;
    public com.zhengtong.service.ws.OcBizQResp orgCertBizQuery(com.zhengtong.service.ws.OcBizQ message) throws java.rmi.RemoteException;
}
