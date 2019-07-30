-- 定时任务
CREATE TABLE schedule_job (
  job_id bigint PRIMARY KEY AUTO_INCREMENT COMMENT '任务id',
  bean_name varchar(200) NOT NULL COMMENT 'spring bean名称',
  bean_method varchar(200) NOT NULL COMMENT 'spring bean方法',
  method_params varchar(2000) DEFAULT NULL COMMENT '方法参数',
  cron_expression varchar(100) DEFAULT NULL COMMENT 'cron表达式',
  type tinyint NOT NULL COMMENT '定时任务类型: 1-spring 2-quartz',
  status tinyint NOT NULL COMMENT '任务状态: 0-正常 1-暂停 2-删除',
  remark varchar(255) DEFAULT NULL COMMENT '备注',
  create_time datetime DEFAULT NULL COMMENT '创建时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='定时任务';