/**
 * IdentifierServiceBranchLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.zonrong.www;

public class IdentifierServiceBranchLocator extends org.apache.axis.client.Service implements org.zonrong.www.IdentifierServiceBranch {

    public IdentifierServiceBranchLocator() {
    }


    public IdentifierServiceBranchLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IdentifierServiceBranchLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IdentifierServiceBranchSoap
    private java.lang.String IdentifierServiceBranchSoap_address = "http://11.8.40.150/IdentifierServiceBranch.asmx";

    public java.lang.String getIdentifierServiceBranchSoapAddress() {
        return IdentifierServiceBranchSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IdentifierServiceBranchSoapWSDDServiceName = "IdentifierServiceBranchSoap";

    public java.lang.String getIdentifierServiceBranchSoapWSDDServiceName() {
        return IdentifierServiceBranchSoapWSDDServiceName;
    }

    public void setIdentifierServiceBranchSoapWSDDServiceName(java.lang.String name) {
        IdentifierServiceBranchSoapWSDDServiceName = name;
    }

    public org.zonrong.www.IdentifierServiceBranchSoap getIdentifierServiceBranchSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IdentifierServiceBranchSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIdentifierServiceBranchSoap(endpoint);
    }

    public org.zonrong.www.IdentifierServiceBranchSoap getIdentifierServiceBranchSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.zonrong.www.IdentifierServiceBranchSoapStub _stub = new org.zonrong.www.IdentifierServiceBranchSoapStub(portAddress, this);
            _stub.setPortName(getIdentifierServiceBranchSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIdentifierServiceBranchSoapEndpointAddress(java.lang.String address) {
        IdentifierServiceBranchSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.zonrong.www.IdentifierServiceBranchSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.zonrong.www.IdentifierServiceBranchSoapStub _stub = new org.zonrong.www.IdentifierServiceBranchSoapStub(new java.net.URL(IdentifierServiceBranchSoap_address), this);
                _stub.setPortName(getIdentifierServiceBranchSoapWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IdentifierServiceBranchSoap".equals(inputPortName)) {
            return getIdentifierServiceBranchSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentifierServiceBranch");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.zonrong.org/", "IdentifierServiceBranchSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IdentifierServiceBranchSoap".equals(portName)) {
            setIdentifierServiceBranchSoapEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
