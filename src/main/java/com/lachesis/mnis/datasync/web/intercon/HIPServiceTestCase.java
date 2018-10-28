/**
 * HIPServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 *//*

package com.lachesis.mnis.datasync.web.intercon;

public class HIPServiceTestCase extends junit.framework.TestCase {
    public HIPServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testplatformHttpPortWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.lachesis.mnis.datasync.web.intercon.HIPServiceLocator().getplatformHttpPortAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.lachesis.mnis.datasync.web.intercon.HIPServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1platformHttpPortHIPMessageServer() throws Exception {
        com.lachesis.mnis.datasync.web.intercon.PlatformHttpBindingStub binding;
        try {
            binding = (com.lachesis.mnis.datasync.web.intercon.PlatformHttpBindingStub)
                          new com.lachesis.mnis.datasync.web.intercon.HIPServiceLocator().getplatformHttpPort();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.HIPMessageServer(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

}
*/