//package co.unal.sm.servicios;
//
//import java.net.URL;
//
//import javax.xml.rpc.holders.FloatHolder;
//
//import org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarBindingStub;
//import org.netbeans.j2ee.wsdl.HogarInteligente.src.operationhogar.OperationhogarServiceLocator;
//
//public class ConsumoServicioAnterior {
//	
//	public static float obtenerConsumo(String correo) {
//		
//		System.out.println("obtenerConsumo()----->" + correo);
//		FloatHolder consumoi = new FloatHolder(0);
//		FloatHolder consumoe = new FloatHolder(0);
//		try {
//			OperationhogarServiceLocator locator = new OperationhogarServiceLocator();
//			locator.setoperationhogarPortEndpointAddress("http://192.168.0.23:9080/operationhogarService/operationhogarPort");
////			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL(locator.getoperationhogarPortAddress()), locator);
//			OperationhogarBindingStub stub = new OperationhogarBindingStub(new URL("http://192.168.0.23:9080/operationhogarService/operationhogarPort"), locator);
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			
//			stub.operationhogarOperation(correo, consumoi, consumoe);
//			if (consumoe.value < 0 || consumoi.value <0) {
//				return -1;
//			}
//			float total = (consumoe.value + consumoi.value) * 1000;
//			return total;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return -1;
//		}
//		
//	}
//
//}
