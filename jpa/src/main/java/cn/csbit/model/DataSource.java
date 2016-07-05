package cn.csbit.model;

import cn.csbit.model.base.BaseModel;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Answer on 16/7/1.
 */
@Entity
@Table
public class DataSource extends BaseModel {

    @Length(min = 6, max = 20, message = "数据源名称长度为6~20位")
    @Column(nullable = false, length = 20)
    @ColumnDefault(value = "''")
    private String alias = "";

    @NotNull(message = "类型不能为空")
    @Column(nullable = false)
    @ColumnDefault(value = "-1")
    private Integer type = -1;

    @Pattern(message = "IP地址格式不正确", regexp = "^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$")
    @Column(nullable = false)
    @ColumnDefault(value = "'127.0.0.1'")
    private String ip = "127.0.0.1";

    @Range(message = "端口范围为0~65535", min = 0L, max = 65535L)
    @Column(nullable = false)
    @ColumnDefault(value = "1433")
    private Integer port = 1433;

    @NotNull(message = "加密状态不能为空")
    @Column(nullable = false)
    @ColumnDefault(value = "false")
    private Boolean status = false;

    @NotNull(message = "缺省SID不能为空")
    @Column(nullable = false)
    @ColumnDefault(value = "'orcl'")
    private String sid = "orcl";


    @ColumnDefault(value = "false")
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getInterrupt() {
        return interrupt;
    }

    public void setInterrupt(Boolean interrupt) {
        this.interrupt = interrupt;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
