package com.example.organizationservice.events.source;

import com.example.organizationservice.events.model.OrganizationChangeModel;
import com.example.organizationservice.utils.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleSourceBean {
    private Source source;
    @Autowired public SimpleSourceBean(Source source){
        this.source =source;
    }
    public void publishOrganizationChanges(String action, String organizationId){
        String s = String.format("Sending kafka message %s for Organization Id: %s",action,organizationId);
        System.out.println(s);
        OrganizationChangeModel change  = new OrganizationChangeModel(
                OrganizationChangeModel.class.getTypeName(),
                action,
                organizationId,
                UserContext.getCorrelationId()
        );
        source.output().send(MessageBuilder.withPayload(change).build());
    }

}
