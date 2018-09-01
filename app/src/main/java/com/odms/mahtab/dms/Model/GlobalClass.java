package com.odms.mahtab.dms.Model;

import android.app.Application;
import android.net.Uri;

public class GlobalClass extends Application {

    private int PSRid,DBId;
    private String Emp_code,PSRName,MobileNo,DBName;

    private static final String SERVER_IMAGE_LOCATION = "http://10.168.13.54/Upload/";
    private static final String SERVER_LOCATION = "http://10.168.13.54/";
    private static final String SERVER_URL = "http://10.168.13.54/api/";

    private static GlobalClass instance = new GlobalClass();

    // Getter-Setters
    public static GlobalClass getInstance() {
        return instance;
    }


    public int getPSRid() {
        return PSRid;
    }

    public void setPSRid(int PSRid) {
        this.PSRid = PSRid;
    }

    public int getDBId() {
        return DBId;
    }

    public void setDBId(int DBId) {
        this.DBId = DBId;
    }

    public String getEmp_code() {
        return Emp_code;
    }

    public void setEmp_code(String emp_code) {
        Emp_code = emp_code;
    }

    public String getPSRName() {
        return PSRName;
    }

    public void setPSRName(String PSRName) {
        this.PSRName = PSRName;
    }

    public String getMobileNo() {
        return MobileNo;
    }

    public void setMobileNo(String mobileNo) {
        MobileNo = mobileNo;
    }

    public String getDBName() {
        return DBName;
    }

    public void setDBName(String DBName) {
        this.DBName = DBName;
    }

    public String getSERVER_URL() {
        return SERVER_URL;
    }
    public String getSERVER_IMAGE_LOCATION() { return SERVER_IMAGE_LOCATION; }

    public static String getServerLocation() {        return SERVER_LOCATION;    }
}

