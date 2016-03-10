package org.cmweb.exceptions;

public class CMException  extends Exception{
    String errorCode;

    public CMException(Throwable throwable) {
        super(throwable);
    }

    public CMException(String message,Throwable throwable) {
        super(message,throwable);
    }

    public CMException(String errorCode) {

    }


}
