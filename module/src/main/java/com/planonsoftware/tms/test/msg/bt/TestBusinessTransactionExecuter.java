package com.planonsoftware.tms.test.msg.bt;

import com.planonsoftware.platform.backend.businesstransaction.v3.IBusinessTransactionExecuter;
import com.planonsoftware.platform.backend.businesstransaction.v3.IBusinessTransactionExecuterContext;
import com.planonsoftware.platform.backend.data.v1.IBusinessObject;

public class TestBusinessTransactionExecuter implements IBusinessTransactionExecuter {
    private final IBusinessObject newBO;

    public TestBusinessTransactionExecuter(IBusinessObject businessObject) {
        this.newBO = businessObject;
    }

    @Override
    public void execute(IBusinessTransactionExecuterContext context) {
        IBusinessObject businessObject = context.getDataService().getByPrimaryKey(newBO.getBOType(),
                newBO.getPrimaryKey());
        businessObject.getStringFieldByName("Name").setValue("Some value");
        businessObject.save();
    }
}
