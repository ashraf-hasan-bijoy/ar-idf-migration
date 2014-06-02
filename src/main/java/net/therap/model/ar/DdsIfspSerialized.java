package net.therap.model.ar;

import javax.persistence.*;

/**
 * @author jawad
 * @since 5/28/14  3:42 PM
 */
@Entity
@Table(name = "AR_DDS_IFSP_SERIALIZED")
public class DdsIfspSerialized {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "client_id")
    private Long clientId;
    @Column(name = "type")
    private String type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
