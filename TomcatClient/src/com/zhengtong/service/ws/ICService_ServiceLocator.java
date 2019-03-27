/**
 * ICService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zhengtong.service.ws;

public class ICService_ServiceLocator extends org.apache.axis.client.Service implements com.zhengtong.service.ws.ICService_Service {

    public ICService_ServiceLocator() {
    }


    public ICService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ICService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ICServicePort
    private java.lang.String ICServicePort_address = "https://101.230.196.66/ICService";
    
     

    public java.lang.String getICServicePort_address() {
		return ICServicePort_address;
	}


	public void setICServicePort_address(java.lang.String iCServicePort_address) {
		ICServicePort_address = iCServicePort_address;
	}


	public java.lang.String getICServicePortAddress() {
        return ICServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ICServicePortWSDDServiceName = "ICServicePort";

    public java.lang.String getICServicePortWSDDServiceName() {
        return ICServicePortWSDDServiceName;
    }

    public void setICServicePortWSDDServiceName(java.lang.String name) {
        ICServicePortWSDDServiceName = name;
    }

    public com.zhengtong.service.ws.ICService_PortType getICServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ICServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getICServicePort(endpoint);
    }

    public com.zhengtong.service.ws.ICService_PortType getICServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.zhengtong.service.ws.ICServicePortBindingStub _stub = new com.zhengtong.service.ws.ICServicePortBindingStub(portAddress, this);
            _stub.setPortName(getICServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setICServicePortEndpointAddress(java.lang.String address) {
        ICServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.zhengtong.service.ws.ICService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.zhengtong.service.ws.ICServicePortBindingStub _stub = new com.zhengtong.service.ws.ICServicePortBindingStub(new java.net.URL(ICServicePort_address), this);
                _stub.setPortName(getICServicePortWSDDServiceName());
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
        if ("ICServicePort".equals(inputPortName)) {
            return getICServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.service.zhengtong.com/", "ICService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.service.zhengtong.com/", "ICServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ICServicePort".equals(portName)) {
            setICServicePortEndpointAddress(address);
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
