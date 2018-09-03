package com.odms.mahtab.dms.service;

import android.content.Context;

import com.odms.mahtab.dms.service.ServerSync.SyncOutlet;
import com.odms.mahtab.dms.service.ServerSync.SyncSku;
import com.odms.mahtab.dms.service.ServerSync.SyncSubroute;


public class ServerDataSync  {


    public ServerDataSync(Context Context) {
        super();
        SyncSubroute SyncSubroute=new SyncSubroute(Context);
        SyncOutlet SyncOutlet=new SyncOutlet(Context);
        SyncSku SyncSku=new SyncSku(Context);
    }


}
