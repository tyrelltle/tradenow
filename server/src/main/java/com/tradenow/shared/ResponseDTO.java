package com.tradenow.shared;

/**
 * Created by tyler on 11/25/2014.
 */
public class ResponseDTO {

    public static String SUCCESS="success";
    public static String FAIL="fail";

    String status;

    String message;

    public ResponseDTO(){}

    public ResponseDTO(String st,String msg){
        status=st;
        message=msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
