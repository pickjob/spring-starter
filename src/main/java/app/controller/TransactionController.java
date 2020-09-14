package app.controller;

import app.model.MyResponse;
import app.service.TransactionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author pickjob@126.com
 * @Date 2020-09-01
 */
@Tag(name = "同一事务情况")
@RequestMapping("/v1/transaction")
@RestController
public class TransactionController {
    @Autowired TransactionService userService;

    @Operation(
            summary = "同一个事务 AUTO_INCREMENT 字段会增加，回滚也会丢失",
            security = { @SecurityRequirement(name = "auth") }
    )
    @GetMapping("/one-transaction/rollback")
    public MyResponse autoIncrementAndRallbackOneTransaction() {
        userService.autoIncrementAndRallbackOneTransaction();
        return MyResponse.success();
    }

    @Operation(
            summary = "同一个事务 AbstractDataSource 不会切换数据源",
            security = { @SecurityRequirement(name = "auth") }
    )
    @GetMapping("/one-transaction/datasource-aop")
    public MyResponse dataSourceAopOneTransaction() {
        userService.dataSourceAopOneTransaction();
        return MyResponse.success();
    }

    @Operation(
            summary = "多数据源 错误 transactionManager 失败回滚无效",
            security = { @SecurityRequirement(name = "auth") }
    )
    @GetMapping("/one-transaction/multi-datasource/rollback-fail")
    public MyResponse multiDataSourceOneTransactionRollbackFail() {
        userService.multiDataSourceOneTransactionRollbackFail();
        return MyResponse.success();
    }

    @Operation(
            summary = "多数据源, chainedTransactionManager 回滚成功",
            security = { @SecurityRequirement(name = "auth") }
    )
    @GetMapping("/one-transaction/multi-datasource/rollback-success")
    public MyResponse multiDataSourceOneTransactionRollbackSuccess() {
        userService.multiDataSourceOneTransactionRollbackSuccess();
        return MyResponse.success();
    }
}
