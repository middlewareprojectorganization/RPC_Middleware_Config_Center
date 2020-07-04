package com.xxy.rpc.rpc_middleware_config_center_plat.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

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
public class ConfigInfo extends Model<ConfigInfo> {


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
     * 默认配置标识
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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
