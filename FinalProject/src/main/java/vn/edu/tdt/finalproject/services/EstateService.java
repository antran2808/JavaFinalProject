package vn.edu.tdt.finalproject.services;

import java.util.List;
import vn.edu.tdt.finalproject.repositories.EstateRepository;
import vn.edu.tdt.finalproject.repositories.entities.estates.EstateDTO;

public class EstateService {

    private static EstateService instance;

    private EstateService() {
    }

    public static EstateService getInstance() {
        return instance = instance == null ? new EstateService() : instance;
    }

    public List<EstateDTO> getAllEstate() throws Exception {
        EstateRepository repo = new EstateRepository();
        return repo.get();
    }

    public EstateDTO findById(String id) throws Exception {
        EstateRepository repo = new EstateRepository();
        List<EstateDTO> list = repo.get();
        for (EstateDTO e : list) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }
}
