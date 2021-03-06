package com.aol.micro.server.config;

import lombok.Getter;
import nonautoscan.com.aol.micro.server.AopConfig;
import nonautoscan.com.aol.micro.server.MiscellaneousConfig;
import nonautoscan.com.aol.micro.server.ScheduleAndAsyncConfig;

import com.aol.micro.server.events.ConfigureActiveJobsAspect;
import com.aol.micro.server.module.ConfigureEnviroment;
import com.aol.micro.server.rest.resources.ConfigureResources;
import com.aol.micro.server.spring.datasource.DataSourceBuilder;
import com.aol.micro.server.spring.datasource.JdbcConfig;
import com.aol.micro.server.spring.datasource.hibernate.DAOProvider;
import com.aol.micro.server.spring.datasource.hibernate.GenericHibernateService;
import com.aol.micro.server.spring.datasource.hibernate.HibernateConfig;
import com.aol.micro.server.spring.datasource.hibernate.SpringDataConfig;
import com.aol.micro.server.spring.datasource.jdbc.RomaRowMapperConfig;
import com.aol.micro.server.spring.datasource.jdbc.SQL;
import com.aol.micro.server.spring.metrics.CodahaleMetricsConfigurer;
import com.aol.micro.server.spring.properties.PropertyFileConfig;

/**
 * 
 * Collections of Spring configuration classes (Classes annotated with @Configuration)
 * that configure various useful pieces of functionality - such as property file loading,
 * datasources, scheduling etc
 * 
 * @author johnmcclean
 *
 */
public enum Classes {

	/**
	 * CORE CLASSES are the Core Microserver Spring Configuration classes
	 * Property support, Guava Event Bus, Spring AOP &amp; Scheduling
	 * Codahale Metrics, Event tracking etc
	 */
	CORE_CLASSES(PropertyFileConfig.class, MiscellaneousConfig.class, AopConfig.class, CodahaleMetricsConfigurer.class,
			ConfigureActiveJobsAspect.class, ScheduleAndAsyncConfig.class, ConfigureResources.class, ConfigureEnviroment.class),
	JDBC_CLASSES(JdbcConfig.class, DAOProvider.class, DataSourceBuilder.class, SQL.class, SpringDataConfig.class),
	ROMA_ROW_MAPPER(RomaRowMapperConfig.class),
	HIBERNATE_CLASSES(HibernateConfig.class, JdbcConfig.class, GenericHibernateService.class, DAOProvider.class, DataSourceBuilder.class, SQL.class),
	SPRING_DATA_CLASSES(SpringDataConfig.class),
	DATASOURCE_CLASSES(JdbcConfig.class, DataSourceBuilder.class);

	@Getter
	private final Class[] classes;

	private Classes(Class... classes) {
		this.classes = classes;
	}

}
