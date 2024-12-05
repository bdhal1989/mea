
package org.mea.model;

import java.io.Serializable;
import java.util.Date;


/**
 * Old base entity class
 *
 * @deprecated
 **/
@Deprecated
public class BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;
    /*
     * Base class cannot be indexed only subclasses can be indexed for Lucene refer:
     * http://opensource.atlassian.com/projects/hibernate/browse/HSEARCH-333
     */
    protected Long id;
    protected Long createdBy;
    protected Date createdDate;
    protected Long modifiedBy;
    protected Date modifiedDate;

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(final Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(final Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(final Long modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(final Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final BaseModel other = (BaseModel) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
