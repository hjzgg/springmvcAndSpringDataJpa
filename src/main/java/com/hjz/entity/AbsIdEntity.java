package com.hjz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.sql.Timestamp;

@MappedSuperclass
public abstract class AbsIdEntity implements Serializable {

	private static final long serialVersionUID = 7988377299341530426L;

    public final static int IS_DELETE_YES = 1;// 标记删除
    public final static int IS_DELETE_NO = 0;// 未删除,保留的

	@Id
    @GenericGenerator(name="uuid", strategy="uuid")
    @GeneratedValue(generator="uuid")
    protected String id;

    @Column(name = "creationtime")
    protected Timestamp creationTimestamp = new Timestamp(System.currentTimeMillis());

    @Column(name = "lastmodifiedtime")
    protected Timestamp modificationTimestamp = new Timestamp(System.currentTimeMillis());
    
    @Column(name = "dr")
    protected int dr;// 是否删除。0:未删除;1:已删除

    /**
     * 主键，对应id字段
     */
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    /**
     * 创建日期，对应ts_insert字段
     */
    public Timestamp getCreationTimestamp() { return creationTimestamp; }
    public void setCreationTimestamp(Timestamp creationTimestamp) { this.creationTimestamp = creationTimestamp; }

    /**
     * 修改日期，对应ts_update字段
     */
    public Timestamp getModificationTimestamp() { return modificationTimestamp; }
    public void setModificationTimestamp(Timestamp modificationTimestamp) { this.modificationTimestamp = modificationTimestamp; }

    /**
     * 是否删除，对应dr字段
     * @return
     */
    public int getDr() {
		return dr;
	}
	public void setDr(int dr) {
		this.dr = dr;
	}

}
