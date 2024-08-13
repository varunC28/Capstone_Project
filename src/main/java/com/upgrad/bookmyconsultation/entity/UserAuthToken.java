/*
 * Copyright 2018-2019, https://beingtechie.io.
 *
 * File: UserAuthToken.java
 * Date: May 5, 2018
 * Author: Thribhuvan Krishnamurthy
 */
package com.upgrad.bookmyconsultation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;


/**
 * User Entity JPA mapping class.
 **/
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@Column(name = "ACCESS_TOKEN", length = 1000)
	private String accessToken;

	private ZonedDateTime loginAt;

	private ZonedDateTime expiresAt;

	private ZonedDateTime logoutAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public ZonedDateTime getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(ZonedDateTime loginAt) {
		this.loginAt = loginAt;
	}

	public ZonedDateTime getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(ZonedDateTime expiresAt) {
		this.expiresAt = expiresAt;
	}

	public ZonedDateTime getLogoutAt() {
		return logoutAt;
	}

	public void setLogoutAt(ZonedDateTime logoutAt) {
		this.logoutAt = logoutAt;
	}

	@Override
	public String toString() {
		return "UserAuthToken{" +
				"id=" + id +
				", user=" + user +
				", accessToken='" + accessToken + '\'' +
				", loginAt=" + loginAt +
				", expiresAt=" + expiresAt +
				", logoutAt=" + logoutAt +
				'}';
	}
}
