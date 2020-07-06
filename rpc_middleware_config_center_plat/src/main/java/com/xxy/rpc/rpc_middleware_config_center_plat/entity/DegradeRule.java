package com.xxy.rpc.rpc_middleware_config_center_plat.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author vicente
 * @since 2020-05-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DegradeRule {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String appId;

    private String ip;

    private Integer port;

    private String resource;

    private String limitApp;

    private Double count;

    private Integer timeWindow;

    private Integer grade;

    @TableField("gmt_Create")
    private Date gmtCreate;

    private Date gmtModified;


}
