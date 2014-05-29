package net.therap.model.ar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author jawad
 * @since 5/28/14  3:42 PM
 */
@Entity
@Table(name = "AR_DDS_IFSP_SERIALIZED")
public class DdsIfspSerialized {
    @Id
    @Column(name = "client_id")
    private long clientId;
    @Column(name = "type")
    private String type;

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
