package com.odms.mahtab.dms.Model;

public class M_Outlet {
    int id,OutletId,PSR_id,RouteID,OutletCode,Distributorid,HaveVisicooler,IsActive;
    String OutletName,OwnerName,ContactNo,Address,channel_name,outlet_category_name,Outlet_grade;
    public M_Outlet(){

    }

    public M_Outlet(int outletId, int outletCode, String outletName) {
        OutletId = outletId;
        OutletCode = outletCode;
        OutletName = outletName;
    }

    public M_Outlet(int outletId, int PSR_id, int routeID, int outletCode, int distributorid, int haveVisicooler, int isActive, String outletName, String ownerName, String contactNo, String address, String channel_name, String outlet_category_name, String outlet_grade) {
        this.OutletId = outletId;
        this.PSR_id = PSR_id;
        this.RouteID = routeID;
        this.OutletCode = outletCode;
        this.Distributorid = distributorid;
        this.HaveVisicooler = haveVisicooler;
        this.IsActive = isActive;
        this.OutletName = outletName;
        this.OwnerName = ownerName;
        this.ContactNo = contactNo;
        this.Address = address;
        this.channel_name = channel_name;
        this.outlet_category_name = outlet_category_name;
        this.Outlet_grade = outlet_grade;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOutletId() {
        return OutletId;
    }

    public void setOutletId(int outletId) {
        OutletId = outletId;
    }

    public int getPSR_id() {
        return PSR_id;
    }

    public void setPSR_id(int PSR_id) {
        this.PSR_id = PSR_id;
    }

    public int getRouteID() {
        return RouteID;
    }

    public void setRouteID(int routeID) {
        RouteID = routeID;
    }

    public int getOutletCode() {
        return OutletCode;
    }

    public void setOutletCode(int outletCode) {
        OutletCode = outletCode;
    }

    public int getDistributorid() {
        return Distributorid;
    }

    public void setDistributorid(int distributorid) {
        Distributorid = distributorid;
    }

    public int getHaveVisicooler() {
        return HaveVisicooler;
    }

    public void setHaveVisicooler(int haveVisicooler) {
        HaveVisicooler = haveVisicooler;
    }

    public int getIsActive() {
        return IsActive;
    }

    public void setIsActive(int isActive) {
        IsActive = isActive;
    }

    public String getOutletName() {
        return OutletName;
    }

    public void setOutletName(String outletName) {
        OutletName = outletName;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String contactNo) {
        ContactNo = contactNo;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public String getOutlet_category_name() {
        return outlet_category_name;
    }

    public void setOutlet_category_name(String outlet_category_name) {
        this.outlet_category_name = outlet_category_name;
    }

    public String getOutlet_grade() {
        return Outlet_grade;
    }

    public void setOutlet_grade(String outlet_grade) {
        Outlet_grade = outlet_grade;
    }
}
