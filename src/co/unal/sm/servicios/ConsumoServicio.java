package co.unal.sm.servicios;

import java.net.URL;

import javax.xml.rpc.holders.BooleanHolder;
import javax.xml.rpc.holders.FloatHolder;

import org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub;
import org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarServiceLocator;

import co.unal.sm.dto.Consumos;

public class ConsumoServicio {
	
	public static Consumos obtenerConsumo(String correo) {
		
		System.out.println("obtenerConsumo()----->" + correo);
		FloatHolder consumoi = new FloatHolder(0);
		FloatHolder consumoe = new FloatHolder(0);
		BooleanHolder funciona = new BooleanHolder(false);
		Consumos consumoFinal = new Consumos() ;
		try {
			OperationhogarServiceLocator locator = new OperationhogarServiceLocator();
//			locator.setoperationhogarPortEndpointAddress("http://192.168.0.23:9080/operationhogarService/operationhogarPort");
			locator.setoperationhogarPortEndpointAddress("http://127.0.0.1:8088/runconsumo");
//			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL(locator.getoperationhogarPortAddress()), locator);
//			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL("http://192.168.0.23:9080/operationhogarService/operationhogarPort"), locator);
			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL("http://127.0.0.1:8088/runconsumo"), locator);
			stub.operationhogarOperation(correo, consumoi, consumoe, funciona);
			
			consumoFinal.setFunciona(funciona.value);
			if(consumoFinal.getFunciona()){
				consumoFinal.setConsumoe(consumoe.value);
				consumoFinal.setConsumoi(consumoi.value);
			}
			return consumoFinal;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
