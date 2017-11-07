/**
 * OperationhogarServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar;

public class OperationhogarServiceLocator extends org.apache.axis.client.Service implements org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarService {

    public OperationhogarServiceLocator() {
    }


    public OperationhogarServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public OperationhogarServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for operationhogarPort
    private java.lang.String operationhogarPort_address = "http://DESKTOP-U1SP2C2:8088/runconsumo";

    public java.lang.String getoperationhogarPortAddress() {
        return operationhogarPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String operationhogarPortWSDDServiceName = "operationhogarPort";

    public java.lang.String getoperationhogarPortWSDDServiceName() {
        return operationhogarPortWSDDServiceName;
    }

    public void setoperationhogarPortWSDDServiceName(java.lang.String name) {
        operationhogarPortWSDDServiceName = name;
    }

    public org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarPortType getoperationhogarPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(operationhogarPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getoperationhogarPort(endpoint);
    }

    public org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarPortType getoperationhogarPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub _stub = new org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub(portAddress, this);
            _stub.setPortName(getoperationhogarPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setoperationhogarPortEndpointAddress(java.lang.String address) {
        operationhogarPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub _stub = new org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub(new java.net.URL(operationhogarPort_address), this);
                _stub.setPortName(getoperationhogarPortWSDDServiceName());
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
        if ("operationhogarPort".equals(inputPortName)) {
            return getoperationhogarPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://j2ee.netbeans.org/wsdl/HogarInteligente/src/operationhogar", "operationhogarService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://j2ee.netbeans.org/wsdl/HogarInteligente/src/operationhogar", "operationhogarPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("operationhogarPort".equals(portName)) {
            setoperationhogarPortEndpointAddress(address);
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
