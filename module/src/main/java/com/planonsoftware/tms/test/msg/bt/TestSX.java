package com.planonsoftware.tms.test.msg.bt;

import java.math.BigDecimal;

import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRule;
import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRuleContext;
import com.planonsoftware.platform.backend.businesstransaction.v3.IBusinessTransactionService;
import com.planonsoftware.platform.backend.connector.v2.messaging.IMessageConnectorService;
import com.planonsoftware.platform.backend.connector.v2.messaging.out.IOutboundMessageBuilder;
import com.planonsoftware.platform.backend.data.v1.IBusinessObject;

public class TestSX implements IBusinessRule
{
	@Override
	public void execute(IBusinessObject aBO, IBusinessObject aOldBO, IBusinessRuleContext aContext) {
		IBusinessTransactionService businessTransactionService =  aContext.getBusinessTransactionService();
        businessTransactionService.execute(new TestBusinessTransactionExecuter(aBO));

        IMessageConnectorService messageConnectorService = aContext.getMessageConnectorService();
        IOutboundMessageBuilder  outboundMessageBuilder= messageConnectorService.createNewOutboundMessageBuilder();
        outboundMessageBuilder.addAdditionalInfo("info1", "Value1");
        outboundMessageBuilder.addStringFieldByName("field1", "field1");
        outboundMessageBuilder.addIntegerFieldByName("field2", 11);
        outboundMessageBuilder.addBooleanFieldByName("field3", true);
        outboundMessageBuilder.addBigDecimalFieldByName("field4", BigDecimal.ONE);

        outboundMessageBuilder.buildAndSave();
        
	}
}
