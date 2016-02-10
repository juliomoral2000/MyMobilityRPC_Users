package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

/**
 * La clase <code>PropertyValuesRPC</code> representa el wrapper del Property
 * de Acsele para los servicios del MobilityRPC.
 */
public class PropertyValuesRPC {
    long propertyId;
    String propertyName;
    TRDataRPC[] trsArr;    // Lista de Informacion Basica de transformadorFila de la Propiedad
    String parentName;      // Nombre de la Propiedad Padre o Superlativa
    String[] childs;        // Lista de Nombre de las propiedades Hijo o Dependientes
    /**
     *
     * @param propertyId Id de la propiedad
     * @param propertyName  Nombre de la Propiedad
     * @param trsArr    Array de <code>TRDataRPC</code>
     * @param parentName Nombre propiedad Padre
     * @param childs    Lista de Propiedades Hijos
     */
    public PropertyValuesRPC(long propertyId, String propertyName, TRDataRPC[] trsArr, String parentName, String[] childs) {
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.trsArr = trsArr;
        this.parentName = parentName;
        this.childs = childs;
    }
	
	public long getPropertyId() {
        return propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public TRDataRPC[] getTrsArr() {
        return trsArr;
    }

    public String[] getChilds() {
        return childs;
    }

    public String getParentName() {
        return parentName;
    }
}
