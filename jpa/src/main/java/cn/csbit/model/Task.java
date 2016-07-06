package cn.csbit.model;

import cn.csbit.common.Global;
import cn.csbit.model.base.BaseModel;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Answer on 16/7/6.
 */
@Entity
@Table
public class Task extends BaseModel {

    @Column(nullable = false)
    private String alias;

    @Column(nullable = false)
    @ColumnDefault("-1")
    private Integer progress;

    @ManyToOne(optional = false)
    @JoinColumn(name = "datasourceId")
    private DataSource dataSource;

    private Date startTime;


    @Column(nullable = false)
    @ColumnDefault("" + Global.TaskStatus.STOP)
    private Integer status;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
