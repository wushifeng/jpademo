package cn.csbit.model;

import cn.csbit.model.base.BaseModel;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Answer on 16/7/5.
 */
@Entity
@Table
public class ColumnDetail extends BaseModel {

    @Column(nullable = false)
    private String column;

    @Column(nullable = false)
    private Boolean status;

    @Column(nullable = false)
    @ColumnDefault("1")
    private Integer algorithm;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(Integer algorithm) {
        this.algorithm = algorithm;
    }
}
