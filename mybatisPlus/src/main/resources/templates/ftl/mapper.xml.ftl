<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${package.Mapper}.${table.mapperName}">

<#if enableCache>
    <!-- 开启二级缓存 -->
    <cache type="org.mybatis.caches.ehcache.LoggingEhcache"/>

</#if>
<#if baseResultMap>
    <!-- 通用查询映射结果 -->
    <resultMap id="${entity}Map" type="${package.Entity}.${entity}">
<#list table.fields as field>
<#if field.keyFlag><#--生成主键排在第一位-->
        <id column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
<#list table.commonFields as field><#--生成公共字段 -->
    <result column="${field.name}" property="${field.propertyName}" />
</#list>
<#list table.fields as field>
<#if !field.keyFlag><#--生成普通字段 -->
        <result column="${field.name}" property="${field.propertyName}" />
</#if>
</#list>
    </resultMap>

</#if>

	<!-- 查询表${table.name}所有信息 -->
	<select id="find${entity}" resultMap="${entity}Map">
		select * from ${table.name}
	</select>
	
	<#list table.fields as field>
	<#if field.keyFlag>
	<!-- 根据主键${field.propertyName}查询表${table.name}信息 -->
	<select id="find${entity}By${field.propertyName}" resultMap="${entity}Map">
	    select * from ${table.name} where ${field.name}=${r"#{"}${field.propertyName}${r"}"}    
	</select>
	</#if>
	</#list>
	
	<#list table.fields as field>
	<#if field.keyFlag>
	<!-- 根据主键${field.propertyName}删除表${table.name}信息 -->
	<delete id="delete${entity}By${field.propertyName}">
	    delete from ${table.name} where ${field.name}=${r"#{"}${field.propertyName}${r"}"}    
	</delete>
	</#if>
	</#list>
	
	<#list table.fields as field>
	<#if field.keyFlag>
	<!-- 根据主键${field.propertyName}更新表${table.name}信息 -->
	<update id="update${entity}By${field.propertyName}" parameterType="${package.Entity}.${entity}">
	    update from ${table.name} set 
	    	<#list table.fields as field><#if !field.keyFlag>${field.name}=${r"#{"}${field.propertyName}${r"}"}<#sep>,</#if></#list>
	    where <#list table.fields as field><#if field.keyFlag>${field.name}=${r"#{"}${field.propertyName}${r"}"}</#if></#list>
	</update>
	</#if>
	</#list>
	
	<#list table.fields as field>
	<#if field.keyFlag>
	<!-- 新增表${table.name}信息 -->
	<insert id="add${entity}">		
		insert into ${table.name}
			(<#list table.fields as field><#if field.keyFlag>${field.name}</#if></#list><#list table.fields as field><#if !field.keyFlag>,${field.name}</#if></#list>) 
		values
			(<#list table.fields as field><#if field.keyFlag>${r"#{"}${field.propertyName}${r"}"}</#if></#list><#list table.fields as field><#if !field.keyFlag>,${r"#{"}${field.propertyName}${r"}"}</#if></#list>)
	</insert>
	</#if>
	</#list>

<#if baseColumnList>
    <!-- 通用查询结果列 -->
    <sql id="Base_Column_List">
<#list table.commonFields as field>
        ${field.name},
</#list>
        ${table.fieldNames}
    </sql>

</#if>
</mapper>
