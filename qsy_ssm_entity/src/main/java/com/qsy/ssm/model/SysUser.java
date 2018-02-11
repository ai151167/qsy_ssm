package com.qsy.ssm.model;

import java.util.Date;

public class SysUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.username
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.password
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.flag
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Boolean flag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.created_user
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Integer createdUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.updated_user
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Integer updatedUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.created_time
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Date createdTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.updated_time
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Date updatedTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.Email
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.activate
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Boolean activate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.admin
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Boolean admin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.userUUID
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private String useruuid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.score
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    private Integer score;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.id
     *
     * @return the value of sys_user.id
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.id
     *
     * @param id the value for sys_user.id
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.username
     *
     * @return the value of sys_user.username
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.username
     *
     * @param username the value for sys_user.username
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.password
     *
     * @return the value of sys_user.password
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.password
     *
     * @param password the value for sys_user.password
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.flag
     *
     * @return the value of sys_user.flag
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.flag
     *
     * @param flag the value for sys_user.flag
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.created_user
     *
     * @return the value of sys_user.created_user
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Integer getCreatedUser() {
        return createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.created_user
     *
     * @param createdUser the value for sys_user.created_user
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setCreatedUser(Integer createdUser) {
        this.createdUser = createdUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.updated_user
     *
     * @return the value of sys_user.updated_user
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Integer getUpdatedUser() {
        return updatedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.updated_user
     *
     * @param updatedUser the value for sys_user.updated_user
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setUpdatedUser(Integer updatedUser) {
        this.updatedUser = updatedUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.created_time
     *
     * @return the value of sys_user.created_time
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.created_time
     *
     * @param createdTime the value for sys_user.created_time
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.updated_time
     *
     * @return the value of sys_user.updated_time
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.updated_time
     *
     * @param updatedTime the value for sys_user.updated_time
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.Email
     *
     * @return the value of sys_user.Email
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.Email
     *
     * @param email the value for sys_user.Email
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.activate
     *
     * @return the value of sys_user.activate
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Boolean getActivate() {
        return activate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.activate
     *
     * @param activate the value for sys_user.activate
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setActivate(Boolean activate) {
        this.activate = activate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.admin
     *
     * @return the value of sys_user.admin
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Boolean getAdmin() {
        return admin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.admin
     *
     * @param admin the value for sys_user.admin
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.userUUID
     *
     * @return the value of sys_user.userUUID
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public String getUseruuid() {
        return useruuid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.userUUID
     *
     * @param useruuid the value for sys_user.userUUID
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setUseruuid(String useruuid) {
        this.useruuid = useruuid == null ? null : useruuid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user.score
     *
     * @return the value of sys_user.score
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public Integer getScore() {
        return score;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user.score
     *
     * @param score the value for sys_user.score
     *
     * @mbg.generated Tue Sep 26 16:32:30 CST 2017
     */
    public void setScore(Integer score) {
        this.score = score;
    }
}