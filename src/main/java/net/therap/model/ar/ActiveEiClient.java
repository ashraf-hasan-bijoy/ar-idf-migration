package net.therap.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author jawad
 * @since 5/28/14  3:39 PM
 */
@Entity
@Table(name = "Active_Ei_Client")
public class ActiveEiClient {

    @Column(name = "client_id")
    private long clientId;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }
}
