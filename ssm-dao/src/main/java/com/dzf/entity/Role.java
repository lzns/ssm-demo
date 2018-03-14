package com.dzf.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色; InnoDB free: 5120 kB
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long roleId;
    /**
     * 角色名
     */
    @TableField(value = "name")
	private String roleName;
    /**
     * 排序号
     */
	private Integer seq;
    /**
     * 简介
     */
	private String description;
    /**
     * 状态
     */
    @TableField(value = "status")
	private Integer roleStatus;

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleStatus() {
		return roleStatus;
	}

	public void setRoleStatus(Integer roleStatus) {
		this.roleStatus = roleStatus;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Role{" +
				"roleId=" + roleId +
				", roleName='" + roleName + '\'' +
				", seq=" + seq +
				", description='" + description + '\'' +
				", roleStatus=" + roleStatus +
				'}';
	}
}
