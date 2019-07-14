module pickjob.spring.starter {
    requires java.sql;

    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.aop;
    requires spring.web;
    requires spring.webmvc;
    requires spring.jdbc;
    requires spring.tx;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires org.apache.logging.log4j;
    requires org.aspectj.weaver;

    requires com.zaxxer.hikari;
    requires org.mybatis;
    requires org.mybatis.spring;
    requires mybatis.plus.core;
    requires mybatis.plus.annotation;
    requires mybatis.plus.extension;
    requires java.validation;

    requires static lombok;

    opens app to spring.core
            , spring.beans
            , spring.aop
            , spring.context
            ;
    opens app.aop to spring.beans
            , spring.aop
            ;
    opens app.aop.datasource.keys to spring.core
            ;
    opens app.config to spring.core
            , spring.beans
            , spring.context
            ;
    opens app.controller to spring.core
            , spring.beans
            , spring.aop
            , spring.web
            ;
    opens app.dao to spring.core
            , spring.beans
            , spring.aop
            ;
    opens app.entity to org.mybatis
            ;
    opens app.service to spring.core
            , spring.beans
            , spring.aop
            , spring.context
            ;
    opens app.service.scheduled to spring.beans
            , spring.context
            ;


}