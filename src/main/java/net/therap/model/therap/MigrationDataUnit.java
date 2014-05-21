package net.therap.model.therap;

import net.therap.db.entity.common.Client;
import net.therap.db.entity.common.ClientDetail;
import net.therap.db.entity.medicalInfo.IndividualDiagnosis;
import net.therap.util.CollectionUtils;

import java.util.List;

/**
 * @author ashraf
 * @since 5/21/14
 */
public class MigrationDataUnit {
    private Client client;
    private ClientDetail clientDetail;
    private ArClient arClient;
    private List<IndividualDiagnosis> individualDiagnosisList;

    public MigrationDataUnit(Client client, ClientDetail clientDetail, ArClient arClient, List<IndividualDiagnosis> individualDiagnosisList) {
        this.client = client;
        this.clientDetail = clientDetail;
        this.arClient = arClient;
        this.individualDiagnosisList = individualDiagnosisList;

        client.setClientDetail(clientDetail);
        clientDetail.setClient(client);

        arClient.setClient(client);

        if (CollectionUtils.isNotEmpty(individualDiagnosisList)) {
            for (IndividualDiagnosis diagnosis : individualDiagnosisList) {
                diagnosis.setClient(client);
            }
        }

    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ClientDetail getClientDetail() {
        return clientDetail;
    }

    public void setClientDetail(ClientDetail clientDetail) {
        this.clientDetail = clientDetail;
    }

    public ArClient getArClient() {
        return arClient;
    }

    public void setArClient(ArClient arClient) {
        this.arClient = arClient;
    }

    public List<IndividualDiagnosis> getIndividualDiagnosisList() {
        return individualDiagnosisList;
    }

    public void setIndividualDiagnosisList(List<IndividualDiagnosis> individualDiagnosisList) {
        this.individualDiagnosisList = individualDiagnosisList;
    }
}
