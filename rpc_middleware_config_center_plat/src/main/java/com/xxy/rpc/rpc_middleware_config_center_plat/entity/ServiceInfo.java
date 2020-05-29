package com.xxy.rpc.rpc_middleware_config_center_plat.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
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
public class ServiceInfo extends Model<ServiceInfo> {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 服务id
     */
    private String serviceId;

    private String appId;

    private String machineId;

    private String param;

    private String serviceName;

    private LocalDateTime gmtCreate;

    private LocalDateTime gmtModified;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
