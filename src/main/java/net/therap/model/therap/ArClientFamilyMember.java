package net.therap.model.therap;

import net.therap.db.archive.annotations.Archivable;
import net.therap.db.archive.annotations.ArchiveProperty;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author jahangir
 * @since 5/15/14 9:51 AM
 */
@Embeddable
@Archivable(nodeName = "arClientFamilyMember")
public class ArClientFamilyMember implements Serializable {

    @Column(length = 64)
    @ArchiveProperty(embeddable = true)
    private String name;

    @Column(length = 32)
    @ArchiveProperty(embeddable = true)
    private String relationship;

    @ArchiveProperty(embeddable = true)
    private int age;

    @ArchiveProperty(embeddable = true)
    private double monthlyIncome;

    @Column(length = 64)
    @ArchiveProperty(embeddable = true)
    private String sourceOfIncome;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(double monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public String getSourceOfIncome() {
        return sourceOfIncome;
    }

    public void setSourceOfIncome(String sourceOfIncome) {
        this.sourceOfIncome = sourceOfIncome;
    }
}
