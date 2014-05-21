package net.therap.util;

import net.therap.db.entity.common.Client;
import net.therap.db.entity.common.ClientDetail;
import net.therap.db.entity.medicalInfo.IndividualDiagnosis;
import net.therap.model.ar.*;
import net.therap.model.therap.ArClient;
import net.therap.model.therap.ArClientFamilyMember;
import net.therap.model.therap.ArEligibilityDuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashraf
 * @since 5/20/14
 */
public class TherapDomainFactory {

    public static Client createClient(CmsMaster cmsMaster, DdsRoot ddsRoot) {
        return null;
    }

    public static ClientDetail createClientDetail(CmsMaster cmsMaster, DdsRoot ddsRoot) {
        return null;
    }

    public static ArClient createArClient(CmsMaster cmsMaster, DdsRoot ddsRoot, DdsCmFinance finance,
                                          MedicalDenial denial, DdsField field) {
        return null;
    }

    public static List<ArClientFamilyMember> createArClientFamilyMembers(DdsCmFinance finance) {
        return null;
    }

    public static List<ArEligibilityDuration> createArEligibilityDurations(CmsMaster master) {
        return null;
    }

    public static List<IndividualDiagnosis> createIndividualDiagnosisList(CmsMaster master) {
        return null;
    }

}
