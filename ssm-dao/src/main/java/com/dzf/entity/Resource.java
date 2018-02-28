package com.dzf.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 资源; InnoDB free: 5120 kB
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public class Resource implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 资源名称
     */
	private String name;
    /**
     * 资源路径
     */
	private String url;
    /**
     * 打开方式 ajax,iframe
     */
	private String open_mode;
    /**
     * 资源介绍
     */
	private String description;
    /**
     * 资源图标
     */
	private String icon;
    /**
     * 父级资源id
     */
	private Long pid;
    /**
     * 排序
     */
	private Integer seq;
    /**
     * 状态
     */
	private Integer status;
    /**
     * 打开状态
     */
	private Integer opened;
    /**
     * 资源类别
     */
	private Integer resource_type;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getOpen_mode() {
		return open_mode;
	}

	public void setOpen_mode(String open_mode) {
		this.open_mode = open_mode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOpened() {
		return opened;
	}

	public void setOpened(Integer opened) {
		this.opened = opened;
	}

	public Integer getResource_type() {
		return resource_type;
	}

	public void setResource_type(Integer resource_type) {
		this.resource_type = resource_type;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "Resource{" +
			", id=" + id +
			", name=" + name +
			", url=" + url +
			", open_mode=" + open_mode +
			", description=" + description +
			", icon=" + icon +
			", pid=" + pid +
			", seq=" + seq +
			", status=" + status +
			", opened=" + opened +
			", resource_type=" + resource_type +
			", create_time=" + create_time +
			"}";
	}
}
