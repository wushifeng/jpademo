package cn.csbit.form;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by Answer on 16/7/1.
 */

public class DataSourceForm {

    @Size(min = 6, max = 20, message = "数据源名称长度为6~20位")
    private String alias;

    @NotNull(message = "类型不能为空")
    private Integer type;

    @Pattern(message = "IP地址格式不正确", regexp = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$")
    private String ip;

    @Range(message = "端口范围为0~65535", min = 0L, max = 65535L)
    private Integer port;

    // TODO: 16/7/1 布尔类型校验方法有待验证
    @NotNull(message = "故障中断选项不能为空")
    private Boolean interrupt;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Boolean getInterrupt() {
        return interrupt;
    }

    public void setInterrupt(Boolean interrupt) {
        this.interrupt = interrupt;
    }
}
