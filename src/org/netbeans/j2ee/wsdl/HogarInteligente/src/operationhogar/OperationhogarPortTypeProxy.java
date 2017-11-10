package org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar;

public class OperationhogarPortTypeProxy implements org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarPortType {
  private String _endpoint = null;
  private org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarPortType operationhogarPortType = null;
  
  public OperationhogarPortTypeProxy() {
    _initOperationhogarPortTypeProxy();
  }
  
  public OperationhogarPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initOperationhogarPortTypeProxy();
  }
  
  private void _initOperationhogarPortTypeProxy() {
    try {
      operationhogarPortType = (new org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarServiceLocator()).getoperationhogarPort();
      if (operationhogarPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)operationhogarPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)operationhogarPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (operationhogarPortType != null)
      ((javax.xml.rpc.Stub)operationhogarPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarPortType getOperationhogarPortType() {
    if (operationhogarPortType == null)
      _initOperationhogarPortTypeProxy();
    return operationhogarPortType;
  }
  
  public void operationhogarOperation(java.lang.String email, javax.xml.rpc.holders.FloatHolder consumoi, javax.xml.rpc.holders.FloatHolder consumoe, javax.xml.rpc.holders.BooleanHolder boleano) throws java.rmi.RemoteException{
    if (operationhogarPortType == null)
      _initOperationhogarPortTypeProxy();
    operationhogarPortType.operationhogarOperation(email, consumoi, consumoe, boleano);
  }
  
  
}