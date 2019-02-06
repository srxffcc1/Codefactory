package com.ay.framework.annotation;

import java.lang.annotation.*;

/** 
 * @Description 
 * @date 2013-2-20
 * @author WangXin
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ChineseName {
	public String value() default "";
}