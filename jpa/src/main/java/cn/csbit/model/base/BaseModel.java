package cn.csbit.model.base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体基类,重写toString,hashCode,equals方法.
 *
 * @author Credo
 * @date: 2014年8月12日
 */
@MappedSuperclass
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 6494888277191966864L;

    @Id
    @GeneratedValue
    @Column(unique = true, nullable = false)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
