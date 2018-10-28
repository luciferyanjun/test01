/**
 * HIPService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.lachesis.mnis.datasync.web.intercon;

public interface HIPService extends javax.xml.rpc.Service {
    public java.lang.String getplatformHttpPortAddress();

    public com.lachesis.mnis.datasync.web.intercon.Platform getplatformHttpPort() throws javax.xml.rpc.ServiceException;

    public com.lachesis.mnis.datasync.web.intercon.Platform getplatformHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
