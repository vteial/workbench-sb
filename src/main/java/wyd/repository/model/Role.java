package wyd.repository.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Strings;

@Entity
// @Table(name = "T_ROLE")
public class Role extends AbstractModel {

	@PreUpdate
	public void preUpdate() {
		this.updateTime = new Date();
	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.createTime = now;
		this.updateTime = now;
	}

	@Override
	public String toString() {
		ToStringHelper toStringHelper = Objects.toStringHelper(this);
		toStringHelper.add("id", this.id);
		toStringHelper.add("name", this.name);
		toStringHelper.add("status", this.status);
		toStringHelper.add("createTime", this.createTime);
		toStringHelper.add("updateTime", this.updateTime);
		return toStringHelper.toString();
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	@Id
	private String id;

	@NotNull
	private String name;

	@NotNull
	private String status;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
	private Collection<User> users = new ArrayList<User>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		status = Strings.nullToEmpty(status);
		status = status.toLowerCase();
		if (status.equals(ENABLED)) {
			this.status = ENABLED;
		} else {
			this.status = DISABLED;
		}
	}

	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}
}
