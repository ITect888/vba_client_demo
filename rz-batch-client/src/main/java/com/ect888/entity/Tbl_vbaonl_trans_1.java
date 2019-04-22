package com.ect888.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author fanyj
 * @since 2019-02-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Tbl_vbaonl_trans_1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("sysSeqNb")
    private String sysSeqNb;

    @TableField("authTyp")
    private String authTyp;

    @TableField("bizTyp")
    private String bizTyp;

    @TableField("bizAddr")
    private String bizAddr;

    @TableField("bizTypDesc")
    private String bizTypDesc;

    private String status;

    @TableField("certSeq")
    private String certSeq;

    @TableField("userNm")
    private String userNm;

    private String sex;

    private String addr;

    @TableField("certFront")
    private String certFront;

    @TableField("certNegative")
    private String certNegative;

    private String vedio;

    @TableField("facePic")
    private String facePic;

    @TableField("facePicMPS")
    private String facePicMPS;

    @TableField("localSim")
    private Float localSim;

    @TableField("MPSSim")
    private Float MPSSim;

    @TableField("respCd")
    private String respCd;

    @TableField("respInfo")
    private String respInfo;

    @TableField("ptyCd")
    private String ptyCd;

    /**
     * 流水创建时间
     */
    private LocalDateTime cretm;

    /**
     * 流水更新时间
     */
    private LocalDateTime updatetm;

    private String sourcechnl;

    @TableField("ptyAcct")
    private String ptyAcct;

    @TableField("accountCard")
    private String accountCard;

    @TableField("ptyRespcd")
    private String ptyRespcd;

    /**
     * 机构应答信息
     */
    @TableField("ptyRespinfo")
    private String ptyRespinfo;

    /**
     * 手机号
     */
    private String telephone;

    /**
     * 银行名称
     */
    @TableField("accountName")
    private String accountName;

    /**
     * 授权文件类型
     */
    @TableField("authFileType")
    private String authFileType;

    /**
     * 是否计费
     */
    @TableField("isCount")
    private String isCount;

    /**
     * 机构别名
     */
    private String bmtopolice;

    /**
     * 业务发生地
     */
    private String fsdtopolice;

    /**
     * 业务类型
     */
    private String ywlxtopolice;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 基金代码
     */
    @TableField("accountCode")
    private String accountCode;

    private String res1;

    private String res2;

    private String res3;

    private String res4;

    private String res5;

    private String res6;

    private String res7;

    private String res8;

    /**
     * 响应信息
     */
    private String res9;

    /**
     * 响应信息
     */
    private String res10;

    /**
     * 是否透支
     */
    @TableField("isOverDraft")
    private String isOverDraft;

    /**
     * 自服务类型
     */
    @TableField("subAuthTyp")
    private String subAuthTyp;


}
