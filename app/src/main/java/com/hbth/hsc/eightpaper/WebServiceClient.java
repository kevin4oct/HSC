package com.hbth.hsc.eightpaper;


import com.hbth.hsc.api.ALLVARIABLE;
import com.hbth.mylibrary.utils.LogUtils;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

public class WebServiceClient {

    public static String jaxWSMethod(final SoapObject object) {
        String str = "";
        String SERVICE_URL = ALLVARIABLE.getWebserviceurl();
        HttpTransportSE ht = new HttpTransportSE(SERVICE_URL);
        ht.debug = true;
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.bodyOut = object;
        try {
            ht.call(null, envelope);
            if (envelope.getResponse() != null) {
                SoapObject result = (SoapObject) envelope.bodyIn;
                str = result.getProperty(0).toString();

            } else {
                str = "无返回值";
            }
        } catch (IOException | XmlPullParserException e) {
            LogUtils.loge(e.getMessage());
        }
        return str;
    }


}
