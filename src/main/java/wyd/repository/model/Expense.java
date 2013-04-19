package wyd.repository.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.google.common.base.Objects;
import com.google.common.base.Objects.ToStringHelper;
import com.google.common.base.Strings;

@Entity
// @Table(name = "T_EXPENSE")
public class Expense extends AbstractModel {

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
	// @Column(name = "id")
	private Long id;

	@NotNull
	private float amount;

	@NotNull
	private String description;

	@NotNull
	private String status;

	@NotNull
	private User user;

	@Override
	public String toString() {
		ToStringHelper toStringHelper = Objects.toStringHelper(this);
		toStringHelper.add("id", this.id);
		toStringHelper.add("amount", this.amount);
		toStringHelper.add("description", this.description);
		toStringHelper.add("status", this.status);
		toStringHelper.add("createTime", this.createTime);
		toStringHelper.add("updateTime", this.updateTime);
		return toStringHelper.toString();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		status = Strings.nullToEmpty(status);
		status = status.toLowerCase();
		if (status.equals(NEW)) {
			this.status = NEW;
		} else if (status.equals(ENABLED)) {
			this.status = ENABLED;
		} else {
			this.status = DISABLED;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
