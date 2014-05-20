package net.therap.model.therap;

import net.therap.db.archive.annotations.Archivable;
import net.therap.db.archive.annotations.ArchiveProperty;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jahangir
 * @since 5/4/14 11:36 AM
 */
@Embeddable
@Archivable(nodeName = "arEligibilityDuration")
public class ArEligibilityDuration implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @ArchiveProperty(embeddable = true)
    private Date beginDate;

    @Temporal(TemporalType.TIMESTAMP)
    @ArchiveProperty(embeddable = true)
    private Date endDate;

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
