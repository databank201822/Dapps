package com.odms.mahtab.dms.Model;

public class M_SubRoute {

    private int _id,_Psrid,_Subrouteid,_Todayvisit;
    private String _SubrouteName;

    public M_SubRoute() {

    }

    public M_SubRoute(int _Psrid, int _Subrouteid, String _SubrouteName, int _Todayvisit) {
        this._Psrid = _Psrid;
        this._Subrouteid = _Subrouteid;
        this._Todayvisit = _Todayvisit;
        this._SubrouteName = _SubrouteName;
    }

    public M_SubRoute(int subrouteid, String subrouteName) {
        this._Subrouteid = _Subrouteid;
        this._SubrouteName = _SubrouteName;
    }

    public int get_Id() {
        return _id;
    }

    public void set_Id(int id) {
        this._id = id;
    }

    public int get_Psrid() {
        return _Psrid;
    }

    public void set_Psrid(int _Psrid) {
        this._Psrid = _Psrid;
    }

    public int get_Subrouteid() {
        return _Subrouteid;
    }

    public void set_Subrouteid(int _Subrouteid) {
        this._Subrouteid = _Subrouteid;
    }

    public int get_Todayvisit() {
        return _Todayvisit;
    }

    public void set_Todayvisit(int _Todayvisit) {
        this._Todayvisit = _Todayvisit;
    }

    public String get_SubrouteName() {
        return _SubrouteName;
    }

    public void set_SubrouteName(String _SubrouteName) {
        this._SubrouteName = _SubrouteName;
    }
}
