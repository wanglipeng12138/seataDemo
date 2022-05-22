package com.demo.seata.service;

import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;

@LocalTCC
public interface OrderTCCService {

    /**
     * 执行资源检查及预留操作
     */
    @TwoPhaseBusinessAction(name = "addOrder", commitMethod = "commit", rollbackMethod = "rollback")
    void addOrder(@BusinessActionContextParameter(paramName = "productId") String productId, @BusinessActionContextParameter(paramName = "totalAmount") Integer totalAmount);

    /**
     * 全局事务提交
     */
    void commit(BusinessActionContext actionContext);

    /**
     * 全局事务回滚
     */
    void rollback(BusinessActionContext actionContext);
}
