package com.gmail.evanloafakahaitao.hwk.hwk25;

import com.gmail.evanloafakahaitao.hwk.hwk25.model.Client;

public interface ClientDao {

    void save(Client client);

    Client getById(Long id);
}
