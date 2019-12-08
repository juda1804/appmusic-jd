package co.com.poli.trabajofinal.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseHttp implements Serializable {
    private Object messageBody;
    private int codeMessage;
    private String message;
    public ResponseHttp() { this.codeMessage = 200; }

}
