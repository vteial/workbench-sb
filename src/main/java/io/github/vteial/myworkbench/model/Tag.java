package io.github.vteial.myworkbench.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
// @Table(name = "T_TAG")
public class Tag extends AbstractModel {

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "id")
	private Long id;

	// @Column(name = "parent_id")
	private Long parentId;

	// @Column(name = "name")
	@NotNull
	private String name;

	@NotNull
	private User user;

	@Override
	public String toString() {
		// ToStringHelper toStringHelper = Objects.toStringHelper(this);
		// toStringHelper.add("id", this.id);
		// toStringHelper.add("name", this.name);
		// toStringHelper.add("parentId", this.parentId);
		// toStringHelper.add("createdTime", this.createdTime);
		// toStringHelper.add("updatedTime", this.updatedTime);
		// return toStringHelper.toString();
		return this.name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
