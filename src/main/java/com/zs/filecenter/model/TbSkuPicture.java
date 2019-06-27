package com.zs.filecenter.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TbSkuPicture implements Serializable {
    private int id;
    private int saveLocation;
    private String svrId;
    private String svrIp;
    private String skuCode;
    private String tag;
    private String picName;
    private String picId;
    private String localPath;
    private String filePath;
    private String webPath;
    private String picUrl;
    private String picUrlSmall;
    private int imgIndex;
    private String createUserId;
    private String createDate;
    private int isDelete;
    private String remark;

}
