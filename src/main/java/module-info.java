module pickjob.spring.starter {
    requires java.sql;

    requires spring.core;
    requires spring.context;
    requires spring.beans;
    requires spring.aop;
    requires spring.web;
    requires spring.jdbc;
    requires spring.tx;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires org.apache.logging.log4j;
    requires slf4j.api;
    requires org.aspectj.weaver;

    requires com.zaxxer.hikari;
    requires mybatis;
    requires mybatis.spring;

    opens app to spring.core
            , spring.beans
            , spring.aop
            , spring.context
            ;
    opens app.aop to spring.beans
            , spring.aop
            ;
    opens app.common.keys to spring.core
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
    opens app.entity to mybatis
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