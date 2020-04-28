package com.planonsoftware.tms.test.msg.bt;

import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRule;
import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRuleContext;
import com.planonsoftware.platform.backend.businesstransaction.v3.IBusinessTransactionExecuter;
import com.planonsoftware.platform.backend.businesstransaction.v3.IBusinessTransactionExecuterContext;
import com.planonsoftware.platform.backend.businesstransaction.v3.IBusinessTransactionService;
import com.planonsoftware.platform.backend.connector.v2.messaging.IMessageConnectorService;
import com.planonsoftware.platform.backend.data.v1.IBusinessObject;

public class TestSX implements IBusinessRule
{
	@Override
	public void execute(IBusinessObject aBO, IBusinessObject aOldBO, IBusinessRuleContext aContext) {
		IBusinessTransactionService businessTransactionService =  aContext.getBusinessTransactionService();
        businessTransactionService.execute(new IBusinessTransactionExecuter(){
            @Override
            public void execute(IBusinessTransactionExecuterContext aContext) {
                // aContext.get
            }
        });
        IMessageConnectorService messageConnectorService = aContext.getMessageConnectorService();
        messageConnectorService.createNewOutboundMessageBuilder();
	}
}
