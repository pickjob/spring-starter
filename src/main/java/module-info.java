module pickjob.spring.starter {
    requires java.sql;

    requires spring.web;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    requires org.apache.logging.log4j;

    opens app to spring.core
               , spring.beans
               , spring.context
               ;
    opens app.controller to spring.beans
                          , spring.web
                          ;
}