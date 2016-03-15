package com.hawk.contact.state;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.eventbus.EventBus;
import com.hawk.contact.model.ContactAccount;
import com.hawk.contact.model.ContactUserProfile;

/**
 * Created by heyong on 16/3/10.
 */
public class ApplicationState implements BaseState, UserState {

    private EventBus eventBus;
    private ContactAccount contactAccount;
    private ContactUserProfile contactUserProfile;
    private String username;

    public ApplicationState(EventBus eventBus) {
        eventBus = Preconditions.checkNotNull(eventBus, "EventBus cannot be null");
    }

    @Override
    public void setCurrentAccount(ContactAccount account) {
        if(Objects.equal(contactAccount, account)) {
            contactAccount = account;
            eventBus.post(new AccountChangedEvent());
        }
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public ContactAccount getCurrentAccount() {
        return contactAccount;
    }

    @Override
    public void registerForEvents(Object receiver) {
        eventBus.register(receiver);
    }

    @Override
    public void unregisterForEvents(Object receiver) {
        eventBus.unregister(receiver);
    }
}
