package co.unal.sm.servicios;

import java.net.URL;

import javax.xml.rpc.holders.FloatHolder;

import org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub;
import org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarServiceLocator;

public class ConsumoServicio {
	
	public static float obtenerConsumo(String correo) {
		
		System.out.println("obtenerConsumo()----->" + correo);
		FloatHolder consumoi = new FloatHolder(0);
		FloatHolder consumoe = new FloatHolder(0);
		try {
			OperationhogarServiceLocator locator = new OperationhogarServiceLocator();
			locator.setoperationhogarPortEndpointAddress("http://127.0.0.1:8088/runconsumo");
//			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL(locator.getoperationhogarPortAddress()), locator);
			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL("http://127.0.0.1:8088/runconsumo"), locator);
			stub.operationhogarOperation(correo, consumoi, consumoe);
			
			float total = (consumoe.value + consumoi.value) * 1000;
			return total;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}

}
