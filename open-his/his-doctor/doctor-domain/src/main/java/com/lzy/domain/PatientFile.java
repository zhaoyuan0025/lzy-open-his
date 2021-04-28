package com.lzy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
* @Author: 尚学堂 雷哥
*/

@ApiModel(value="com-lzy-domain-PatientFile")
@Data
@EqualsAndHashCode(callSuper=true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "his_patient_file")
public class PatientFile extends BaseEntity {
    /**
     * 患者id
     */
    @TableId(value = "patient_id", type = IdType.INPUT)
    @ApiModelProperty(value="患者id")
    private String patientId;

    /**
     * 紧急联系人
     */
    @TableField(value = "emergency_contact_name")
    @ApiModelProperty(value="紧急联系人")
    private String emergencyContactName;

    /**
     * 紧急联系人电话
     */
    @TableField(value = "emergency_contact_phone")
    @ApiModelProperty(value="紧急联系人电话")
    private String emergencyContactPhone;

    /**
     * 爸爸,妈妈,儿子,女儿,亲戚,朋友
     */
    @TableField(value = "emergency_contact_relation")
    @ApiModelProperty(value="爸爸,妈妈,儿子,女儿,亲戚,朋友")
    private String emergencyContactRelation;

    /**
     * 左耳听力 正常  耳聋
     */
    @TableField(value = "left_ear_hearing")
    @ApiModelProperty(value="左耳听力 正常  耳聋")
    private String leftEarHearing;

    /**
     * 右耳听力 正常  耳聋
     */
    @TableField(value = "right_ear_hearing")
    @ApiModelProperty(value="右耳听力 正常  耳聋")
    private String rightEarHearing;

    /**
     * 左眼视力
     */
    @TableField(value = "left_vision")
    @ApiModelProperty(value="左眼视力")
    private BigDecimal leftVision;

    /**
     * 右眼视力
     */
    @TableField(value = "right_vision")
    @ApiModelProperty(value="右眼视力")
    private BigDecimal rightVision;

    /**
     * 身高
     */
    @TableField(value = "height")
    @ApiModelProperty(value="身高")
    private BigDecimal height;

    /**
     * 体重
     */
    @TableField(value = "weight")
    @ApiModelProperty(value="体重")
    private BigDecimal weight;

    /**
     * 血型 A  B  AB  O    R-阴 RH-阳
     */
    @TableField(value = "blood_type")
    @ApiModelProperty(value="血型 A  B  AB  O    R-阴 RH-阳")
    private String bloodType;

    /**
     * 个人史
     */
    @TableField(value = "personal_info")
    @ApiModelProperty(value="个人史")
    private String personalInfo;

    /**
     * 家族史
     */
    @TableField(value = "family_info")
    @ApiModelProperty(value="家族史")
    private String familyInfo;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    public static final String COL_PATIENT_ID = "patient_id";

    public static final String COL_EMERGENCY_CONTACT_NAME = "emergency_contact_name";

    public static final String COL_EMERGENCY_CONTACT_PHONE = "emergency_contact_phone";

    public static final String COL_EMERGENCY_CONTACT_RELATION = "emergency_contact_relation";

    public static final String COL_LEFT_EAR_HEARING = "left_ear_hearing";

    public static final String COL_RIGHT_EAR_HEARING = "right_ear_hearing";

    public static final String COL_LEFT_VISION = "left_vision";

    public static final String COL_RIGHT_VISION = "right_vision";

    public static final String COL_HEIGHT = "height";

    public static final String COL_WEIGHT = "weight";

    public static final String COL_BLOOD_TYPE = "blood_type";

    public static final String COL_PERSONAL_INFO = "personal_info";

    public static final String COL_FAMILY_INFO = "family_info";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";
}