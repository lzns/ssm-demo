package com.dzf.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 组织机构; InnoDB free: 5120 kB
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public class Organization implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 组织名
     */
	private String name;
    /**
     * 地址
     */
	private String address;
    /**
     * 编号
     */
	private String code;
    /**
     * 图标
     */
	private String icon;
    /**
     * 父级主键
     */
	private Long pid;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 创建时间
     */
	private Date create_time;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "Organization{" +
			", id=" + id +
			", name=" + name +
			", address=" + address +
			", code=" + code +
			", icon=" + icon +
			", pid=" + pid +
			", seq=" + seq +
			", create_time=" + create_time +
			"}";
	}
}
