package org.mea.util;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;

public class Page<T> {

    private final List<T> results;
    private final int pageSize;
    private final int pageNumber;
    private int recordTotal;

    public Page(Query query, int pageNumber, int pageSize, int recordTotal) {
        this(query, ++pageNumber, pageSize);
        this.recordTotal = recordTotal;
    }

    public Page(Query query, int pageNumber, int pageSize) {
        int currentPageNo = pageNumber;
        if (pageNumber < 1) {
            currentPageNo = 1;
        }

        this.pageNumber = currentPageNo;
        if (pageSize > 0) {
            query.setFirstResult((currentPageNo - 1) * pageSize);
            query.setMaxResults(pageSize + 1);
            this.pageSize = pageSize;
        } else {
            this.pageSize = -1;
        }
        this.results = query.list();
    }

    public Page(Criteria criteria, int pageNumber, int pageSize) {
        int currentPageNo = pageNumber;
        if (pageNumber < 1) {
            currentPageNo = 1;
        }

        this.pageNumber = currentPageNo;

        if (pageSize > 0) {
            criteria.setFirstResult((currentPageNo - 1) * pageSize);
            criteria.setMaxResults(pageSize + 1);
            this.pageSize = pageSize;
        } else {
            this.pageSize = -1;
        }
        this.results = criteria.list();
    }
    
    public Page(int pageNumber,int pageSize,List<T> results)
    {
        int currentPageNo = pageNumber;
        if (pageNumber < 1) {
            currentPageNo = 1;
        }

        this.pageNumber = currentPageNo;
        this.pageSize = pageSize;
        this.results= results;
        
    }

    public Page(TypedQuery<T> query, int pageNumber, int pageSize, int recordTotal) {
        int currentPageNo = pageNumber;
        if (pageNumber < 1) {
            currentPageNo = 1;
        }

        this.pageNumber = currentPageNo;

        if (pageSize > 0) {
            query.setFirstResult((currentPageNo - 1) * pageSize);
            query.setMaxResults(pageSize + 1);
            this.pageSize = pageSize;
        } else {
            this.pageSize = -1;
        }
        this.results = query.getResultList();
        this.recordTotal = recordTotal;
    }

    public boolean isNextPage() {
        return this.pageSize != -1 && this.results.size() > this.pageSize;
    }

    public boolean isPreviousPage() {
        return this.pageNumber > 0;
    }

    public List<T> getList() {
        return isNextPage() ? this.results.subList(0, this.pageSize) : this.results;
    }

    public int getPageNo() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public int getRecordTotal() {
        return this.recordTotal;
    }
}
