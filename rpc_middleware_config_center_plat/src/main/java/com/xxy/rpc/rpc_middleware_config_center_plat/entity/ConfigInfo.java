package com.xxy.rpc.rpc_middleware_config_center_plat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author 赵政凯
 * @since 2020-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ConfigInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 配置id
     */
    private String configId;

    /**
     * 0:未默认    1:默认
     */
    private Integer configDefault;

    /**
     * 配置内容
     */
    private String configContent;

    /**
     * 配置名称
     */
    private String configName;

    private Date gmtCreate;

    private Date gmtModified;


}
