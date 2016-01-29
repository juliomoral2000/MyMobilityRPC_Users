package com.consisint.acsele.interseguro.interfaces.mobilityRPC.services.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Beans RPC de Productos.
 */
public class ProductRPC {
    long id;
    String name;
    List<String> plans = new ArrayList<String>();

    public ProductRPC(long id, String name, List<String> plans) {
        this.id = id;
        this.name = name;
        this.plans = plans;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPlans() {
        return plans;
    }

    public void setPlans(List<String> plans) {
        this.plans = plans;
    }
}
