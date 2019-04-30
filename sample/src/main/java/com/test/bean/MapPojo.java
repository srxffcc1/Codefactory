package com.test.bean;

//import com.ay.framework.annotation.PersistenceIgnore;

import com.ay.framework.core.pojo.BasePojo;

/**
 * @Description
 * @date 2013-4-23
 * @author WangXin
 */
@SuppressWarnings("all")
public abstract class MapPojo extends BasePojo {
//	@PersistenceIgnore
	private String hasMap;

	public String getHasMap() {
		return hasMap;
	}

//	@PersistenceIgnore
	private String hasCamera;

	public String getHasCamera() {
		return hasCamera;
	}

	public void setHasCamera(String hasCamera) {
		this.hasCamera = hasCamera;
	}

	public void setHasMap(String hasMap) {
		this.hasMap = hasMap;
	}

	public abstract MapType getMapType();
}
