/**
 * HIPServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lachesis.mnis.datasync.web.intercon;

public class HIPServiceLocator extends org.apache.axis.client.Service implements com.lachesis.mnis.datasync.web.intercon.HIPService {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HIPServiceLocator() {
    }


    public HIPServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HIPServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for platformHttpPort
    private java.lang.String platformHttpPort_address = "http://192.168.100.160:7800/platform/platform";

    public java.lang.String getplatformHttpPortAddress() {
        return platformHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String platformHttpPortWSDDServiceName = "platformHttpPort";

    public java.lang.String getplatformHttpPortWSDDServiceName() {
        return platformHttpPortWSDDServiceName;
    }

    public void setplatformHttpPortWSDDServiceName(java.lang.String name) {
        platformHttpPortWSDDServiceName = name;
    }

    public com.lachesis.mnis.datasync.web.intercon.Platform getplatformHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(platformHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getplatformHttpPort(endpoint);
    }

    public com.lachesis.mnis.datasync.web.intercon.Platform getplatformHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.lachesis.mnis.datasync.web.intercon.PlatformHttpBindingStub _stub = new com.lachesis.mnis.datasync.web.intercon.PlatformHttpBindingStub(portAddress, this);
            _stub.setPortName(getplatformHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setplatformHttpPortEndpointAddress(java.lang.String address) {
        platformHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.lachesis.mnis.datasync.web.intercon.Platform.class.isAssignableFrom(serviceEndpointInterface)) {
                com.lachesis.mnis.datasync.web.intercon.PlatformHttpBindingStub _stub = new com.lachesis.mnis.datasync.web.intercon.PlatformHttpBindingStub(new java.net.URL(platformHttpPort_address), this);
                _stub.setPortName(getplatformHttpPortWSDDServiceName());
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
        if ("platformHttpPort".equals(inputPortName)) {
            return getplatformHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:hl7-org:v3", "HIPService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:hl7-org:v3", "platformHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("platformHttpPort".equals(portName)) {
            setplatformHttpPortEndpointAddress(address);
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
