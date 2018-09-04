package com.odms.mahtab.dms.Model;

public class M_temp_order_line {


    int id, SKUId, SKUlpc,linetype, batch_id, PackSize,qty,Freeqty;
    double TP, MRP;
    String SKUName;

    public M_temp_order_line() {
    }

    public M_temp_order_line(int SKUId, String SKUName, int SKUlpc, int linetype, int batch_id, int packSize, double TP, double MRP,int qty) {
        this.SKUId = SKUId;
        this.SKUlpc = SKUlpc;
        this.linetype = linetype;
        this.batch_id = batch_id;
        PackSize = packSize;
        this.TP = TP;
        this.MRP = MRP;
        this.SKUName = SKUName;
        this.qty = qty;

    }

    public M_temp_order_line(int SKUId, String SKUName, int packSize, double TP, double MRP,int qty,int freeqty) {
        this.SKUId = SKUId;
        PackSize = packSize;
        this.TP = TP;
        this.MRP = MRP;
        this.SKUName = SKUName;
        this.qty = qty;
        this.Freeqty = freeqty;

    }



    public int getSKUId() {
        return SKUId;
    }

    public void setSKUId(int SKUId) {
        this.SKUId = SKUId;
    }

    public int getSKUlpc() {
        return SKUlpc;
    }

    public void setSKUlpc(int SKUlpc) {
        this.SKUlpc = SKUlpc;
    }

    public int getLinetype() {
        return linetype;
    }

    public void setLinetype(int linetype) {
        this.linetype = linetype;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getPackSize() {
        return PackSize;
    }

    public void setPackSize(int packSize) {
        PackSize = packSize;
    }

    public double getTP() {
        return TP;
    }

    public void setTP(double TP) {
        this.TP = TP;
    }

    public double getMRP() {
        return MRP;
    }


    public void setMRP(double MRP) {
        this.MRP = MRP;
    }

    public String getSKUName() {
        return SKUName;
    }

    public void setSKUName(String SKUName) {
        this.SKUName = SKUName;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getFreeqty() {
        return Freeqty;
    }

    public void setFreeqty(int freeqty) {
        this.Freeqty = freeqty;
    }
}
