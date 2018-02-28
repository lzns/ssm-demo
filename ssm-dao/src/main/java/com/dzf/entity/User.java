package com.dzf.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户; InnoDB free: 5120 kB
 * </p>
 *
 * @author dingzf
 * @since 2018-02-25
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 登陆名
     */
	private String login_name;
    /**
     * 用户名
     */
	private String name;
    /**
     * 密码
     */
	private String password;
    /**
     * 密码加密盐
     */
	private String salt="###";
    /**
     * 性别
     */
	private Integer sex;
    /**
     * 年龄
     */
	private Integer age;
    /**
     * 手机号
     */
	private String phone;
    /**
     * 用户类别
     */
	private Integer user_type;
    /**
     * 用户状态
     */
	private Integer status;
    /**
     * 所属机构
     */
	private Integer organization_id;
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

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getUser_type() {
		return user_type;
	}

	public void setUser_type(Integer user_type) {
		this.user_type = user_type;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getOrganization_id() {
		return organization_id;
	}

	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "User{" +
			" id=" + id +
			", login_name=" + login_name +
			", name=" + name +
			", password=" + password +
			", salt=" + salt +
			", sex=" + sex +
			", age=" + age +
			", phone=" + phone +
			", user_type=" + user_type +
			", status=" + status +
			", organization_id=" + organization_id +
			", create_time=" + create_time +
			"}";
	}
}
