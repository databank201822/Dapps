package com.odms.mahtab.dms.Model;

public class M_SKU {
    int id, SKUId, SKUlpc, batch_id, PackSize, Promo_id,Orderflag;
    double TP, MRP;
    String SKUName, Promo_name;

    public M_SKU() {

    }

    public M_SKU(int id, int SKUId, int packSize, double TP, String SKUName, String promo_name) {
        this.id = id;
        this.SKUId = SKUId;
        this.PackSize = packSize;
        this.TP = TP;
        this.SKUName = SKUName;
        this.Promo_name = promo_name;
    }


    public M_SKU(int id, int SKUId, int SKUlpc, int batch_id, int packSize, int promo_id, double TP, double MRP, String SKUName, String promo_name) {
        this.SKUId = SKUId;
        this.SKUlpc = SKUlpc;
        this.batch_id = batch_id;
        PackSize = packSize;
        Promo_id = promo_id;
        this.TP = TP;
        this.MRP = MRP;
        this.SKUName = SKUName;
        this.Promo_name = promo_name;
    }
    public M_SKU(int SKUId,String SKUName, int SKUlpc, int batch_id, int packSize, double TP, double MRP,int Orderflag ) {
        this.SKUId = SKUId;
        this.SKUlpc = SKUlpc;
        this.batch_id = batch_id;
        PackSize = packSize;
        this.TP = TP;
        this.MRP = MRP;
        this.SKUName = SKUName;
        this.Orderflag = Orderflag;
    }

    public M_SKU(int SKUId,String SKUName, int SKUlpc, int batch_id, int packSize, double TP, double MRP ) {
        this.SKUId = SKUId;
        this.SKUlpc = SKUlpc;
        this.batch_id = batch_id;
        PackSize = packSize;
        this.TP = TP;
        this.MRP = MRP;
        this.SKUName = SKUName;
        this.Orderflag = Orderflag;
    }
    public int getOrderflag() {
        return Orderflag;
    }

    public void setOrderflag(int orderflag) {
        Orderflag = orderflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPromo_id() {
        return Promo_id;
    }

    public void setPromo_id(int promo_id) {
        Promo_id = promo_id;
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

    public String getPromo_name() {
        return Promo_name;
    }

    public void setPromo_name(String promo_name) {
        Promo_name = promo_name;
    }
}
