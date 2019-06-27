package com.zs.filecenter.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class UploadResult implements Serializable {
    public int success;
    public String code;
    public String msg;
    public Object data;
}
