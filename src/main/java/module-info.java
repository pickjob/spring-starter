module pickjob.spring.starter {
    requires java.sql;

    requires spring.web;
    requires spring.context;
    requires org.aspectj.weaver;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires org.apache.logging.log4j;
    requires slf4j.api;

    opens app to spring.core
               , spring.beans
               , spring.context
               ;
    opens app.config to spring.core
                      , spring.beans
                      , spring.context
                      ;
    opens app.aop to spring.beans
                   , spring.aop
                   ;
    opens app.controller to spring.core
                          , spring.beans
                          , spring.aop
                          , spring.web
                          ;
    opens app.service.scheduled to spring.beans
                                 , spring.context
                                 ;
}