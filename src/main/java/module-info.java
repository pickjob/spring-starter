module pickjob.spring.starter {
    requires java.sql;

    requires spring.web;

    requires spring.boot;
    requires spring.boot.autoconfigure;

    opens app to spring.core
               , spring.beans
               , spring.context
               ;
    opens app.controller to spring.beans
                          , spring.web
                          ;
}