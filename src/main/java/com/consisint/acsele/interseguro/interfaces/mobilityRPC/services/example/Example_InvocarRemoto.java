package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.example;

import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.PlanRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.ProductRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans.PropertyValuesRPC;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Product_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.client.caller.Property_Callers;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.ProductParameter;
import com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.params.PropertyParameter;
import com.enroquesw.mcs.comm.mobilityRPC.enums.SystemName;

import java.util.List;

/**
 * Clase de ejemplo de como invocar los servicios del Remoto (Acsele)
 */
public class Example_InvocarRemoto {
    public void invocar(){
        // Asumimos que ya en el contexto de la llamada a este metodo el Servidor MyMovilityRPC ya se encuentra en ejecucion
        try {
            List<ProductRPC> products = Product_Callers.getProducts(SystemName.ACSELE);
            for (ProductRPC product : products) {
                System.out.println("[Producto] "+product.getName());
                ProductParameter productParameter = new ProductParameter(product.getId());
                ProductRPC rpc = Product_Callers.getProduct(SystemName.ACSELE, productParameter);
                System.out.println("[Producto] "+rpc.getName());
                List<PlanRPC> list = Product_Callers.getPlanes(SystemName.ACSELE, productParameter);
                System.out.println("[Planes.size] "+list.size());
            }
            /*******************************************************************/
            PropertyParameter parameter = new PropertyParameter(0, "CodDepartamento", false); // Sin obtener info de Dependencias
            PropertyValuesRPC rpc_2 = Property_Callers.getPropertyValues(SystemName.ACSELE, parameter);
            System.out.println("property :"+rpc_2.getPropertyId()+"-"+rpc_2.getPropertyName());
            parameter = new PropertyParameter(0, "CodProvincia", true); // Extrayendo info de Dependencias
            PropertyValuesRPC rpc_3 = Property_Callers.getPropertyValues(SystemName.ACSELE, parameter);
            System.out.println("property :"+rpc_3.getPropertyId()+"-"+rpc_3.getPropertyName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
