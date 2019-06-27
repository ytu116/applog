package com.zs.filecenter.model;

import lombok.Data;

/*
{
    "id" : 6522722763981979648,
    "billNo" : "990001",
    "goodsId" : "69012340002",
    "goodsName" : "维达餐巾纸2",
    "qty" : 100.000,
    "createUserId" : null,
    "createDate" : "20190501 23:16:51",
    "updateUserId" : null,
    "updateDate" : "20190501 23:16:51"
}
 */
@Data
public class TbOrderDetail {
    private long id;
    private String billNo;
    private String goodsId;
    private String goodsName;
    private int qty;
    private String createUserId;
    private String createDate;
    private String updateUserId;
    private String updateDate;
}
